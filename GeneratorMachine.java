/**
 * Author: James Ford
 * Purpose of class: This class is the "engine" that runs the program. This connects to the GUI so that when the button is pressed, a new
 * 					 race is randomly chosen. From there, this method calls the correct list to get a random name of the desired gender.
 * 					 The class then passes the selected race and name to the GUI to display to the user. 
 */
import java.util.Random;

public class GeneratorMachine {
	
	//declare and initialize variables
	private Random rand = new Random();
	private int value = 0;  //the randomly selected number for the race. 
	private int totalValue = 0;  //this keeps track of what percent we are at. 
	private final int numOfRaces = 9;
	
	private RacePercentages odds = new RacePercentages();
	
	private HumanNameList humanList = new HumanNameList();					//list of human names. The rest are self-explanatory. 
	private DwarfNameList dwarfList = new DwarfNameList();
	private ElfNameList elfList = new ElfNameList();
	private HalflingNameList halflingList = new HalflingNameList();
	private TieflingNameList tieflingList = new TieflingNameList();
	private DragonbornNameList dragonbornList = new DragonbornNameList();
	private HalfelfNameList halfelfList = new HalfelfNameList();
	private GnomeNameList gnomeList = new GnomeNameList();
	private HalforcNameList halforcList = new HalforcNameList();
	
	private String race = "";   //used to keep track of the race that is selected by the program
	
	private String[][] previousCharacters = {   //used to keep a record of the previous three generated characters. 
			{"empty", "empty"},
			{"empty", "empty"},
			{"empty", "empty"},
			{"empty", "empty"}
	};

			
	public String[] generate()
	{
		String[] result = {"race", "name"};  		//initializes the result variable 
		totalValue = 0;							//resets the totalValue variable

		//calculate the value
		value = rand.nextInt(100) + 1;
				
		//return the result (actually print but it's fine)
		for(int i = 0; i < numOfRaces; i++)
		{
			totalValue += odds.getPercentage(i);		//Adds the odds to the total value of odds. 
			if(value <= totalValue)    //compares the value with the total odds collected from the 2D array
			{
				race = odds.getRace(i);   //stores the chosen race
				i = 10; 				//should end the loop
			}
		}
		//sets the name and race to the variable
		if(race.equals("Human"))
		{
			result[0] = "Human";
			result[1] = humanList.getHumanName(3);
		}
		else if(race.equals("Dwarf"))
		{
			result[0] = "Dwarf";
			result[1] = dwarfList.getDwarfName(3);
		}
		else if(race.equals("Elf"))
		{
			result[0] = "Elf";
			result[1] = elfList.getElfName(3);
		}
		else if(race.equals("Halfling"))
		{
			result[0] = "Halfling";
			result[1] = halflingList.getHalflingName(3);
		}
		else if(race.equals("Tiefling"))
		{
			result[0] = "Tiefling";
			result[1] = tieflingList.getTieflingName(3);
		}
		else if(race.equals("Dragonborn"))
		{
			result[0] = "Dragonborn";
			result[1] = dragonbornList.getDragonbornName(3);
		}
		else if(race.equals("Half-Elf"))
		{
			result[0] = "Half-Elf";
			result[1] = halfelfList.getHalfelfName(3);
		}
		else if(race.equals("Gnome"))
		{
			result[0] = "Gnome";
			result[1] = gnomeList.getGnomeName(3);
		}
		else if(race.equals("Half-Orc"))
		{
			result[0] = "Half-Orc";
			result[1] = halforcList.getHalforcName(3);
		}
		else
		{
			System.out.println("Congratulations, you found a new race!");
		}
		
		//stores the name in the previously chosen list
		cyclePreviousList(result);
		
		//returns the completed name and race
		return result;
	}
	
	//this method stores the most recently chosen name 
	private void cyclePreviousList(String[] input)
	{
		for(int i = 3; i > 0; i--)
		{
			previousCharacters[i][0] = previousCharacters[i-1][0];
			previousCharacters[i][1] = previousCharacters[i-1][1];
		}
		previousCharacters[0][0] = input[0];
		previousCharacters[0][1] = input[1];
	}
	
	//used to get the list of the three previous names
	public String[][] getPreviousCharacters()
	{
		return previousCharacters;
	}
}