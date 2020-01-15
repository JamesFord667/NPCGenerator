import java.util.Random;

public class HumanNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] humanMaleFirstNames = {"Anlow", "Arando", "Bram", "Cale", "Dalkon", "Daylen", "Dodd", "Dungarth", "Dyrk", "Eandro", 
			"Falken", "Feck", "Fenton", "Gryphero", "Hagar", "Jeras", "Krynt", "Lavant", "Leyten", "Madian", "Malfier", "Markus", "Meklan", 
			"Namen", "Navaren", "Nerle", "Nilus", "Ningyan", "Norris", "Quentin", "Semil", "Sevenson", "Steveren", "Talfen", "Tamond", "Taran", 
			"Tavon", "Tegan", "Vanan", "Vincen"};  
	
	//stores list of possible female names
	private String[] humanFemaleFirstNames = {"Azura", "Brey", "Hallan", "Kasaki", "Lorelei", "Mirabel", "Pharana", "Remora", 
			"Rosalyn", "Sachil", "Saidi", "Tanika", "Tura", "Tylsa", "Vencia", "Xandrilla"};
	
	//stores list of possible last names
	private String[] humanLastNames = {"Arkalis", "Armanci", "Bilger", "Blackstrand", "Brightwater", "Carnavon", "Caskajaro",	
			"Coldshore", "Coyle", "Cresthill", "Cuttlescar", "Daargen", "Dalicarlia", "Danamark", "Donoghan", "Drumwind", "Dunhall", 
			"Ereghast", "Falck", "Fallenbridge", "Faringray", "Fletcher", "Fryft", "Goldrudder", "Grantham", "Graylock", "Gullscream", 
			"Hindergrass", "Iscalon", "Kreel", "Kroft", "Lamoth", "Leerstrom", "Lynchfield", "Moonridge", "Netheridge", "Oakenheart", 
			"Pyncion", "Ratley", "Redraven", "Revenmar", "Roxley", "Sell", "Seratolva", "Shanks", "Shattermast", "Shaulfer", "Silvergraft", 
			"Stavenger", "Stormchapel", "Strong", "Swiller", "Talandro", "Targana", "Towerfall", "Umbermoor", "Van Devries", "Van Gandt", 
			"Van Hyden", "Varcona", "Varzand", "Voortham", "Vrye", "Webb", "Welfer", "Wilxes", "Wintermere", "Wygarthe", "Zatchet", "Zethergyll"};
	Random rand;
	
	//constructor
	public HumanNameList()
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
	private String getHumanMaleFirstName() //gets a human male first name
	{
		return humanMaleFirstNames[getNum(humanMaleFirstNames.length)];
	}
	
	private String getHumanFemaleFirstName()  //gets a human female first name
	{
		return humanFemaleFirstNames[getNum(humanFemaleFirstNames.length)];
	}
	
	private String getHumanLastName()  // gets a human last name
	{
		return humanLastNames[getNum(humanLastNames.length)];
	}
	
	
	public String getHumanName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getHumanMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getHumanFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getHumanMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getHumanFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getHumanLastName();
		
		return fullName;
	}

}