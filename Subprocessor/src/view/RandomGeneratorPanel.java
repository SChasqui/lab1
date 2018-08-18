package view;

import java.awt.Checkbox;
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
	private JPanel auxLeftPanel;
	private JPanel auxRightPanel;
	
	private JLabel labInOrder;
	private JLabel labRandomOrder;
	private JLabel labReverseOrder;
	private JLabel labPercent;
	private JLabel labSort;
	
	private Checkbox checkInOrder;
	private Checkbox checkRandom;
	private Checkbox checkReverse;
	private JTextField txtPercent;
	
	private JButton bSort;
	
	public RandomGeneratorPanel() {
		
		//Main panel
		setLayout(new GridLayout(1, 2));
		
		//Auxiliar left panel init
		auxLeftPanel = new JPanel();
		
		//Auxiliar right panel init
		auxRightPanel = new JPanel();
		
		// Basic panel settings
		auxLeftPanel.setLayout(new GridLayout( 5 , 2 ));
		auxLeftPanel.setBorder(BorderFactory.createTitledBorder("Random Generator"));
		
		// LeftPanel Elements initialization
		numberOfElements = new JLabel("Number of elements");
		txtNumberOfElements = new JTextField();
		maxNumber = new JLabel("Max Number");
		txtMaxNumber = new JTextField();
		minNumber = new JLabel("Min Number");
		txtMinNumber = new JTextField();
		generate = new JLabel("Generate");
		btGenerate = new JButton(new ImageIcon("Data/start.png"));
		
		
		// Add Elements to left Panel
		auxLeftPanel.add(numberOfElements);
		auxLeftPanel.add(txtNumberOfElements);
		auxLeftPanel.add(maxNumber);
		auxLeftPanel.add(txtMaxNumber);
		auxLeftPanel.add(minNumber);
		auxLeftPanel.add(txtMinNumber);
		auxLeftPanel.add(numberOfElements);
		auxLeftPanel.add(txtNumberOfElements);
		auxLeftPanel.add(generate);
		auxLeftPanel.add(btGenerate);
		
		
		labInOrder = new JLabel("In order     ");
		labRandomOrder = new JLabel("Random Order     ");
		labReverseOrder = new JLabel("Reverse Order    ");
		labPercent = new JLabel("% Disorder    ");
		labSort =  new JLabel("Sort");
		
		checkInOrder = new Checkbox();
		checkRandom = new Checkbox();
		checkReverse = new Checkbox();
		
		txtPercent =  new JTextField();
		
		bSort =  new JButton("PLAY");
		
		auxRightPanel.add(labInOrder);
		auxRightPanel.add(checkInOrder);
		auxRightPanel.add(labRandomOrder);
		auxRightPanel.add(checkRandom);
		auxRightPanel.add(labReverseOrder);
		auxRightPanel.add(checkReverse);
		auxRightPanel.add(labPercent);
		auxRightPanel.add(txtPercent);
		auxRightPanel.add(labSort);
		auxRightPanel.add(bSort);
		auxRightPanel.setBorder(BorderFactory.createTitledBorder("Sort Settings"));
	
		add(auxLeftPanel);
		add(auxRightPanel);
	}

}
