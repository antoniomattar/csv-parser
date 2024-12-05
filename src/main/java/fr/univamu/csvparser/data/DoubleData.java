package fr.univamu.csvparser.data;



public class DoubleData implements Data<Double> {
  @Override
  public Double read(String text) throws DataMismatchException {
    try{
      return Double.parseDouble(text);
    }catch(NumberFormatException e1){
      throw new DataMismatchException("double", text, e1);
    }
  }

  @Override
  public String format(Double data) {
    return data.toString();
  }
}
