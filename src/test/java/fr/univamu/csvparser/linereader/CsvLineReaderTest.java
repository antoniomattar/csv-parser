package fr.univamu.csvparser.linereader;

import org.junit.jupiter.api.Test;

import static fr.univamu.csvparser.data.Data.DOUBLE;
import static fr.univamu.csvparser.data.Data.INT;
import static org.junit.jupiter.api.Assertions.*;

class CsvLineReaderTest {

  @Test
  void readIntTest() throws Exception {
    LineReader<Integer> readInt =
      LineDescription.<Integer>line().with(INT).using(n -> n);
    assertEquals(5, readInt.read("5"));
    assertEquals(15, readInt.read("15"));
    assertEquals(0, readInt.read("0"));
    assertEquals(-8, readInt.read("-8"));
    assertThrows(Exception.class, () -> readInt.read("foo"));
  }

  @Test
  void readTwiceTest() throws Exception {
    LineReader<Integer> sumTwoInts =
      LineDescription.<Integer>line().with(INT).with(INT).using(n -> p -> n + p);
    assertEquals(5, sumTwoInts.read("1,4"));
    assertEquals(0, sumTwoInts.read("8,-8"));
    assertEquals(42, sumTwoInts.read("12,30"));
    assertThrows(Exception.class, () -> sumTwoInts.read("4,3.5"));
  }

  @Test
  void readManyDoubles() throws Exception {
    LineReader<Double> product =
      LineDescription.<Double>line().with(DOUBLE).with(DOUBLE).with(DOUBLE).with(DOUBLE)
                     .using(x -> y -> z -> t -> x * y * z * t);
    assertEquals(12.,product.read("2.,3,1,2"),1e-6);
    assertEquals(-30.,product.read("2.5,3,-8,0.5"),1e-6);
    assertEquals(0.,product.read("-4.,0,45,734"),1e-6);
    assertThrows(Exception.class, () -> product.read("-4.,0,45"));
    // assertThrows(Exception.class, () -> product.read("-4.,0,45,734,56"));
  }

}