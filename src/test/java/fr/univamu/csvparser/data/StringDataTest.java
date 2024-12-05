package fr.univamu.csvparser.data;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StringDataTest {

  @Test
  void read() throws Exception {
    Data<String> ds = new StringData();
//    assertThrows(DataMismatchException.class,() -> ds.read("abc"));
//    assertThrows(DataMismatchException.class,() -> ds.read("\"abc"));
//    assertThrows(DataMismatchException.class,() -> ds.read("abc\""));
//    assertThrows(DataMismatchException.class,() -> ds.read("a\"bc\""));
//    assertThrows(DataMismatchException.class,() -> ds.read("\"ab\"c"));
//    assertThrows(DataMismatchException.class,() -> ds.read("\"a\\\"b\"\\c\""));
//    assertEquals("",ds.read("\"\""));
    assertEquals("abc",ds.read("\"abc\""));
    assertEquals("a\\bc",ds.read("\"a\\\\bc\""));
    assertEquals("a\"bc",ds.read("\"a\\\"bc\""));
    assertEquals("a\t\r\nbc",ds.read("\"a\\t\\r\\nbc\""));
    assertEquals("a\"b\"c",ds.read("\"a\\\"b\\\"c\""));
    assertEquals("a\\\"b\"c",ds.read("\"a\\\\\"b\\\"c\""));
  }

  @Test
  void format() throws Exception {
    List<String> words = List.of(
      "", "abc", "\"abc\"",
      "ab\"cd", "a\r\n\tb","\"a\\\"\"",
      "a\\\\b", "\\\"abc\"\\de\"\\\\\"fg\"\""
    );
    Data<String> ds = new StringData();
    for (String word : words) {
      assertEquals(word, ds.read(ds.format(word)), word);
    }
  }
}