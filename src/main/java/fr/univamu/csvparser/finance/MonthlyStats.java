package fr.univamu.csvparser.finance;

import java.time.LocalDate;

public class MonthlyStats {

  private final LocalDate date;
  // TODO ajouter les propriétés, avec accesseurs et mutateurs

  public double ouncesFromCash(double cash) {
    // TODO
    return 0.0;
  }

  public double spSharesFromCash(double cash) {
    // TODO
    return 0.0;
  }

  public Bond bondsFromCash(double cash) {
    // TODO
    return null;
  }

  public double evaluate(Portfolio portfolio) {
    // TODO
    return 0.0;
  }

  public double evaluateBonds(Portfolio portfolio) {
    // TODO
    return 0.0;
  }


  public MonthlyStats(LocalDate date) {
    this.date = date;
  }

}
