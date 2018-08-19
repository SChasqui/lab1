package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class InputPanel extends JPanel implements ActionListener{
	
	private static final String LEFT = "left";

	private static final String RIGHT = "right";

	private static final String ADD = "add";

	private static final String SET = "set";

	private Window window;
	
	private int index;
	private int mark;
	
	// These elements are responsible for extracting the input data
	private JPanel subPanelIn;
	private JLabel input;
	private JTextField txtInput;
	private JLabel arraySize;
	private JTextField txtArraySize;
	private JButton btAdd;
	private JButton btSet;
	
	// These elements are responsible for showing the content that the user has entered
	private JPanel subPanelOut;
	private JButton btLeft;
	private JButton btRight;
	private JLabel[] contentOfArray;
	
	// Float numbers check
	private JPanel subPanelCheck;
	private JCheckBox checkFloat;
	

	public InputPanel(Window window) {
		
		this.window = window;
		
		index = 0;
		
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
		subPanelIn.setLayout(new GridLayout(2, 3));
		
		// Elements initialization
		input = new JLabel("Input:");
		txtInput = new JTextField();
		btAdd = new JButton("Add");
		btAdd.addActionListener(this);
		btAdd.setActionCommand(ADD);
		arraySize = new JLabel("Size:");
		txtArraySize = new JTextField();
		btSet = new JButton("Set");
		btSet.addActionListener(this);
		btSet.setActionCommand(SET);
		
		// Add Elements
		subPanelIn.add(input);
		subPanelIn.add(txtInput);
		subPanelIn.add(btAdd);
		subPanelIn.add(arraySize);
		subPanelIn.add(txtArraySize);
		subPanelIn.add(btSet);
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
			contentOfArray[i] = new JLabel("" + i,SwingConstants.CENTER);
			contentOfArray[i].setFont(new Font("Arial", Font.BOLD, 30));
			contentOfArray[i].setForeground(Color.BLUE);
			contentOfArray[i].setOpaque(true);
			contentOfArray[i].setBackground(Color.white);
			contentOfArray[i].setBorder(BorderFactory.createTitledBorder(""));
		}
		
		// Add Elements
		subPanelOut.add(btLeft);
		subPanelOut.add(new JLabel());
		for (int i = 0; i < contentOfArray.length; i++) {
			subPanelOut.add(contentOfArray[i]);
		}
		subPanelOut.add(new JLabel());
		subPanelOut.add(btRight);
	}
	
	public boolean isFloat() {
		return checkFloat.isSelected();
	}
	
	public void paintArrayD(double[] array) {
		for (int i = 0; i < contentOfArray.length && i + index < Integer.parseInt(txtArraySize.getText()) ; i++) {
			contentOfArray[i].setText(array[index+i] + "");
			contentOfArray[i].setBorder(BorderFactory.createTitledBorder(""+(index+mark)));
		}
	}

	private void paintArrayI(int[] array) {
		System.out.println(index);
		for (int i = 0; i < contentOfArray.length && i + index < Integer.parseInt(txtArraySize.getText()) ; i++) {
			contentOfArray[i].setText(array[index+i] + "");
			contentOfArray[i].setBorder(BorderFactory.createTitledBorder(""+(index+i)));
			System.out.println(index+i);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent event) {
		String command = event.getActionCommand();
		
		if (command.equals(LEFT) && !txtArraySize.isEditable()) {
			
			if (mark > 0) {
				contentOfArray[mark].setBackground(Color.white);
				mark--;
				contentOfArray[mark].setBackground(Color.red);
			}else {
				index = index > 0? index-1 : 0;
			}
			
			if (isFloat()) {
				double[] array = window.getInArrayD();
				paintArrayD(array);
			} else {
				int[] array = window.getInArrayI();
				paintArrayI(array);
			}
			
		}else if (command.equals(RIGHT) && !txtArraySize.isEditable()) {
			
			if (mark < 9) {
				contentOfArray[mark].setBackground(Color.white);
				mark++;
				contentOfArray[mark].setBackground(Color.red);
			}else {
				index = index < Integer.parseInt(txtArraySize.getText()) - 10 ? index + 1 : index;
			}
			
			if (isFloat()) {
				double[] array = window.getInArrayD();
				paintArrayD(array);
			} else {
				int[] array = window.getInArrayI();
				paintArrayI(array);
			}
			
		}else if (command.equals(ADD) && !txtArraySize.isEditable()) {
			
			try {
				if (isFloat()) {
					window.addElementD(Double.parseDouble(txtInput.getText()),index + mark);
					double[] array = window.getInArrayD();
					paintArrayD(array);
				} else {
					window.addElementI(Integer.parseInt(txtInput.getText()),index + mark);
				}
				
			} catch (NullPointerException | NumberFormatException e) {
				// TODO: handle exception
			}
			
		}else if (command.equals(SET) && txtArraySize.isEditable()) {
			try {
				int size = Integer.parseInt(txtArraySize.getText());
				txtArraySize.setEditable(false);
				window.createModelArray(size);
			} catch (NullPointerException | NumberFormatException e) {
				JOptionPane.showMessageDialog(this, "you need to write a size to the array before putting it", "Error", JOptionPane.ERROR_MESSAGE);
			}
		}else if (command.equals(SET) && !txtArraySize.isEditable()) {
			int option = JOptionPane.showOptionDialog(this, "You want to change the size of the input?", "Question", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, null);
			if (option == 0) {
				txtArraySize.setEditable(true);
			}
		}
	}

	
}
