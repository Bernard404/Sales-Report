import java.util.*;
import java.io.*;
import javax.swing.*;
import java.text.*;
public class SalesReport 
{
	public static ArrayList<Game>	games	= new ArrayList<Game>();
	public static ArrayList<Genre>	genres	= new ArrayList<Genre>();
	public static ArrayList<Developer>	developers = new ArrayList<Developer>();
	public static ArrayList<Sale>	sales	= new ArrayList<Sale>();
	
	public static void main(String []args)	throws IOException
	{
		loadDataIntoArrayLists();
		getGameDetails();
	}
	
	public static void loadDataIntoArrayLists() throws IOException
	{
		String filenames[] = {"GameGenres.txt", "GameDevelopers.txt",
				"GameDetails.txt", "GameSales.txt"};
		File aFile;
		String fileElements[];
		Scanner in;
		for(int i = 0; i < filenames.length;i++)
		{
			aFile = new File(filenames[i]);
			in = new Scanner(aFile);
			while(in.hasNext())
			{
				fileElements = (in.nextLine()).split(",");
				switch(i)
				{
				case 0: genres.add(new Genre(Integer.parseInt(fileElements[0]),fileElements[1]));	break;
				case 1: developers.add(new Developer(Integer.parseInt(fileElements[0]),fileElements[1]));	
				break;
				case 2: games.add(new Game(Integer.parseInt(fileElements[0]), fileElements[1],
						Integer.parseInt(fileElements[2]),Integer.parseInt(fileElements[3]),
						Double.parseDouble(fileElements[4])));	break;
				case 3: sales.add(new Sale(fileElements[0], Integer.parseInt(fileElements[1]),
						Integer.parseInt(fileElements[2])));	break;
				}
			}
			in.close();
		}
	}
	public static void getGameDetails()
	{
		int gameIDs[] = new int[games.size()];
		String gameTitles[] = new String[games.size()];
		double gamePrices[] = new double[games.size()];
		String selectedGameTitle;
		int selectedGameID, subscript;
		double selectedGamePrice;
		for(int i = 0; i < games.size(); i ++)
		{
			gameIDs[i]	= (games.get(i)).getGameID();
			gameTitles[i] = (games.get(i)).getGameTitle();
			gamePrices[i] = (games.get(i)).getGamePrice();
		}
		
		selectedGameTitle = (String) JOptionPane.showInputDialog(null,"Select a Game",
				"Get Sales for Game",1,null,gameTitles,gameTitles[0]);
		if(selectedGameTitle != null)
		{
			subscript = getSubscriptOfSelectedGameTitle(selectedGameTitle,gameTitles);
			selectedGameID = gameIDs[subscript];
			selectedGamePrice = gamePrices[subscript];
			displayReport(selectedGameID,selectedGameTitle, selectedGamePrice);
		}
	}
	public static int getSubscriptOfSelectedGameTitle(String selectedGameTitle, String gameTitles[])
	{
		boolean found = false;
		int i;
		for(i = 0; i < gameTitles.length && !found; i++)
		{
			if(selectedGameTitle.equals(gameTitles[i]));
			found = true;
		}
		return (i - 1);
	}
	public static void displayReport(int selectedGameID, String selectedGameTitle,double selectedGamePrice)
	{
		GregorianCalendar aCalendar = new GregorianCalendar();
		int salesUnitsByMonth[] = new int[(aCalendar.get(aCalendar.MONTH)) + 1];
		String dateElements[];
		int monthOfSale, monthSaleUnits;
		double totalSales = 0;
		for(int i = 0; i < sales.size();i++)
		{
			if(selectedGameID == (sales.get(i)).getGameID());
			{
				dateElements = ((sales.get(i)).getSaleDate()).split("/");
				monthOfSale = Integer.parseInt(dateElements[1]);
				salesUnitsByMonth[monthOfSale - 1] += (sales.get(i)).getSaleUnits();
			}
		}
		System.out.println("Game:\t\t" + selectedGameTitle + "\nUnit Price:\t" + selectedGamePrice + "\n");
		System.out.println("\t\t\tMonth#\t\tUnits\t\tSales Value (Euros)");
		for(int i = 0; i < salesUnitsByMonth.length; i++)
		{
			System.out.print("\t\t\t" + (i + 1) + "\t\t" + salesUnitsByMonth[i] + "\t\t");
			System.out.printf("%6.2f\n", (salesUnitsByMonth[i] * selectedGamePrice));
			totalSales += (salesUnitsByMonth[i] * selectedGamePrice);
		}
		System.out.print("\nTotal Sales:\t");
		System.out.printf("%6.2f\n", totalSales);
	}
}
