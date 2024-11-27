package fr.univamu.csvparser.data;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class IntDataTest {

    private final Data<Integer> intData = new IntData();

    @Test
    void testReadValidInteger() throws Exception {
      assertEquals(42, intData.read("42"));
      assertEquals(0, intData.read("0"));
      assertEquals(-15, intData.read("-15"));
    }

    @Test
    void testReadInvalidInteger() {
      try {
        intData.read("abc");
      } catch (Exception e) {
        assertEquals("Mismatch when reading a string, expecting integer but got abc",e.toString());
      }
      try {
        intData.read("42.0");
      } catch (Exception e) {
        assertEquals("Mismatch when reading a string, expecting integer but got 42.0",e.toString());
      }
      try {
        intData.read("");
      } catch (Exception e) {
        assertEquals(
          "Mismatch when reading a string, expecting integer but got <nothing>",
          e.toString()
        );
      }
    }

    @Test
    void testMismatchException() {
      assertThrows(DataMismatchException.class, () -> intData.read("abc"));
      try {
        intData.read("42.0");
      } catch (DataMismatchException e) {
        assertNotNull(e.getCause());
        assertEquals(NumberFormatException.class, e.getCause().getClass());
      }
    }

    void testFormatValidInteger() throws Exception {
      assertEquals("42", intData.format(42));
      assertEquals("0", intData.format(0));
      assertEquals("-15", intData.format(-15));
    }

}