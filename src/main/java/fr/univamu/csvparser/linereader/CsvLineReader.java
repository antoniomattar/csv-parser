package fr.univamu.csvparser.linereader;


import fr.univamu.csvparser.data.DataMismatchException;

import java.util.Iterator;
import java.util.Scanner;

public class CsvLineReader<R,S> implements LineReader<R> {

  private final LineDescription<S,R> lineDescription;
  private final S s;
  private final String separator;

  public CsvLineReader(LineDescription<S,R> lineDescription, S s, String separator) {
    this.lineDescription = lineDescription;
    this.s = s;
    this.separator = separator;
  }

  @Override
  public R read(String line) throws DataMismatchException {
    try (Scanner scanner = new Scanner(line)) {
      scanner.useDelimiter(separator);
      Iterator<String> tokens = scanner.tokens().iterator();
      return lineDescription.read(s,tokens);
    }
  }
}
