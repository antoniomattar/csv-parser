package fr.univamu.csvparser.linereader;


public interface LineReader<R> {

  R read(String line);

  static <R,S> LineReader<R> commaSeparated(LineDescription<S,R> lineDescription, S s) {
    return new CsvLineReader<>(lineDescription, s, ",");
  }

}
