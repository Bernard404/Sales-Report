public class Genre
{
  private int    genreID;
  private String genreName;
  
  Genre(int aGenreID, String aGenreName)
  {
    genreID   = aGenreID;
    genreName = aGenreName;
  }
  
  public int getGenreID()
  {
    return genreID;
  }
  
  public String getGenreName()
  {
    return genreName;
  }
}