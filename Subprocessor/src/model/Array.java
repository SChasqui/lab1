package model;

public class Array {
	
	private double[] inArray;
	private double[] outArray;
	
	public Array() {
		// TODO Auto-generated constructor stub
	}
	
	// Method that generates a random arrangement of doubles without repetition
	public void randomWithoutRepetition(int min, int max, int size) {
		
		inArray = new double[size];
		
		double interval = (max-min) / size;
		
		for (int i = 0; i < inArray.length; i++) {
			inArray[i] =( Math.random() * interval ) + (min + (interval * i)) ;
		}
		
	}
	
	// Randomize the Order of the array
	public void randomizeOrder() {
		for (int i = 0; i < inArray.length; i++) {
			int num = (int) (Math.random() * inArray.length);
			double temp = inArray[i];
			inArray[i] = inArray[num];
			inArray[num] = temp;
		}
	}
	
	

}
