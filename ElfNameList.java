import java.util.Random;

public class ElfNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] elfMaleFirstNames = {"Alarcion", "Alathar", "Ariandar", "Arromar", "Borel", "Bvachan", "Carydion",    //add the Eladrin names? 
			"Elgoth", "Farlien", "Ferel", "Gaerlan", "Iafalior", "Kaelthorn", "Laethan", "Leliar", "Leodor", "Lorak", 
			"Lorifir", "Morian", "Oleran", "Rylef", "Savian", "Seylas", "Tevior", "Veyas"};  
	
	//stores list of possible female names
	private String[] elfFemaleFirstNames = {"Aryllan", "Atalya", "Ayrthwil", "Irva", "Lyfalia", "Ronefel", "Thirya", 
			"Velene", "Venefiq", "Zereni"};
	
	//stores list of possible last names
	private String[] elfLastNames = {"Autumnloft", "Balefrost", "Briarfell", "Evenwind", "Graytrails", "Mooncairn", 
			"Riverwall", "Stormwolf", "Summergale", "Sunshadow", "Woodenhawk"};
	Random rand;
	
	//constructor
	public ElfNameList()
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
	private String getElfMaleFirstName() //gets a elf male first name
	{
		return elfMaleFirstNames[getNum(elfMaleFirstNames.length)];
	}
	
	private String getElfFemaleFirstName()  //gets a elf female first name
	{
		return elfFemaleFirstNames[getNum(elfFemaleFirstNames.length)];
	}
	
	private String getElfLastName()  // gets a elf last name
	{
		return elfLastNames[getNum(elfLastNames.length)];
	}
	
	
	public String getElfName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getElfMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getElfFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getElfMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getElfFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getElfLastName();
		
		return fullName;
	}
}