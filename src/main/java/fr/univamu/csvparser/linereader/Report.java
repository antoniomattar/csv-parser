package fr.univamu.csvparser.linereader;


import fr.univamu.csvparser.linereader.exceptions.LineReaderException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class Report<T> implements Iterable<T>{

  private final LineReader<T> lineReader;
  // TODO ajouter des propriétés avec accesseurs


  public Report(LineReader<T> lineReader) {
    this.lineReader = lineReader;
  }

  public static <T> Report<T> fromFile(
    Path path,
    LineReader<T> lineReader,
    int skippedLines
  ) throws IOException {
    // TODO
    return null;
  }

  public static <T> Report<T> fromFile(Path path, LineReader<T> lineReader) throws IOException {
    // TODO
    return null;
  }

  public List<T> getLines() {
    // TODO
    return null;
  }

  public List<LineReaderException> getExceptions() {
    // TODO
    return null;
  }


  public void read(String line) {
    // TODO
  }


  public void merge(Report<T> report) {
    // TODO
  }


  @Override
  public Iterator<T> iterator() {
    // TODO
    return null;
  }

}
