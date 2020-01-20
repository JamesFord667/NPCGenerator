import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.text.MaskFormatter;

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
	private MyLabel totalOdds = new MyLabel();
	private MyLabel raceLabel = new MyLabel();
	private MyLabel oddsLabel = new MyLabel();
	
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
	private MyTextField totalText = new MyTextField();
	
	private String[][] races;	//holds the table with percentages and races
	private MyButton button = new MyButton("Update");
	private TextListener textListen = new TextListener();
	private JLabel emptyLabel = new JLabel();			//used as a placeholder so the button is in the right spot. 
	
	private Font text = new Font("Franklin Gothic Medium", Font.BOLD, 30);	//font for the text
	private Color darkerRed = new Color(223, 2, 35);	  //color used for text. The default red was too bright, this is better
	

	//taken off of oracle's website. It makes the Formatted Text Field work the way it should
	protected MaskFormatter createFormatter(String s) 
	{
		MaskFormatter formatter = null;
		try 
		{
			formatter = new MaskFormatter(s);
		} 
		catch (java.text.ParseException exc) 
		{
			System.err.println("formatter is bad: " + exc.getMessage());
			System.exit(-1);
		}
		return formatter;
	}
	
	
	public PercentagesPanel(RacePercentages odds)
	{		
		races = odds.getAll();		//set the string to equal the percentages and races
		
		//panel settings
		setLayout(new GridLayout(12, 2));
		add(raceLabel);
		add(oddsLabel);
		
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
		
		add(totalOdds);
		add(totalText);
		
		add(emptyLabel);
		add(button);
		setBackground(Color.black);
		
		//label settings
		//add text to labels
		raceLabel.setText("Race");
		oddsLabel.setText("Odds");
		humanOdds.setText(races[0][0] + ": " /*+ races[0][1] + "%"*/);
		elfOdds.setText(races[2][0] + ": " /*+ races[2][1] + "%"*/);
		dwarfOdds.setText(races[1][0] + ": " /*+ races[1][1] + "%"*/);
		gnomeOdds.setText(races[5][0] + ": " /*+ races[5][1] + "%"*/);
		halflingOdds.setText(races[3][0] + ": " /*+ races[3][1] + "%"*/);
		halfelfOdds.setText(races[6][0] + ": " /*+ races[6][1] + "%"*/);
		halforcOdds.setText(races[7][0] + ": " /*+ races[7][1] + "%"*/);
		tieflingOdds.setText(races[8][0] + ": " /*+ races[8][1] + "%"*/);
		dragonbornOdds.setText(races[4][0] + ": " /*+ races[4][1] + "%"*/);
		
		//makes the labels look nice
		raceLabel.format();
		raceLabel.setForeground(darkerRed);		//editing the color for visibility
		oddsLabel.format();
		oddsLabel.setForeground(darkerRed);		//editing the color for visibility
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
		totalOdds.setText("Total: " /*+ String.valueOf(odds.percentSum()) + "%"*/);
		totalOdds.format();
		
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
		
		totalText.format();
		totalText.setEditable(false);
		
		//sets the textField initial values
		humanText.setText(races[0][1]);
		elfText.setText(races[2][1]);
		dwarfText.setText(races[1][1]);
		halflingText.setText(races[3][1]);
		gnomeText.setText(races[5][1]);
		tieflingText.setText(races[8][1]);
		dragonbornText.setText(races[4][1]);
		halfelfText.setText(races[6][1]);
		halforcText.setText(races[7][1]);
		totalText.setText(String.valueOf(odds.percentSum()));
		
		//make the button look nice
				button.setFont(text);
				button.setBackground(Color.darkGray);
				button.setForeground(Color.green);
				button.addActionListener(textListen);
	}
	
	//class to make editing the labels easier
	class MyLabel extends JLabel
	{
		private void format()
		{
			this.setForeground(Color.green);		//sets the text color
			this.setFont(text);						//makes the font look nice
			this.setHorizontalAlignment(CENTER);  //Is this actually doing anything? I can't tell if it is
		}
	}
	
	//custom textField used so that the formatting is easier to do
	class MyTextField extends JFormattedTextField
	{
		//Formatter form = new Formatter();
		private void format()
		{
			this.setFont(text);				//sets the font to look nice
			this.setColumns(3);
			this.setBackground(Color.darkGray);			//provides the background color
			this.setForeground(Color.white);			//provides the text color
			this.setHorizontalAlignment(CENTER);		//centers the text in the field
			this.setFormatter(createFormatter("###"));	//sets the format to only allow numeric inputs
			this.setCaretColor(Color.white);			//needed for visibility of the cursor			
		}
		
		public void focusLost(FocusEvent e)
		{
			//this.setText(this.getText());
			System.out.println("Focus lost");
		}
		
	}
	
	//listener to go on the button at the bottom
	class TextListener implements ActionListener
	{
		public TextListener() {}

		@Override
		public void actionPerformed(ActionEvent e) 
		{
			//System.out.println("Clicked");  //debug
			
			races[0][1] = humanText.getText();
			races[1][1] = dwarfText.getText();
			races[2][1] = elfText.getText();
			races[3][1] = halflingText.getText();
			races[4][1] = dragonbornText.getText();
			races[5][1] = gnomeText.getText();
			races[6][1] = halfelfText.getText();
			races[7][1] = halforcText.getText();
			races[8][1] = tieflingText.getText();
			
			int sum = 0;
			for(int i = 0; i < 9; i++)
			{
				String a = races[i][1].replaceAll("\\s","");
				sum += Integer.parseInt(a);
			}
			
			totalText.setText(String.valueOf(sum));
			
		}	
	}
	
}