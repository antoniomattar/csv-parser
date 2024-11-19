package fr.univamu.csvparser.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


public class DateData implements Data<LocalDate> {

  private final DateTimeFormatter formatter;

  public DateData(DateTimeFormatter formatter) {
    this.formatter = formatter;
  }

  public DateData() {
    this.formatter = DateTimeFormatter.ISO_LOCAL_DATE;
  }


  @Override
  public LocalDate read(String text) {
    // TODO
    return null;

  }

  @Override
  public String format(LocalDate data) {
    // TODO
    return null;
  }
}
