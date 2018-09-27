public class Game
{
  private int    gameID;
  private String gameTitle;
  private int    developerID;
  private int    genreID;
  private double gamePrice;
  
  Game(int aGameID, String aGameTitle, int aDeveloperID, int aGenreID, double aGamePrice)
  {
	gameID        = aGameID;
	gameTitle     = aGameTitle;
    developerID   = aDeveloperID;
    genreID       = aGenreID;
    gamePrice     = aGamePrice;
  }
  
  public int getGameID()
  {
	return gameID;
  }
  public String getGameTitle()
  {
	return gameTitle;
  }
  public int getDeveloperID()
  {
    return developerID;
  }
  public int getGenreID()
  {
	return genreID;
  }
  public double getGamePrice()
  {
	return gamePrice;
  }
}