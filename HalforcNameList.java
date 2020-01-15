import java.util.Random;

public class HalforcNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] halforcMaleFirstNames = {"Argran", "Braak", "Brug", "Cagak", "Dench", "Dorn", "Dren", "Druuk", "Feng", "Gell", "Gnarsh", 
			"Grurnbar", "Gubrash", "Hagren", "Henk", "Hogar", "Holg", "Imsh", "Karash", "Karg", "Keth", "Korag", "Krusk", "Lubash", "Megged", 
			"Mhurren", "Mord", "Morg", "Nil", "Nybarg", "Odorr", "Ohr", "Rendar", "Resh", "Ront", "Rrath", "Sark", "Scrag", "Sheggen", "Shump", 
			"Tanglar", "Tarak", "Thar", "Thokk", "Trag", "Ugarth", "Varg", "Vilberg", "Yurk", "Zed", };  
	
	//stores list of possible female names
	private String[] halforcFemaleFirstNames = {"Arha", "Baggi", "Bendoo", "Bilga", "Brakka", "Creega", "Drenna", "Ekk", "Emen", "Engong", 
			"Fistula", "Gaaki", "Gorga", "Grai", "Greeba", "Grigi", "Gynk", "Hrathy", "Huru", "Ilga", "Kabbarg", "Kansif", "Lagazi", "Lezre", 
			"Murgen", "Murook", "Myev", "Nagrette", "Neega", "Nella", "Nogu", "Oolah", "Ootah", "Ovak", "Ownka", "Puyet", "Reeza", "Shautha", 
			"Silgre", "Sutha", "Tagga", "Tawar", "Tomph", "Ubada", "Vanchu", "Vola", "Volen", "Vorka", "Yevelda", "Zagga", };
	
	//stores list of possible last names
	private String[] halforcLastNames = {""};
	
	Random rand;
	
	//constructor
	public HalforcNameList()
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
	private String getHalforcMaleFirstName() //gets a half-orc male first name
	{
		return halforcMaleFirstNames[getNum(halforcMaleFirstNames.length)];
	}
	
	private String getHalforcFemaleFirstName()  //gets a half-orc female first name
	{
		return halforcFemaleFirstNames[getNum(halforcFemaleFirstNames.length)];
	}
	
	private String getHalforcLastName()  // gets a half-orc last name
	{
		return halforcLastNames[getNum(halforcLastNames.length)];
	}
	
	
	public String getHalforcName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getHalforcMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getHalforcFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getHalforcMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getHalforcFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getHalforcLastName();
		
		return fullName;
	}
}