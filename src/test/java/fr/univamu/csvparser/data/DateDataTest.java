package fr.univamu.csvparser.data;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static org.junit.jupiter.api.Assertions.*;

class DateDataTest {

  private final Data<LocalDate> dateData = new DateData();

  @Test
  void testReadValidDate() throws Exception {
    assertEquals(
      LocalDate.parse("2024-11-20", DateTimeFormatter.ISO_LOCAL_DATE),
      dateData.read("2024-11-20")
    );
    assertEquals(
      LocalDate.parse("2000-01-01", DateTimeFormatter.ISO_LOCAL_DATE),
      dateData.read("2000-01-01")
    );
  }

  @Test
  void testReadInvalidDate() {
    try {
      dateData.read("20-11-2024");
      fail("invalid date accepted");
    } catch (Exception e) {
      assertEquals(
        "Mismatch when reading a string, expecting date but got 20-11-2024",
        e.toString()
      );
    }
    try {
      dateData.read("");
      fail("invalid date accepted");
    } catch (Exception e) {
      assertEquals(
        "Mismatch when reading a string, expecting date but got <nothing>",
        e.toString()
      );
    }
  }

  @Test
  void testFormatValidDate() throws Exception {
    assertEquals("2024-11-20", dateData.format(
      LocalDate.parse("2024-11-20", DateTimeFormatter.ISO_LOCAL_DATE)
    ));
    assertEquals("2000-01-01", dateData.format(
      LocalDate.parse("2000-01-01", DateTimeFormatter.ISO_LOCAL_DATE)
    ));
  }

}