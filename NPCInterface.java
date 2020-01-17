/**
 * Author: James Ford
 * Purpose of class: This class is the GUI for the NPC name generator. It makes the things users interact with.
 * 					 It also holds the information for the button. 
 */
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class NPCInterface {
	
	//attributes
	private JFrame frame = new JFrame("NPC Generator");   //frame that displays everything
	private JPanel title = new JPanel();				  //panel that holds the title information
	private JPanel output = new JPanel();				  //panel that holds everything to be displayed
	private JLabel heading = new JLabel("NPC Generator"); //label that goes on top of the frame
	private MyButton generate = new MyButton("Make NPC"); //button used to make a new NPC
	private MyButton showPreviousNames = new MyButton("Show last 3 characters");		//used to display the previous three characters. 
	private JLabel name = new JLabel();					  //label that holds the name to be displayed
	private JLabel race = new JLabel();					  //label that holds the race to be displayed
	private JPanel npc = new JPanel();					  //label that holds the information about the NPC
	private ActionListener listener = new ClickListener();		  //listener for the button
	private RacePercentages percents = new RacePercentages();
	private PercentagesPanel percentPane = new PercentagesPanel(percents);
	private JPanel output2 = new JPanel();				  //stores the output panel along with the side panel with the race percentages
	
	//private Color tan = new Color(197, 158, 126);		  //color used as a background since 'brown' is not a default option    //currently not in use
	//private Color brown = new Color(120, 74, 50);		  //color used as a background since 'brown' is not a default option	//currently not in use
	private Color purple = new Color(157, 70, 157);		  //color used for bottom text (purple is not a default option)
	private Color darkerRed = new Color(223, 2, 35);	  //color used for text. The default red was too bright, this is better
	private Font text = new Font("Franklin Gothin Medium", Font.BOLD, 70);	//font used for the text that is displayed
	
	private String[] newNPC;							  //String that holds the information about the NPC
	private GeneratorMachine nameGen = new GeneratorMachine();		  //GeneratorMachine class that contains the generator
	
	
	public NPCInterface()
	{
		//settings for the frame
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
		frame.setSize(1600, 900);
		frame.add(output2);
		
		//settings for the title label
		heading.setForeground(darkerRed);   //maybe a darker than default red
		heading.setFont(text);
		heading.setVerticalAlignment(JLabel.CENTER);
		
		//settings for the title panel
		title.setLayout(new GridBagLayout());  //need this to get the text vertically centered. 
		title.add(heading);
		title.setBackground(Color.black);
		
		//settings for the name and race labels
		name.setForeground(purple);
		name.setFont(text);
		race.setForeground(purple);
		race.setFont(text);
		
		//settings for npc panel
		npc.setLayout(new GridBagLayout());   //centers the text vertically
		npc.add(race);
		npc.add(name);
		npc.setBackground(Color.black);
		
		//settings for the 'output' panel
		output.setLayout(new GridLayout(4, 1));
		output.add(title);
		output.add(npc);
		output.add(generate);
		output.add(showPreviousNames);
		
		//settings for output2 panel
		output2.setLayout(new BorderLayout());
		output2.add(output, BorderLayout.CENTER);
		output2.add(percentPane, BorderLayout.WEST);
		
		//settings for the generate button
		generate.setFont(text);
		generate.setForeground(darkerRed);
		generate.setBackground(Color.black);
		generate.addActionListener(listener);
		generate.setBorderPainted(false);
		generate.setFocusPainted(false);
		
		//settings for the showPreviousNames button
		showPreviousNames.setFont(text);
		showPreviousNames.setForeground(darkerRed);
		showPreviousNames.setBackground(Color.black);
		showPreviousNames.addActionListener(listener);
		showPreviousNames.setBorderPainted(false);
		showPreviousNames.setFocusPainted(false);
		
		//sets up the initial name
		newNPC = nameGen.generate();
		this.setOutput(newNPC[0], newNPC[1]);
		
	}
	
	//methods
	
	//This method takes a race and name and then puts them into the JFrame
	public void setOutput(String inRace, String inName)
	{
		race.setText(inRace + "     ");		//sets the race
		name.setText(inName);				//sets the name
	}
	
	/** Additional classes needed */
	
	//creates the listener for the buttons
	class ClickListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{	
			if(e.getActionCommand().equals("Make NPC"))
			{
				newNPC = nameGen.generate();	//generates the new NPC
				setOutput(newNPC[0], newNPC[1]);//puts the new NPC's information into the display
			}
			else if(e.getActionCommand().equals("Show last 3 characters"))
			{
				@SuppressWarnings("unused")
				PreviousNamesPopup pop = new PreviousNamesPopup(nameGen.getPreviousCharacters());   //for testing. It shows that the previous names popup works.
			}
		}	
	}
}