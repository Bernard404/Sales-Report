import java.util.*; // GregorianCalendar
public class GetSystemDate
{
  public static void main(String[] args) 
  {
    GregorianCalendar aCalendar = new GregorianCalendar();
    System.out.println("Day: "   + aCalendar.get(Calendar.DATE));
    System.out.println("Month: " + ((aCalendar.get(Calendar.MONTH)) + 1));
    System.out.println("Year: "  + aCalendar.get(Calendar.YEAR));
  }
}
  

