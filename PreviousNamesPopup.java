import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PreviousNamesPopup {
	
	private JFrame frame = new JFrame("Previous three characters");		//frame that holds everything
	private JPanel panel = new JPanel();								//panel to go in the frame and hold the information
	private JLabel firstName = new JLabel();							//label that holds the most previous name
	private JLabel secondName = new JLabel();							//label that holds the second previous name
	private JLabel thirdName = new JLabel();							//label that holds the third previous name
	private MyButton closeButton = new MyButton("Close");
	private ActionListener listener = new ClickListener();
	private Font text = new Font("Franklin Gothic Medium", Font.BOLD, 42);	//font for the text
	private Color purple = new Color(157, 70, 157);		  //color used for bottom text (purple is not a default option)
	
	public PreviousNamesPopup(String[][] namesIn)
	{
		//frame settings
		frame.setSize(700, 600);
		frame.setVisible(true);
		frame.add(panel);
		
		//label settings
		firstName.setText(namesIn[1][0] + "   " + namesIn[1][1]);
		secondName.setText(namesIn[2][0] + "   " + namesIn[2][1]);
		thirdName.setText(namesIn[3][0] + "   " + namesIn[3][1]);
		
		firstName.setFont(text);
		secondName.setFont(text);
		thirdName.setFont(text);
		
		firstName.setForeground(purple);
		secondName.setForeground(purple);
		thirdName.setForeground(purple);
		
		firstName.setHorizontalAlignment(JLabel.CENTER);
		secondName.setHorizontalAlignment(JLabel.CENTER);
		thirdName.setHorizontalAlignment(JLabel.CENTER);
		
		//panel settings
		panel.setLayout(new GridLayout(4, 1));
		panel.add(firstName);
		panel.add(secondName);
		panel.add(thirdName);
		panel.add(closeButton);
		panel.setBackground(Color.white);
		
		//button settings
		closeButton.setFont(new Font("Franklin Gothic Medium", Font.BOLD, 48));
		closeButton.setForeground(Color.red);
		closeButton.setBackground(Color.white);
		closeButton.setHoverBackgroundColor(Color.gray);
		closeButton.setPressedBackgroundColor(Color.gray);
		closeButton.addActionListener(listener);
		closeButton.setBorderPainted(false);
		closeButton.setFocusPainted(false);
	}

	//creates the listener for the button
	class ClickListener implements ActionListener
	{
		@Override
		public void actionPerformed(ActionEvent e) 
		{	
			frame.dispose();
		}	
	}
}
