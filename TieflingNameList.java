import java.util.Random;

public class TieflingNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] tieflingMaleFirstNames = {"Abad", "Ahrim", "Akmen", "Amnon", "Andram", "Astar", "Balam", "Barakas", 
			"Bathin", "Caim", "Chem", "Cimer", "Cressel", "Damakos", "Ekemon", "Euron", "Fenriz", "Forcas", "Habor", "Iados", 
			"Kairon", "Leucis", "Mamnen", "Mantus", "Marbas", "Melech", "Merihim", "Modean", "Mordai", "Mormo", "Morthos", "Nicor", 
			"Nirgel", "Oriax", "Paymon", "Pelaios", "Purson", "Qemuel", "Raam", "Rimmon", "Sammal", "Skamos", "Tethren", "Thamuz", 
			"Therai", "Valafar", "Vassago", "Xappan", "Zepar", "Zephan", "Ankhus", "Arkadi", "Armarius", "Armillius", "Archidius", 
			"Balmoloch", "Calderax", "Cavian", "Cenereth", "Chorum", "Corynax", "Dacian", "Daelius", "Damaceus", "Decimeth", "Demedor", 
			"Demerian", "Dynachus", "Grassus", "Halius", "Heleph", "Incirion", "Kalaradian", "Kamien", "Kazimir", "Kzandro", 
			"Machem", "Maetheus", "Malfias", "Marchion", "Menerus", "Namazeus", "Nensis", "Prismeus", "Pyranikus", "Razortail", 
			"Sejanus", "Severian", "Suffer", "Syken", "Tarkus", "Vaius", "Xerek", "Zeth", "Zevon"};  
	
	//stores list of possible female names
	private String[] tieflingFemaleFirstNames = {"Affyria", "Cataclysmia", "Domitia", "Dorethau", "Excellence", "Hacari", "Iritra", 
			"Lachira", "Levatra", "Mecretia", "Milvia", "Nericia", "Precious", "Rain", "Samantia", "Sunshine", "Tenerife", "Traya", "Velavia", 
			"Zaidi", "Zethaya", "Akta", "Anakis", "Armara", "Astaro", "Aym", "Azza", "Beleth", "Bryseis", "Bune", "Criella", "Damaia", "Decarabia", 
			"Ea", "Gadreel", "Gomory", "Hecat", "Ishte", "Jezebeth", "Kali", "Kallista", "Kasdeya", "Lerissa", "Lilith", "Makaria", "Manea", 
			"Markosian", "Mastema", "Naamah", "Nemeia", "Nija", "Orianna", "Osah", "Phelia", "Prosperine", "Purah", "Pyra", "Rieta", "Ronobe", 
			"Ronwe", "Seddit", "Seere", "Sekhmet", "Semyaza", "Shava", "Shax", "Sorath", "Uzza", "Vapula", "Vepar", "Verin"};
	
	//stores list of possible last names
	private String[] tieflingLastNames = {"Amarzian", "Carnago", "Domarien", "Iscitan", "Meluzan", "Menetrian", "Paradas", "Romazi", 
			"Sarzan", "Serechor", "Shadowhorn", "Szereban", "Torzalan", "Trelenus", "Trevethor", "Tryphon", "Vadu", "Vrago"};
	
	Random rand;
	
	//constructor
	public TieflingNameList()
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
	private String getTieflingMaleFirstName() //gets a tiefling male first name
	{
		return tieflingMaleFirstNames[getNum(tieflingMaleFirstNames.length)];
	}
	
	private String getTieflingFemaleFirstName()  //gets a tiefling female first name
	{
		return tieflingFemaleFirstNames[getNum(tieflingFemaleFirstNames.length)];
	}
	
	private String getTieflingLastName()  // gets a tiefling last name
	{
		return tieflingLastNames[getNum(tieflingLastNames.length)];
	}
	
	
	public String getTieflingName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getTieflingMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getTieflingFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getTieflingMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getTieflingFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getTieflingLastName();
		
		return fullName;
	}
}