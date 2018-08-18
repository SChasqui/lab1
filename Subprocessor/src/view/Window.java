package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Window extends JFrame {
	
	private JPanel auxiliarPanel;
	private InputPanel inputPanel;
	private RandomGeneratorPanel generatorPanel;
	private SortSettings sortSettingsPanel;
	private OutputPanel outputPanel;
	
	public Window() {
		// Basic window settings
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		inputPanel = new InputPanel();
		generatorPanel = new RandomGeneratorPanel();
		sortSettingsPanel = new SortSettings(this);
		outputPanel = new OutputPanel();
		
		//Add elements
		
		add(inputPanel,BorderLayout.NORTH);
		
		auxiliarPanel = new JPanel();
		auxiliarPanel.setLayout(new GridLayout(1, 2));
		
		auxiliarPanel.add(generatorPanel);
		auxiliarPanel.add(sortSettingsPanel);
		
		add(auxiliarPanel, BorderLayout.CENTER);
		add(outputPanel, BorderLayout.SOUTH);
		
		pack();
	}
	
	public static void main(String[] args) {
		Window window = new Window();
	}

}
