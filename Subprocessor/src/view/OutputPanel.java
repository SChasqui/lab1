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
	private static final String SORT = "sort";
	
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
	
	private int index;
	private int mark;
	
	
	public OutputPanel(Window w) {
		
		window = w;
		index = 0;
		
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
		bSort.addActionListener(this);
		bSort.setActionCommand(SORT);
		contentOfArray = new JLabel[10];
		for (int i = 0; i < contentOfArray.length; i++) {
			contentOfArray[i] = new JLabel("" + "",SwingConstants.CENTER);
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
	
	public void paintArrayD(double[] array) {
		for (int i = 0; i < contentOfArray.length ; i++) {
			contentOfArray[i].setText(array[index+i] + "");
			contentOfArray[i].setBorder(BorderFactory.createTitledBorder(""+(index+mark)));
		}
	}

	private void paintArrayI(int[] array) {
		try {
			
			System.out.println(index);
			for (int i = 0; i < contentOfArray.length ; i++) {
				System.out.println(array[index+i]);
				contentOfArray[i].setText(array[index+i] + "");
				contentOfArray[i].setBorder(BorderFactory.createTitledBorder(""+(index+i)));
				System.out.println(index+i);
			}
		} catch (Exception e) {
			System.out.println("Desborde controlado");
		}
	}

	@Override
	public void actionPerformed(ActionEvent event) {
		// TODO Auto-generated method stub
		String command = event.getActionCommand();
		
		if(command.equals(SORT)) {
			if(window.isActualFloat()) {
				window.sortDoubleInput(window.getInArrayD());
				paintArrayD(window.getOutArrayD());
			}else {
				window.sortIntInput(window.getInArrayI());
				paintArrayI(window.getOutArrayI());
				
			}
		}else if(command.equals(LEFT)) {
			if (mark > 0) {
				contentOfArray[mark].setBackground(Color.white);
				contentOfArray[mark].setForeground(Color.blue);
				mark--;
				contentOfArray[mark].setBackground(Color.blue);
				contentOfArray[mark].setForeground(Color.white);
			}else {
				index = index > 0? index-1 : 0;
			}
			
			if (window.isActualFloat()) {
				double[] array = window.getOutArrayD();
				paintArrayD(array);
			} else {
				int[] array = window.getOutArrayI();
				paintArrayI(array);
			}

		}else if(command.equals(RIGHT)) {
			if (mark < 9 ) {
				contentOfArray[mark].setBackground(Color.white);
				contentOfArray[mark].setForeground(Color.blue);
				mark++;
				contentOfArray[mark].setBackground(Color.blue);
				contentOfArray[mark].setForeground(Color.white);
			}else {
				index = index < window.getActualArraySize() - 10 ? index + 1 : index;
			}
			
			if (window.isActualFloat()) {
				double[] array = window.getOutArrayD();
				paintArrayD(array);
			} else {
				int[] array = window.getOutArrayI();
				paintArrayI(array);
			}
		}
	}
}
