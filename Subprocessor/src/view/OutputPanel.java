package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class OutputPanel extends JPanel{
	
	private JPanel auxOutputPanel;
	private JPanel auxInfoPanel;
	private JButton bLeft;
	private JButton bRight;
	private JTextField txtEspacio;
	private JTextField txtSortTime;
	private JLabel labSortTime;
	
	
	public OutputPanel() {
		
		
		setLayout(new BorderLayout());
		setBorder(BorderFactory.createTitledBorder("Output"));
		
		auxInfoPanel = new JPanel();
		bLeft = new JButton("Izq");
		bRight = new JButton("Der");
		txtEspacio = new JTextField();
		
		//Initializing the auixiliar panel wich is going to contain the input Array
		auxOutputPanel = new JPanel();
		auxOutputPanel.setLayout(new BorderLayout());
		auxOutputPanel.add(bLeft, BorderLayout.WEST);
		auxOutputPanel.add(bRight, BorderLayout.EAST);
		auxOutputPanel.add(txtEspacio, BorderLayout.CENTER);
		
		//Initializing the auixiliar panel wich is going to show the Sorting's time information
		auxInfoPanel = new JPanel();
		auxInfoPanel.setLayout(new GridLayout(1, 3));
		labSortTime = new JLabel("Sorting time: ");
		txtSortTime = new JTextField("1.8");
		auxInfoPanel.add(labSortTime);
		auxInfoPanel.add(txtSortTime);
		
		
		add(auxOutputPanel, BorderLayout.NORTH);
		add(auxInfoPanel, BorderLayout.SOUTH);
	}
}
