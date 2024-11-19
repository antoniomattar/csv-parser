package fr.univamu.csvparser.linereader;


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
  public R read(String line)  {
    // TODO
    return null;
  }
}
