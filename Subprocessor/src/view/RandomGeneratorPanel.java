package view;

import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RandomGeneratorPanel extends JPanel {
	
	private JLabel numberOfElements;
	private JTextField txtNumberOfElements;
	private JLabel maxNumber;
	private JTextField txtMaxNumber;
	private JLabel minNumber;
	private JTextField txtMinNumber;
	private JLabel generate;
	private JButton btGenerate;
	
	public RandomGeneratorPanel() {
		// Basic panel settings
		setLayout(new GridLayout( 5 , 2 ));
		setBorder(BorderFactory.createTitledBorder("Random Generator"));
		
		// Elements initialization
		numberOfElements = new JLabel("Number of elements");
		txtNumberOfElements = new JTextField();
		maxNumber = new JLabel("Max Number");
		txtMaxNumber = new JTextField();
		minNumber = new JLabel("Min Number");
		txtMinNumber = new JTextField();
		generate = new JLabel("Generate");
		btGenerate = new JButton(new ImageIcon("Data/start.png"));
		
		// Add Elements
		add(numberOfElements);
		add(txtNumberOfElements);
		add(maxNumber);
		add(txtMaxNumber);
		add(minNumber);
		add(txtMinNumber);
		add(numberOfElements);
		add(txtNumberOfElements);
		add(generate);
		add(btGenerate);
	}

}
