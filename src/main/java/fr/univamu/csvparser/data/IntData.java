package fr.univamu.csvparser.data;


public class IntData implements Data<Integer> {

  @Override
  public Integer read(String text) throws DataMismatchException {
    try{
      return Integer.parseInt(text);
    }catch(NumberFormatException e){
      throw new DataMismatchException("integer", text, e);
    }
  }

  @Override
  public String format(Integer data) {
    return data.toString();
  }


}
