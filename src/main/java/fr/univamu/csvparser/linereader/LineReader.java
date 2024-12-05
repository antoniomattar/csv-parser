package fr.univamu.csvparser.linereader;


import fr.univamu.csvparser.data.DataMismatchException;

public interface LineReader<R> {

  R read(String line) throws DataMismatchException;

  static <R,S> LineReader<R> commaSeparated(LineDescription<S,R> lineDescription, S s) {
    return new CsvLineReader<>(lineDescription, s, ",");
  }

}
