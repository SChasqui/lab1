package view;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

import model.Array;
import model.ImpossibleOperation;

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
		generatorPanel = new RandomGeneratorPanel(this);
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

	public boolean isActualFloat() {
		// TODO Auto-generated method stub
		return inputPanel.isFloat();
	}

	public void sortIntInput(int[] a) {
		array.chooseIntAlgorithm(a);
	}

	public void sortDoubleInput(double[] a) {
		array.chooseDoubleAlgorithm(a);
	}
	
	public void generateRandomInOrder(int max, int min, int size, boolean repetition) throws ImpossibleOperation {
		if (inputPanel.isFloat() && !repetition && (max-min)/size > 0) {
			array.randomWithoutRepetitionOD(min, max, size);
			inputPanel.setSize(size);
		}else if(!inputPanel.isFloat() && !repetition && (int)((max-min)/size) > 0){
			array.randomWithoutRepetitionOI(min, max, size);
			inputPanel.setSize(size);
		}else {
			throw new ImpossibleOperation("the values entered do not allow the creation of an array with the conditions proposed for the random");
		}
		
	}
	
	public int getActualArraySize() {
//		return generatorPanel.get
		return inputPanel.getArraySize();
	}

	public void generateRandomReverseOrder(int max, int min, int size, boolean repetition) throws ImpossibleOperation {
		if (inputPanel.isFloat() && !repetition && (max-min)/size > 0) {
			array.randomWithoutRepetitionID(min, max, size);
			inputPanel.setSize(size);
		}else if(!inputPanel.isFloat() && !repetition && (int)((max-min)/size) > 0){
			array.randomWithoutRepetitionII(min, max, size);
			inputPanel.setSize(size);
		}else {
			throw new ImpossibleOperation("the values entered do not allow the creation of an array with the conditions proposed for the random");
		}
	}


}
