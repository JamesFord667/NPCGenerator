import java.util.Random;

public class DragonbornNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] dragonbornMaleFirstNames = {"Andujar", "Armagan", "Armek", "Arzan", "Axaran", "Belaxarim", "Brevarr", 
			"Djemidor", "Draxan", "Fayal", "Grax", "Iojad", "Inzul", "Khiraj", "Kreytzen", "Lejek", "Mar", "Nazir", "Nedam", "Nevek", 
			"Ravaran", "Razaan", "Sarax", "Sarram", "Savaxis", "Siangar", "Sirizan", "Sunan", "Szuran", "Tajan", "Tamajon", "Tenahn", 
			"Toxal", "Tzegyr", "Vantajar", "Vharkus", "Xafiq", "Zarkhil"};  
	
	//stores list of possible female names
	private String[] dragonbornFemaleFirstNames = {"Artana", "Kalas", "Khagra", "Leytra", "Myrka", "Naya", "Sarcha", "Shirren", "Sirivistra", 
			"Sufana", "Tamara", "Vrumadi", "Zovra"};
	
	//stores list of possible last names
	private String[] dragonbornLastNames = {"Akambheryliiax", "Argenthrixus", "Baharoosh", "Beryntolthropal", "Bhenkumbyrznaax",
			"Caavylteradyn", "Chumbyxirinnish", "Clethtinthiallor", "Daardendrian", "Delmirev", "Dhyrktelonis", "Ebynichtomonis",
			"Esstyrlynn", "Fharngnarthnost", "Ghaallixirn", "Grrrmmballhyst", "Gygazzylyshrift", "Hashphronyxadyn", "lmbixtellrhyst",
			"Jerynomonis", "Jharthraxyn", "Kerrhylon", "Kimbatuul", "Lhamboldennish", "Linxakasendalor", "Mohradyllion", "Mystan", 
			"Nemmonis", "Norixius", "Ophinshtalajiir", "Orexijandilin", "Pfaphnyrennish", "Phrahdrandon", "Pyraxtallinost", "Turnuroth"};
	Random rand;
	
	//constructor
	public DragonbornNameList()
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
	private String getDragonbornMaleFirstName() //gets a dragonborn male first name
	{
		return dragonbornMaleFirstNames[getNum(dragonbornMaleFirstNames.length)];
	}
	
	private String getDragonbornFemaleFirstName()  //gets a dragonborn female first name
	{
		return dragonbornFemaleFirstNames[getNum(dragonbornFemaleFirstNames.length)];
	}
	
	private String getDragonbornLastName()  // gets a dragonborn last name
	{
		return dragonbornLastNames[getNum(dragonbornLastNames.length)];
	}
	
	
	public String getDragonbornName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getDragonbornMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getDragonbornFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getDragonbornMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getDragonbornFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getDragonbornLastName();
		
		return fullName;
	}
}