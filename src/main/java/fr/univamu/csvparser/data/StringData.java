package fr.univamu.csvparser.data;

import java.util.function.Predicate;
import java.util.regex.Pattern;
import java.util.stream.IntStream;


public class StringData implements Data<String> {


  private static IntStream escapeMap(int codepoint) {
    return switch (codepoint) {
      case '\t' -> IntStream.of('\\','t');
      case '\b' -> IntStream.of('\\','b');
      case '\n' -> IntStream.of('\\','n');
      case '\r' -> IntStream.of('\\','r');
      case '\f' -> IntStream.of('\\','f');
      case '\'' -> IntStream.of('\\','\'');
      case '\"' -> IntStream.of('\\','\"');
      case '\\' -> IntStream.of('\\','\\');
      default -> IntStream.of(codepoint);
    };
  }

  static Predicate<String> pattern =
    Pattern.compile("\"((\\.)|\\\\\"|[^\"])*\"").asMatchPredicate();


  // TODO décommenter les lignes suivantes
  @Override
  public String read(String text) { // throws DataMismatchException {
//    if (!pattern.test(text)) {
//      throw new DataMismatchException("string", text);
//    }
    String s = text.translateEscapes();
    return s.substring(1,s.length()-1);
  }

  @Override
  public String format(String data) {
    return data
      .codePoints()
      .flatMap(StringData::escapeMap)
      .collect(
        () -> new StringBuilder().append("\""),
        StringBuilder::appendCodePoint,
        StringBuilder::append
      )
      .append("\"")
      .toString();
  }
}
