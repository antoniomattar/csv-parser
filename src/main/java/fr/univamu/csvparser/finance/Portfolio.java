package fr.univamu.csvparser.finance;


public record Portfolio(
  // TODO ajouter les propriétés
) {


  public static Portfolio evenlySplit(double cash, MonthlyStats currentStats) {
    // TODO
    return null;
  }

  public double evaluate(MonthlyStats currentStats) {
    return currentStats.evaluate(this);
  }

  public double earnings(MonthlyStats nextMonthStats) {
    // TODO
    return 0.0;
  }


  @Override
  public String toString() {
    // TODO
    return "";
  }
}
