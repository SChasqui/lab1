package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private InputPanel inputPanel;
	private RandomGeneratorPanel generatorPanel;
	private SortSettings sortSettingsPanel;
	
	public Window() {
		// Basic window settings
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		inputPanel = new InputPanel();
		add(inputPanel,BorderLayout.NORTH);
		
		generatorPanel = new RandomGeneratorPanel();
		add(generatorPanel, BorderLayout.WEST);
		
		sortSettingsPanel = new SortSettings(this);
		add(sortSettingsPanel, BorderLayout.EAST);
		
		pack();
	}
	
	public static void main(String[] args) {
		Window window = new Window();
	}

}
