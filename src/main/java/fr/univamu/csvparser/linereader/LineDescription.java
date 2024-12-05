package fr.univamu.csvparser.linereader;

import fr.univamu.csvparser.data.Data;
import fr.univamu.csvparser.data.DataMismatchException;

import java.util.Iterator;
import java.util.List;
import java.util.function.Function;

public interface LineDescription<S,R> {

  R read(S s, Iterator<String> strings) throws DataMismatchException;


  default LineReader<R> using(S s) {
    return new CsvLineReader<>(this, s, ",");
  }


  static <R> LineDescription<R, R> line() {
    return (s, string) -> s;
  }

  default LineDescription<S, R> ignore(int k) {
    return (s, strings) -> {
      for (int i = 0; i < k && strings.hasNext(); i++) {
        strings.next();
      }
      return this.read(s, strings);
    };
  }


  default LineDescription<S, R> ignore() {
    return ignore(1);
  }


  default <T> LineDescription<Function<T, S>, R> with(Data<T> dataT) {
    return (f, strings) -> this.read(f.apply(dataT.read(strings.next())), strings);
  }
}