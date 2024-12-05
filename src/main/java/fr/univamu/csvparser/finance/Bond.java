package fr.univamu.csvparser.finance;

import java.time.LocalDate;

public record Bond() {
// TODO ajouter les propriétés de l'enregistrement


  public double estimatedValue(LocalDate currentDate, double currentRate) {
    // TODO
    return 0.0;
  }

  @Override
  public String toString() {
    // TODO
    return "";
  }

  public double monthlyInterest() {
    // TODO
    return 0.0;
  }
}
