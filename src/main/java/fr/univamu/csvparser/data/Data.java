package fr.univamu.csvparser.data;


import java.time.LocalDate;

public interface Data<T> {

  Data<Integer> INT = new IntData() ;
  Data<String> STRING = new StringData() ;
  Data<Double> DOUBLE = new DoubleData();
  Data<LocalDate> DATE = new DateData() ;

  T read(String text) throws DataMismatchException ;
  String format(T data);

}
