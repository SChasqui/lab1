package view;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import model.ImpossibleOperation;

public class RandomGeneratorPanel extends JPanel implements ActionListener, ItemListener{

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

	// Labels
	private JLabel labInOrder;
	private JLabel labRandomOrder;
	private JLabel labReverseOrder;
	private JLabel labPercent;

	// CheckBox
	private JCheckBox checkInOrder;
	private JCheckBox checkRandom;
	private JCheckBox checkReverse;
	private JCheckBox checkRepetition;

	// TextField
	private JTextField txtPercent;

	// Window relation
	private Window window;


	public RandomGeneratorPanel(Window window) {

		this.window = window;

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

		labPercent = new JLabel("% Disorder");

		checkInOrder = new JCheckBox("In order");
		checkInOrder.addItemListener(this);
		checkRandom = new JCheckBox("Random Order");
		checkRandom.addItemListener(this);
		checkReverse = new JCheckBox("Reverse Order");
		checkReverse.addItemListener(this);
		checkRepetition = new JCheckBox("Repetition");

		txtPercent =  new JTextField();


		// Add Elements to Right Panel
		auxRightPanel.add(checkInOrder);
		auxRightPanel.add(checkRandom);
		auxRightPanel.add(checkReverse);
		auxRightPanel.add(checkRepetition);
		auxRightPanel.add(labPercent);
		auxRightPanel.add(txtPercent);

		add(auxLeftPanel);
		add(auxRightPanel);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		try {
			if (checkInOrder.isSelected() || checkRandom.isSelected()) {

				window.generateRandomInOrder(Integer.parseInt(txtMaxNumber.getText()),
						Integer.parseInt(txtMinNumber.getText()),Integer.parseInt(txtNumberOfElements.getText())
						, checkRepetition.isSelected(),checkRandom.isSelected());

			}else if(checkReverse.isSelected()) {
				window.generateRandomReverseOrder(Integer.parseInt(txtMaxNumber.getText()),
						Integer.parseInt(txtMinNumber.getText()),Integer.parseInt(txtNumberOfElements.getText())
						, checkRepetition.isSelected());
			}else if(Integer.parseInt(txtPercent.getText()) > 0) {
				window.generateRandomPersentDisorder(Integer.parseInt(txtMaxNumber.getText()),
						Integer.parseInt(txtMinNumber.getText()),Integer.parseInt(txtNumberOfElements.getText())
						, checkRepetition.isSelected(), Double.parseDouble(txtPercent.getText()));
			}
		}		
		catch (NumberFormatException | ImpossibleOperation e) {
			JOptionPane.showMessageDialog(this, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
		}
	}

	@Override
	public void itemStateChanged(ItemEvent event) {
		boolean inOrder = checkInOrder.isSelected();
		boolean random = checkRandom.isSelected();
		boolean reverse = checkReverse.isSelected();

		if (!(   (inOrder & !random && ! reverse) 
				|| (!inOrder && random && !reverse)
				|| (!inOrder && !random && reverse)
				)) {
			checkInOrder.setSelected(false);
			checkRandom.setSelected(false);
			checkReverse.setSelected(false);
		}

	}

	//	public int actualSizeOfArray() {
	//		return Integer.parseInt(txtNumberOfElements.getText());
	//	}
}
