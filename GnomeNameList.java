import java.util.Random;

public class GnomeNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] gnomeMaleFirstNames = {"Alston", "Alvyn", "Anverth", "Arumawann", "Bilbron", "Boddynock", "Brocc", "Burgell", "Cockaby", "Crampernap", 
			"Dabbledob", "Delebean", "Dimble", "Eberdeb", "Eldon", "Erky", "Fablen", "Fibblestib", "Fonkin", "Frouse", "Frug", "Gerbo", "Gimble", "Glim", 
			"Igden", "Jabble", "Jebeddo", "Kellen", "Kipper", "Namfoodle", "Oppleby", "Orryn", "Paggen", "Pallabar", "Pog", "Qualen", "Ribbles", "Rimple", 
			"Roondar", "Sapply", "Seebo", "Senteq", "Sindri", "Umpen", "Warryn", "Wiggens", "Wobbles", "Wrenn", "Zaffrab", "Zook"};  
	
	//stores list of possible female names
	private String[] gnomeFemaleFirstNames = {"Abalaba", "Bimpnottin", "Breena", "Buvvie", "Callybon", "Caramip", "Carlin", "Cumpen", "Dalaba", "Donella", 
			"Duvamil", "Ella", "Ellyjoybell", "Ellywick", "Enidda", "Lilli", "Loopmottin", "Lorilla", "Luthra", "Mardnab", "Meena", "Menny", "Mumpena", "Nissa", 
			"Numba", "Nyx", "Oda", "Oppah", "Orla", "Panana", "Pynfle", "Quilla", "Ranala", "Reddlepop", "Roywyn", "Salanop", "Shamil", "Sifiress", "Symma", 
			"Tana", "Tenena", "Tervaround", "Tippletoe", "Ulla", "Unvera", "Veloptima", "Virra", "Waywocket", "Yebe", "Zanna"};
	
	//stores list of last names
	private String[] gnomeLastNames = {"Albaratie", "Bafflestone", "Beren", "Boondiggles", "Cobblelob", "Daergel", "Dunben", "Fabblestabble", "Fapplestamp", 
			"Fiddlefen", "Folkor", "Garrick", "Gimlen", "Glittergern", "Gobblefirn", "Gummen", "Horcusporcus", "Humplebumple", "Ironhide", "Leffery",
			"Lingenhall", "Loofollue", "Maekkelferce", "Miggledy", "Munggen", "Murnig", "Musgraben", "Nackle", "Ningel", "Nopenstallen", "Nucklestamp", 
			"Offund", "Oomtrowl", "Pilwicken", "Pingun", "Quillsharpener", "Raulnor", "Reese", "Rofierton", "Scheppen", "Shadowcloak", "Silverthread", 
			"Sympony", "Tarkelby", "Timbers", "Turen", "Umbodoben", "Waggletop", "Welber", "Wildwander"};
	Random rand;
	
	//constructor
	public GnomeNameList()
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
	private String getGnomeMaleFirstName() //gets a gnome male first name
	{
		return gnomeMaleFirstNames[getNum(gnomeMaleFirstNames.length)];
	}
	
	private String getGnomeFemaleFirstName()  //gets a gnome female first name
	{
		return gnomeFemaleFirstNames[getNum(gnomeFemaleFirstNames.length)];
	}
	
	private String getGnomeLastName()  // gets a gnome last name
	{
		return gnomeLastNames[getNum(gnomeLastNames.length)];
	}
	
	
	public String getGnomeName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getGnomeMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getGnomeFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getGnomeMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getGnomeFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getGnomeLastName();
		
		return fullName;
	}
}