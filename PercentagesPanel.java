import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

@SuppressWarnings("serial")
public class PercentagesPanel extends JPanel {
	
	//initialize labels for each race/percentage
	private MyLabel humanOdds = new MyLabel();							
	private MyLabel elfOdds = new MyLabel();							
	private MyLabel dwarfOdds = new MyLabel();
	private MyLabel gnomeOdds = new MyLabel();	
	private MyLabel halflingOdds = new MyLabel();	
	private MyLabel halfelfOdds = new MyLabel();	
	private MyLabel tieflingOdds = new MyLabel();	
	private MyLabel dragonbornOdds = new MyLabel();	
	private MyLabel halforcOdds = new MyLabel();	
	private MyLabel total = new MyLabel();
	
	//text fields to take input from users on percentage
	private MyTextField humanText = new MyTextField();
	private MyTextField elfText = new MyTextField();
	private MyTextField dwarfText = new MyTextField();
	private MyTextField gnomeText = new MyTextField();
	private MyTextField halflingText = new MyTextField();
	private MyTextField tieflingText = new MyTextField();
	private MyTextField dragonbornText = new MyTextField();
	private MyTextField halforcText = new MyTextField();
	private MyTextField halfelfText = new MyTextField();
	
	private String[][] races;	//holds the table with percentages and races
	
	private Font text = new Font("Franklin Gothic Medium", Font.BOLD, 30);	//font for the text
	
	public PercentagesPanel(RacePercentages odds)
	{		
		races = odds.getAll();		//set the string to equal the percentages and races
		
		//panel settings
		setLayout(new GridLayout(10, 2));
		add(humanOdds); 
		add(humanText);
		
		add(elfOdds);
		add(elfText);
		
		add(dwarfOdds);
		add(dwarfText);
		
		add(halflingOdds);
		add(halflingText);
		
		add(gnomeOdds);
		add(gnomeText);
		
		add(halfelfOdds);
		add(halfelfText);
		
		add(dragonbornOdds);
		add(dragonbornText);
		
		add(tieflingOdds);
		add(tieflingText);
		
		add(halforcOdds);
		add(halforcText);
		
		add(total);
		setBackground(Color.black);
		
		//label settings
		//add text to labels
		humanOdds.setText(races[0][0] + ": " + races[0][1] + "%");
		elfOdds.setText(races[2][0] + ": " + races[2][1] + "%");
		dwarfOdds.setText(races[1][0] + ": " + races[1][1] + "%");
		gnomeOdds.setText(races[5][0] + ": " + races[5][1] + "%");
		halflingOdds.setText(races[3][0] + ": " + races[3][1] + "%");
		halfelfOdds.setText(races[6][0] + ": " + races[6][1] + "%");
		halforcOdds.setText(races[7][0] + ": " + races[7][1] + "%");
		tieflingOdds.setText(races[8][0] + ": " + races[8][1] + "%");
		dragonbornOdds.setText(races[4][0] + ": " + races[4][1] + "%");
		
		//makes the labels look nice
		humanOdds.format();
		elfOdds.format();
		dwarfOdds.format();
		gnomeOdds.format();
		halflingOdds.format();
		halfelfOdds.format();
		halforcOdds.format();
		tieflingOdds.format();
		dragonbornOdds.format();
		
		//puts the total percentage represented into the 'total' label
		total.setText("Total: " + String.valueOf(odds.percentSum()) + "%");
		total.format();
		
		//textField settings
		humanText.format();
		elfText.format();
		dwarfText.format();
		halflingText.format();
		gnomeText.format();
		tieflingText.format();
		dragonbornText.format();
		halfelfText.format();
		halforcText.format();
	}
	
	//class to make editing the labels easier
	class MyLabel extends JLabel
	{
		private void format()
		{
			this.setForeground(Color.green);
			this.setFont(text);
			this.setHorizontalAlignment(JLabel.CENTER);  //Is this actually doing anything? I can't tell if it is
		}
	}
	
	class MyTextField extends JTextField
	{
		private void format()
		{
			this.setFont(text);
		}
	}

}