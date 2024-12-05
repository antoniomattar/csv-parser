package fr.univamu.csvparser.linereader;


import fr.univamu.csvparser.linereader.exceptions.LineReaderException;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Report<T> implements Iterable<T> {

  private final LineReader<T> lineReader;
  private final List<T> lines;
  private final List<LineReaderException> exceptions;
  private final int linecount;


  public Report(LineReader<T> lineReader) {
    this.lineReader = lineReader;
    this.lines = new ArrayList<>();
    this.exceptions = new ArrayList<>();
    this.linecount = 0;
  }

////  public List<T> getLines(){
////    return lines;
////  }
//
//  public int getLineCount(){
//    return linecount;
//  }
//  public List<LineReaderException> getException(){
//    return exceptions;

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
    return lines;
  }

  public List<LineReaderException> getExceptions() {
    // TODO
    return exceptions;
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
    return lines.iterator();
  }

}
