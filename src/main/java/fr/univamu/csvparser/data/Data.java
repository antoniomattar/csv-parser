package fr.univamu.csvparser.data;


import java.time.LocalDate;

public interface Data<T> {

  // TODO initialiser les 4 constantes
  Data<Integer> INT = null;
  Data<String> STRING = null;
  Data<Double> DOUBLE = null;
  Data<LocalDate> DATE = null;

  T read(String text); // TODO ajouter déclaration d'exception
  String format(T data);

}
