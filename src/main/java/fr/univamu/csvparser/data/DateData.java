package fr.univamu.csvparser.data;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;


public class DateData implements Data<LocalDate> {

  private final DateTimeFormatter formatter;

  public DateData(DateTimeFormatter formatter) {
    this.formatter = formatter;
  }

  public DateData() {
    this.formatter = DateTimeFormatter.ISO_LOCAL_DATE;
  }


  @Override
  public LocalDate read(String text) throws DataMismatchException {
    try{
      return LocalDate.parse(text, formatter);
    } catch (DateTimeParseException e2) {
      throw new DataMismatchException("date", text, e2);
    }


  }

  @Override
  public String format(LocalDate data) {
    return data.format(formatter);
  }
}
