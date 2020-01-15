import java.util.Random;

public class HalfelfNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] HalfelfMaleFirstNames = {"Alarcion", "Alathar", "Ariandar", "Arromar", "Borel", "Bvachan", "Carydion",    //add the Eladrin names? 
			"Elgoth", "Farlien", "Ferel", "Gaerlan", "Iafalior", "Kaelthorn", "Laethan", "Leliar", "Leodor", "Lorak", 
			"Lorifir", "Morian", "Oleran", "Rylef", "Savian", "Seylas", "Tevior", "Veyas", "Anlow", "Arando", "Bram", "Cale", "Dalkon", "Daylen", "Dodd", "Dungarth", 
			"Dyrk", "Eandro", "Falken", "Feck", "Fenton", "Gryphero", "Hagar", "Jeras", "Krynt", "Lavant", "Leyten", "Madian", "Malfier", "Markus", "Meklan", 
			"Namen", "Navaren", "Nerle", "Nilus", "Ningyan", "Norris", "Quentin", "Semil", "Sevenson", "Steveren", "Talfen", "Tamond", "Taran", 
			"Tavon", "Tegan", "Vanan", "Vincen"};  
	
	//stores list of possible female names
	private String[] HalfelfFemaleFirstNames = {"Aryllan", "Atalya", "Ayrthwil", "Irva", "Lyfalia", "Ronefel", "Thirya", 
			"Velene", "Venefiq", "Zereni", "Azura", "Brey", "Hallan", "Kasaki", "Lorelei", "Mirabel", "Pharana", "Remora",
			"Rosalyn", "Sachil", "Saidi", "Tanika", "Tura", "Tylsa", "Vencia", "Xandrilla"};
	
	//stores list of possible last names
	private String[] HalfelfLastNames = {"Autumnloft", "Balefrost", "Briarfell", "Evenwind", "Graytrails", "Mooncairn", 
			"Riverwall", "Stormwolf", "Summergale", "Sunshadow", "Woodenhawk", 
			"Arkalis", "Armanci", "Bilger", "Blackstrand", "Brightwater", "Carnavon", "Caskajaro",						
			"Coldshore", "Coyle", "Cresthill", "Cuttlescar", "Daargen", "Dalicarlia", "Danamark", "Donoghan", "Drumwind", "Dunhall", 
			"Ereghast", "Falck", "Fallenbridge", "Faringray", "Fletcher", "Fryft", "Goldrudder", "Grantham", "Graylock", "Gullscream", 
			"Hindergrass", "Iscalon", "Kreel", "Kroft", "Lamoth", "Leerstrom", "Lynchfield", "Moonridge", "Netheridge", "Oakenheart", 
			"Pyncion", "Ratley", "Redraven", "Revenmar", "Roxley", "Sell", "Seratolva", "Shanks", "Shattermast", "Shaulfer", "Silvergraft", 
			"Stavenger", "Stormchapel", "Strong", "Swiller", "Talandro", "Targana", "Towerfall", "Umbermoor", "Van Devries", "Van Gandt", 
			"Van Hyden", "Varcona", "Varzand", "Voortham", "Vrye", "Webb", "Welfer", "Wilxes", "Wintermere", "Wygarthe", "Zatchet", "Zethergyll"};
	Random rand;
	
	//constructor
	public HalfelfNameList()
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
	private String getHalfelfMaleFirstName() //gets a half-elf male first name
	{
		return HalfelfMaleFirstNames[getNum(HalfelfMaleFirstNames.length)];
	}
	
	private String getHalfelfFemaleFirstName()  //gets a half-elf female first name
	{
		return HalfelfFemaleFirstNames[getNum(HalfelfFemaleFirstNames.length)];
	}
	
	private String getHalfelfLastName()  // gets a half-elf last name
	{
		return HalfelfLastNames[getNum(HalfelfLastNames.length)];
	}
	
	
	public String getHalfelfName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getHalfelfMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getHalfelfFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getHalfelfMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getHalfelfFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getHalfelfLastName();
		
		return fullName;
	}
}