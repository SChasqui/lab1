package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Array;

public class Window extends JFrame {
	
	// Graphic relations
	private InputPanel inputPanel;
	private RandomGeneratorPanel generatorPanel;
	private OutputPanel outputPanel;
	
	// Model relations
	private Array array;
	
	public Window() {
		// Basic window settings
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLayout(new BorderLayout());
		
		inputPanel = new InputPanel(this);
		generatorPanel = new RandomGeneratorPanel();
		outputPanel = new OutputPanel(this);
		array = new Array();
		
		//Add elements
		add(inputPanel,BorderLayout.NORTH);
		add(generatorPanel, BorderLayout.CENTER);
		add(outputPanel, BorderLayout.SOUTH);
		
		pack();
	}
	
	public static void main(String[] args) {
		Window window = new Window();
	}

	public double[] getInArrayD() {
		return array.getInArrayD();
	}

	public void createModelArray(int size) {
		array.setUpArray(size);
	}

	public void addElementI(int element, int index) {
		array.addElementInt(element, index);		
	}

	public void addElementD(double element, int index) {
		array.addElementDouble(element, index);
	}

	public int[] getInArrayI() {
		return array.getInArrayI();
	}
	
	public int[] getOutArrayI() {
		return array.getOutArrayI();
	}
	
	public double[] getOutArrayD() {
		return array.getOutArrayD();
	}

}
