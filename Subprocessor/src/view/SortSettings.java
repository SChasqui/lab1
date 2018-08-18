package view;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class SortSettings extends JPanel{
	
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
	
	private Window window;
	
	public SortSettings(Window w) {
		
		setVisible(true);
		setLayout(new GridLayout(5,5));
		
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
		
		add(labInOrder);
		add(checkInOrder);
		add(labRandomOrder);
		add(checkRandom);
		add(labReverseOrder);
		add(checkReverse);
		add(labPercent);
		add(txtPercent);
		add(labSort);
		add(bSort);
		this.setBorder(BorderFactory.createTitledBorder("Sort Settings"));
		
	}
}
