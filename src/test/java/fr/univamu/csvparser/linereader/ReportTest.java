package fr.univamu.csvparser.linereader;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.stream.Stream;

import static fr.univamu.csvparser.data.Data.*;
import static org.junit.jupiter.api.Assertions.*;

class ReportTest {

  record Dummy(int i, double d, String s) {}
  LineReader<Dummy> dummyReader =
    LineDescription.<Dummy>line().with(STRING).with(DOUBLE).with(INT)
                   .using(i -> d -> s -> new Dummy(i,d,s));

  @Test
  void correctCsvReadTest() {
    Report<Dummy> report =
      Stream.of("1,2.0,\"foo\"","2,3.0,\"bar\"","3,-5.5,\"baz\"")
        .collect(
          () -> new Report<>(dummyReader),
          Report::read,
          Report::merge
        );
    assertEquals(3, report.getLines().size());
    assertEquals(0,report.getExceptions().size());
    Iterator<Dummy> iter = report.iterator();
    assertEquals(new Dummy(1,2.,"foo"), iter.next());
    assertEquals(new Dummy(2,3.,"bar"), iter.next());
    assertEquals(new Dummy(3,-5.5,"baz"), iter.next());
  }

  @Test
  void erroneousCsvReadTest() {
    Report<Dummy> report =
      Stream.of("1.0,2.0,\"foo\"","2,3.0,\"bar\"","3,-5.5,baz")
            .collect(
              () -> new Report<>(dummyReader),
              Report::read,
              Report::merge
            );
    assertEquals(1, report.getLines().size());
    assertEquals(2,report.getExceptions().size());
    Iterator<Dummy> iter = report.iterator();
    assertEquals(new Dummy(2,3.,"bar"), iter.next());
  }

}