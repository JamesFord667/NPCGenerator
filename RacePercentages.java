/**
 * Author: James Ford
 * Purpose of class: This class holds the available races and the odds of each one being selected. 
 * 					 It also has several methods used to edit odds and determine if the total odds equals 100
 */
public class RacePercentages {
	
	private String[][] percentages = {
			{"Human", "46"},   //46
			{"Dwarf", "10"},
			{"Elf", "10"},
			{"Halfling", "8"},
			{"Dragonborn", "7"},
			{"Gnome", "7"},
			{"Half-Elf", "7"},
			{"Half-Orc", "2"},
			{"Tiefling", "3"},
	};
	
	public RacePercentages() {}
	
	/* Methods */
	
	//used to get the sum of the percentages across all classes. 
	public int percentSum()
	{
		int sum = 0;
		for(int i = 0; i < 9; i++)
		{
			sum += Integer.parseInt(percentages[i][1]);
		}
		return sum;
	}
	
	//used to modify the percentage of a race. 
	public void setPercentage(String race, int value)
	{
		for(int i = 0; i < 9; i++)
		{
			if(race.equals(percentages[i][0]))
			{
				percentages[i][1] = String.valueOf(value);
			}
		}
	}
	
	//returns the odds of a specified race
	public int getPercentage(int i)
	{
		return Integer.parseInt(percentages[i][1]);
	}
	
	//returns the race at a specific location
	public String getRace(int i)
	{
		return percentages[i][0];
	}
	
	//returns the entire odds list
	public String[][] getAll()
	{
		return percentages;
	}

}