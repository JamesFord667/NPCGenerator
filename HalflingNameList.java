import java.util.Random;

public class HalflingNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] halflingMaleFirstNames = {"Arthan", "Carvin", "Corby", "Cullen", "Egen", "Ernest", "Gedi", "Heron", 
			"Jeryl", "Keffen", "Kylem", "Kynt", "Leskyn", "Neff", "Orne", "Quarrel", "Rabbit", "Rilkin", "Snakebait", 
			"Tarfen", "Titch", "Tuck", "Whim"};  
	
	//stores list of possible female names
	private String[] halflingFemaleFirstNames = {"Caliope", "Emily", "Piper", "Rixi", "Sabretha", "Teg", "Tilly", "Toira", 
			"Vexia", "Vil", "Vzani", "Zanthe", "Ziza"};
	
	//stores list of possible last names
	private String[] halflingLastNames = {"Angler", "Battlestone", "Blackwater", "Daggersharp", "Deepstrider", "Hollowpot", 
			"Puddle", "Raftmite", "Skiprock", "Silverfin", "Tanglestrand", "Tricker", "Willowrush", "Yellowcrane"};
	Random rand;
	
	//constructor
	public HalflingNameList()
	{
		rand = new Random();
	}
	
	//methods
		
	/* Used to get the random number that will choose the name off of the list */
	private int getNum(int range)
	{
		return rand.nextInt(range);
	}
	
	/* gets a random name off of the list */
	private String getHalflingMaleFirstName() //gets a halfling male first name
	{
		return halflingMaleFirstNames[getNum(halflingMaleFirstNames.length)];
	}
	
	private String getHalflingFemaleFirstName()  //gets a halfling female first name
	{
		return halflingFemaleFirstNames[getNum(halflingFemaleFirstNames.length)];
	}
	
	private String getHalflingLastName()  // gets a halfling last name
	{
		return halflingLastNames[getNum(halflingLastNames.length)];
	}
	
	
	public String getHalflingName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getHalflingMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getHalflingFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getHalflingMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getHalflingFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getHalflingLastName();
		
		return fullName;
	}
}