import java.util.Random;

public class DwarfNameList {
	
	//attributes
	
	//stores list of possible male names
	private String[] dwarfMaleFirstNames = {"Agaro", "Arnan", "Auxlan", "Avamir", "Baelnar", "Balfam", "Bariken", "Borkûl", "Darkûl", "Dolmen", "Dyrnar", "Erag", 
			"Ezegan", "Ferrek", "Garmûl", "Glint", "Ghorvas", "Grimmalk", "Haeltar", "Halagmar", "Halzar", "Hlant", "Korlag", "Krag", "Krim", "Kurman", "Lurtrum", 
			"Malagar", "Mardam", "Maulnar", "Melgar", "Morak", "Orobok", "Rogath", "Roken", "Rozag", "Sabakzar", "Sharak", "Smethykk", "Swargar", "Thorbalt", 
			"Thorin", "Tredigar", "Vabûl", "Vistrum", "Wolvar"};  
	
	//stores list of possible female names
	private String[] dwarfFemaleFirstNames = {"Anbera", "Artin", "Audhild", "Balifra", "Barbena", "Bardryn", "Bolhild", "Dagnal", "Dariff", "Delre", "Diesa", 
			"Eldeth", "Eridred", "Falkrunn", "Fallthra", "Finellen", "Gillydd", "Gunnloda", "Gurdis", "Helgret", "Helja", "Hlin", "Ilde", "Jarana", "Kathra", 
			"Kilia", "Kristryd", "Liftrasa", "Marastyr", "Mardred", "Morana", "Nalaed", "Nora", "Nurkara", "OrifF", "Ovina", "Riswynn", "Sannl", "Therlin", 
			"Thodris", "Torbera", "Tordrid", "Torgga", "Urshar", "Valida", "Vistra", "Vonana", "Werydd", "Whurdred", "Yurgunn", "Beyla", "Fenryl", "Grenenzel", 
			"Krystolari", "Lokara", "Lurka", "Marnia", "Praxana", "Rokel", "Roksana", "Thurlfara", "Vauldra", "Veklani", "Vronwe", "Zebel"};
	
	private String[] dwarfLastNames = {"Ambershard", "Barrelhelm", "Copperhearth", "Deepmiddens", "Drakantal", "Evermead", 
			"Garkalan", "Grimtor", "Hackshield", "Irongull", "Markolak", "Ramcrown", "Rockharvest", "Silvertarn", 
			"Skandalor", "Zarkanan"};
	Random rand;
	
	//constructor
	public DwarfNameList()
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
	private String getDwarfMaleFirstName() //gets a dwarf male first name
	{
		return dwarfMaleFirstNames[getNum(dwarfMaleFirstNames.length)];
	}
	
	private String getDwarfFemaleFirstName()  //gets a dwarf female first name
	{
		return dwarfFemaleFirstNames[getNum(dwarfFemaleFirstNames.length)];
	}
	
	private String getDwarfLastName()  // gets a dwarf last name
	{
		return dwarfLastNames[getNum(dwarfLastNames.length)];
	}
	
	
	public String getDwarfName(int gender)  //used to put together a full name
	{							//gender indicates the desired gender of the NPC. 0 for male, 1 for female, and 2 for no preference. 
		String fullName = "";
		
		if(gender == 0) // male first name
		{
			fullName = getDwarfMaleFirstName() + " ";
		}
		else if(gender == 1) //female first name
		{
			fullName = getDwarfFemaleFirstName() + " ";
		}
		else   //random selection of gender
		{
			if(rand.nextInt() < 0.5)
			{
				fullName = getDwarfMaleFirstName() + " ";  //assigns male
			}
			else
			{
				fullName = getDwarfFemaleFirstName() + " ";  //assigns female
			}
		}
		
		//determine the last name. 
		fullName += getDwarfLastName();
		
		return fullName;
	}
}