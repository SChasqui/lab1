package model;

public class Array {
	
	private double[] inArrayD;
	private double[] outArrayD;
	
	private int[] inArrayI;
	private int[] outArrayI;
	
	public Array() {
		
	}
	
	// Method that generates a random arrangement of doubles without repetition in order
	public void randomWithoutRepetitionO(int min, int max, int size) {
		
		inArrayD = new double[size];
		
		double interval = (max-min) / size;
		
		for (int i = 0; i < inArrayD.length; i++) {
			inArrayD[i] =( Math.random() * interval ) + (min + (interval * i)) ;
		}
		
	}
	
	// Method that generates a random arrangement of doubles without repetition in inverse-order
		public void randomWithoutRepetitionI(int min, int max, int size) {
			
			inArrayD = new double[size];
			
			double interval = (max-min) / size;
			
			for (int i = inArrayD.length - 1; i >= 0 ; i++) {
				inArrayD[i - inArrayD.length - 1] =( Math.random() * interval ) + (min + (interval * i)) ;
			}
			
		}
	
	// Randomize the Order of the array
	public void randomizeOrder() {
		for (int i = 0; i < inArrayD.length; i++) {
			int num = (int) (Math.random() * inArrayD.length);
			double temp = inArrayD[i];
			inArrayD[i] = inArrayD[num];
			inArrayD[num] = temp;
		}
	}

	public double[] getInArrayD() {
		return inArrayD;
	}

	public double[] getOutArrayD() {
		return outArrayD;
	}

	public int[] getInArrayI() {
		return inArrayI;
	}

	public int[] getOutArrayI() {
		return outArrayI;
	}

	public void addElementInt(int element, int index) {
		inArrayI[index] = element;
	}
	
	public void addElementDouble(double element, int index) {
		inArrayD[index]=element;
	}
	
	public void setUpArray(int size) {
		inArrayD = new double[size];
		inArrayI = new int[size];
	}

}
