package view;

import java.awt.BorderLayout;

import javax.swing.JFrame;

public class Window extends JFrame {
	
	private InputPanel inputPanel;
	private RandomGeneratorPanel generatorPanel;
	
	public Window() {
		// Basic window settings
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		
		inputPanel = new InputPanel();
		add(inputPanel,BorderLayout.NORTH);
		
		generatorPanel = new RandomGeneratorPanel();
		add(generatorPanel, BorderLayout.WEST);
		pack();
	}
	
	public static void main(String[] args) {
		Window window = new Window();
	}

}
