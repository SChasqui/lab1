package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class RandomGeneratorPanel extends JPanel {
	
//	private 
	
	public RandomGeneratorPanel() {
		setLayout(new GridLayout( 5 , 2 ));
		setBorder(BorderFactory.createTitledBorder("Random Generator"));
	}

}
