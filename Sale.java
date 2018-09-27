public class Sale
{
  private String saleDate;
  private int    saleUnits;
  private int    gameID;
  
  Sale(String aSaleDate, int aSaleUnits, int aGameID)
  {
    saleDate  = aSaleDate;
    saleUnits =	aSaleUnits;
    gameID    = aGameID;
  }	  
  
  public String getSaleDate()
  {
	return saleDate;
  }
  public int getSaleUnits()
  {
	return saleUnits;
  }
  public int getGameID()
  {
	return gameID;
  }
}