package fr.univamu.csvparser.linereader;

import fr.univamu.csvparser.data.Data;
import java.util.Iterator;
import java.util.function.Function;

public interface LineDescription<S,R> {

  R read(S s, Iterator<String> strings);


  default LineReader<R> using(S s) {
    // TODO
    return null;
  }


  static <R> LineDescription<R,R> line() {
    // TODO
    return null;
  }


  default LineDescription<S,R> ignore(int k) {
    // TODO
    return null;
  }


  default LineDescription<S,R> ignore() {
    // TODO
    return null;
  }


  default <T> LineDescription<Function<T,S>,R> with(Data<T> dataT) {
    // TODO
    return null;
  }
}
