package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class InputPanel extends JPanel implements ActionListener{
	
	private static final String LEFT = "left";

	private static final String RIGHT = "right";

	private Window window;
	
	// These elements are responsible for extracting the input data
	private JPanel subPanelIn;
	private JLabel input;
	private JTextField txtInput;
	private JLabel arraySize;
	private JTextField txtArraySize;
	private JButton btAdd;
	
	// These elements are responsible for showing the content that the user has entered
	private JPanel subPanelOut;
	private JButton btLeft;
	private JButton btRight;
	private JLabel[] contentOfArray;
	
	// This label works like a space 
	private JLabel space = new JLabel("");
	
	// Float numbers check
	private JPanel subPanelCheck;
	private JCheckBox checkFloat;
	

	public InputPanel(Window window) {
		
		this.window = window;
		
		// Basic panel settings
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Input"));
		
		// make the panels
		fillSubPanelIn();
		fillSubPanelOut();
		fillSubPanelCheck();
		
		// add the panels
		add(subPanelIn, BorderLayout.WEST);
		add(subPanelOut, BorderLayout.CENTER);
		add(subPanelCheck,BorderLayout.EAST);
	}
	
	public void fillSubPanelCheck() {
		// Sub panel initialization
		subPanelCheck = new JPanel();
		
		// Elements initialization
		checkFloat = new JCheckBox("check if you plan to use floating point numbers");
		
		// Add Elements
		subPanelCheck.add(checkFloat);
	}
	
	public void fillSubPanelIn() {
		// Sub panel initialization
		subPanelIn = new JPanel();
		subPanelIn.setLayout(new GridLayout(3, 2));
		
		// Elements initialization
		input = new JLabel("Input:");
		txtInput = new JTextField();
		arraySize = new JLabel("Size:");
		txtArraySize = new JTextField();
		btAdd = new JButton("Add");
		
		// Add Elements
		subPanelIn.add(input);
		subPanelIn.add(txtInput);
		subPanelIn.add(arraySize);
		subPanelIn.add(txtArraySize);
		subPanelIn.add(space);
		subPanelIn.add(btAdd);
	}
	
	public void fillSubPanelOut() {
		// Sub panel initialization
		subPanelOut = new JPanel();
		subPanelOut.setLayout(new GridLayout(1, 14));
		
		// Elements initialization
		btLeft = new JButton(new ImageIcon("Data/left.png"));
		btLeft.addActionListener(this);
		btLeft.setActionCommand(LEFT);
		btRight = new JButton(new ImageIcon("Data/right.png"));
		btRight.addActionListener(this);
		btRight.setActionCommand(RIGHT);
		contentOfArray = new JLabel[10];
		for (int i = 0; i < contentOfArray.length; i++) {
			contentOfArray[i] = new JLabel();
		}
		
		// Add Elements
		subPanelOut.add(btLeft);
		subPanelOut.add(space);
		for (int i = 0; i < contentOfArray.length; i++) {
			subPanelOut.add(contentOfArray[i]);
		}
		subPanelOut.add(space);
		subPanelOut.add(btRight);
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		
	}
	
}
