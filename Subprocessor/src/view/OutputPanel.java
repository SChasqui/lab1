package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class OutputPanel extends JPanel implements ActionListener{
	
	private static final String LEFT = "left";
	private static final String RIGHT = "right";
	
	private JPanel auxOutputPanel;
	private JPanel auxInfoPanel;
	private JButton bLeft;
	private JButton bRight;
	private JButton bSort;
	private JTextField txtEspacio;
	private JTextField txtSortTime;
	private JLabel labSortTime;
	private JLabel[] contentOfArray;
	private Window window;
	
	
	public OutputPanel(Window w) {
		
		window = w;
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Output"));
		
		auxInfoPanel = new JPanel();
		txtEspacio = new JTextField();
		
		//Initializing the auixiliar panel wich is going to contain the input Array
		auxOutputPanel = new JPanel();
		auxOutputPanel.setLayout(new GridLayout(1,14));
		
		
		// Elements initialization
		bLeft = new JButton(new ImageIcon("Data/left.png"));
		bLeft.addActionListener(this);
		bLeft.setActionCommand(LEFT);
		bRight = new JButton(new ImageIcon("Data/right.png"));
		bRight.addActionListener(this);
		bRight.setActionCommand(RIGHT);
		bSort = new JButton(new ImageIcon("Data/start.png"));
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
		auxOutputPanel.add(bLeft);
		auxOutputPanel.add(new JLabel());
		for (int i = 0; i < contentOfArray.length; i++) {
			auxOutputPanel.add(contentOfArray[i]);
		}
		auxOutputPanel.add(new JLabel());
		auxOutputPanel.add(bRight);
		
		//Initializing the auixiliar panel wich is going to show the Sorting's time information
		auxInfoPanel = new JPanel();
		auxInfoPanel.setPreferredSize(new Dimension(100,40));
		auxInfoPanel.setLayout(new GridLayout(1, 14));
		labSortTime = new JLabel("Sorting time:    ");
		txtSortTime = new JTextField("1.8");
		auxInfoPanel.add(labSortTime);
		auxInfoPanel.add(txtSortTime);
		for (int i = 0; i < 11; i++) {
			auxInfoPanel.add(new JLabel());
		}
		auxInfoPanel.add(bSort);
		
		
		add(auxOutputPanel, BorderLayout.NORTH);
		add(auxInfoPanel, BorderLayout.SOUTH);
	}


	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String command = event.getActionCommand();
		
		if(command.equals("Sort")) {
			
		}else if(command.equals("Sort")) {
//			window.getOut
		}
	}
}
