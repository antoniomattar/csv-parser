package fr.univamu.csvparser.data;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DoubleDataTest {

  private final Data<Double> doubleData = new DoubleData();

  @Test
  void testReadValidDouble() throws Exception {
    assertEquals(42.0, doubleData.read("42"));
    assertEquals(0.0, doubleData.read("0.0"));
    assertEquals(-15.5, doubleData.read("-15.5"));
  }

  @Test
  void testReadInvalidDouble() {
    try {
      doubleData.read("abc");
    } catch (Exception e) {
      assertEquals(
        "Mismatch when reading a string, expecting double but got abc",
        e.toString()
      );
    }
    try {
      doubleData.read("");
    } catch (Exception e) {
      assertEquals(
        "Mismatch when reading a string, expecting double but got <nothing>",
        e.toString()
      );
    }
  }


  // TODO décommenter le test
//  @Test
//  void testMismatchException() {
//    assertThrows(DataMismatchException.class, () -> doubleData.read("abc"));
//    try {
//      doubleData.read("4.2.1");
//    } catch (DataMismatchException e) {
//      assertNotNull(e.getCause());
//      assertEquals(NumberFormatException.class, e.getCause().getClass());
//    }
//  }

  @Test
  void testFormatValidDouble() throws Exception {
    assertEquals("42.0", doubleData.format(42.0));
    assertEquals("0.0", doubleData.format(0.0));
    assertEquals("-15.5", doubleData.format(-15.5));
  }
}