package model;

import java.util.Arrays;

import javax.print.attribute.standard.OutputDeviceAssigned;

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
	
	//Radix Sort
    // A utility function to get maximum value in arr[]
    static int getMax(int arr[], int n)
    {
        int mx = arr[0];
        for (int i = 1; i < n; i++)
            if (arr[i] > mx)
                mx = arr[i];
        return mx;
    }
    
    
    public void chooseIntAlgorithm(int[] a) {
    	
    	if(a.length <= 10000) {
    		int myIntArray[] = new int[a.length];
    		for (int i = 0; i < a.length; i++) {
				myIntArray[i] = (int) a[i];
			}
    		
//    			outArrayI = radixsort(myIntArray, myIntArray.length);
    			outArrayI = myIntArray.clone();
    			radixsort(outArrayI, outArrayI.length);
    	}else {
    		
    		//INSERT THE OTHER SORTH ALGORITHMS
    	}
    }
    
    /////////////////////////////////////
    ///////////// SORT ALGORITHMS ///////
    /////////////////////////////////////
    
    //////////////////////////
    //UTILITIES FOR RADIX SORT
    //////////////////////////
 
    // A function to do counting sort of arr[] according to
    // the digit represented by exp.
    static void countSort(int arr[], int n, int exp)
    {
        int output[] = new int[n]; // output array
        int i;
        int count[] = new int[10];
        Arrays.fill(count,0);
 
        // Store count of occurrences in count[]
        for (i = 0; i < n; i++)
            count[ (arr[i]/exp)%10 ]++;
 
        // Change count[i] so that count[i] now contains
        // actual position of this digit in output[]
        for (i = 1; i < 10; i++)
            count[i] += count[i - 1];
 
        // Build the output array
        for (i = n - 1; i >= 0; i--)
        {
            output[count[ (arr[i]/exp)%10 ] - 1] = arr[i];
            count[ (arr[i]/exp)%10 ]--;
        }
 
        // Copy the output array to arr[], so that arr[] now
        // contains sorted numbers according to curent digit
        for (i = 0; i < n; i++)
            arr[i] = output[i];
        	
    }
    
    ////////////////////////////////////
    //RADIX SORT
    ////////////////////////////////////
    //IF you need to sort with radix, use this
    // The main function to that sorts arr[] of size n using
    // Radix Sort
    public void radixsort(int arr[], int n)
    {
        // Find the maximum number to know number of digits
        int m = getMax(arr, n);
 
        // Do counting sort for every digit. Note that instead
        // of passing digit number, exp is passed. exp is 10^i
        // where i is current digit number.
        for (int exp = 1; m/exp > 0; exp *= 10)
            countSort(arr, n, exp);
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
