package view;

import java.awt.Checkbox;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class RandomGeneratorPanel extends JPanel implements ActionListener{
	
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
	
	private Checkbox checkInOrder;
	private Checkbox checkRandom;
	private Checkbox checkReverse;
	private JTextField txtPercent;
	
	private ButtonGroup radioButtonGrup;
	
	
	public RandomGeneratorPanel() {
		
		//Main panel
		setLayout(new GridLayout(1, 2));
		
		//Auxiliary left panel init
		auxLeftPanel = new JPanel();
		
		//Auxiliary right panel init
		auxRightPanel = new JPanel();
		
		// Basic right panel settings
		auxRightPanel.setLayout(new GridLayout(4, 2));
		auxRightPanel.setBorder(BorderFactory.createTitledBorder("Random Settings"));
		
		// Basic left panel settings
		auxLeftPanel.setLayout(new GridLayout( 4 , 2 ));
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
		btGenerate.addActionListener(this);
		
		
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
		
		
		labInOrder = new JLabel("In order");
		labRandomOrder = new JLabel("Random Order");
		labReverseOrder = new JLabel("Reverse Order");
		labPercent = new JLabel("% Disorder");
		
		checkInOrder = new Checkbox();
		checkRandom = new Checkbox();
		checkReverse = new Checkbox();
		
		txtPercent =  new JTextField();
		
		
		auxRightPanel.add(labInOrder);
		auxRightPanel.add(checkInOrder);
		auxRightPanel.add(labRandomOrder);
		auxRightPanel.add(checkRandom);
		auxRightPanel.add(labReverseOrder);
		auxRightPanel.add(checkReverse);
		auxRightPanel.add(labPercent);
		auxRightPanel.add(txtPercent);
	
		add(auxLeftPanel);
		add(auxRightPanel);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
	}

}
