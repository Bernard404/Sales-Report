public class Developer
{
  private int    developerID;
  private String developerName;
  
  Developer(int aDeveloperID, String aDeveloperName)
  {
    developerID   = aDeveloperID;
    developerName = aDeveloperName;
  }
  
  public int getDeveloperID()
  {
    return developerID;
  }
  
  public String getDeveloperName()
  {
    return developerName;
  }
}