package fr.univamu.csvparser.finance;

import fr.univamu.csvparser.linereader.LineReader;

import java.io.IOException;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class HistoricStats {

  private Map<LocalDate, MonthlyStats> monthlyData = new HashMap<>();


  public MonthlyStats get(LocalDate date) {
    LocalDate canonicalDate = date.plusDays(1-date.getDayOfMonth()); // au premier jour du mois
    // TODO
    return null;
  }


  public double adjustByInflation(double amount, LocalDate fromDate, LocalDate toDate) {
    // TODO
    return 0.0;
  }


  public HistoricStats() throws IOException {
    // TODO read data from csv
  }


  private LineReader<Boolean> readSpLine() {
    // TODO
    return null;
  }

  private LineReader<Boolean> readGoldLine() {
    // TODO
    return null;
  }

  private LineReader<Boolean> readBondLine() {
    // TODO
    return null;
  }

  private LineReader<Boolean> readInflationLine() {
    // TODO
    return null;
  }

  private MonthlyStats ensureDate(LocalDate date) {
    // TODO
    return monthlyData.get(date);
  }


}
