package model;

import java.util.Arrays;

import javax.print.attribute.standard.OutputDeviceAssigned;

public class Array {

	private double[] inArrayD;
	private double[] outArrayD;
	private int upperLimit;
	private double orderPercentege;
	private int[] inArrayI;
	private int[] outArrayI;

	public Array() {

	}

	public void disorderByPercentageD(double percentage, int size) {
		int num = (int) Math.round((size * (percentage/100)));
		while (num > 0) {
			int index1 = (int) (Math.random()*size);
			int index2 = (int) (Math.random()*size);
			double temp = inArrayD[index1];
			inArrayD[index1] = inArrayD[index2];
			inArrayD[index2] = temp;
		}
	}

	public void disorderByPercentageI(double percentage, int size) {
		int num = (int) Math.round((size * (percentage/100)));
		while (num > 0) {
			int index1 = (int) (Math.random()*size);
			int index2 = (int) (Math.random()*size);
			int temp = inArrayI[index1];
			inArrayI[index1] = inArrayI[index2];
			inArrayI[index2] = temp;
			num--;
		}
	}

	// Method that generates a random arrangement of doubles without repetition in order
	public void randomWithoutRepetitionOD(int min, int max, int size) {

		inArrayD = new double[size];

		double interval = (double) (max-min) / size;

		for (int i = 0; i < inArrayD.length; i++) {
			inArrayD[i] =( Math.random() * interval ) + (min + (interval * i)) ;
		}

	}

	// Method that generates a random arrangement of doubles without repetition in inverse-order
	public void randomWithoutRepetitionID(int min, int max, int size) {

		inArrayD = new double[size];

		double interval = (double) (max-min) / size;

		for (int i = 0; i <inArrayD.length ; i++) {
			inArrayD[inArrayD.length - 1 - i] = ( Math.random() * interval ) + (min + (interval * i));
		}
	}

	// Method that generates a random arrangement of int without repetition in order
	public void randomWithoutRepetitionOI(int min, int max, int size) {

		inArrayI = new int[size];

		double interval = (max-min) / size;

		for (int i = 0; i < inArrayI.length; i++) {
			inArrayI[(inArrayI.length - 1) - i] = (int) (( Math.random() * interval ) + (min + (interval * i))) ;
		}

	}

	// Method that generates a random arrangement of doubles without repetition in inverse-order
	public void randomWithoutRepetitionII(int min, int max, int size) {

		inArrayI = new int[size];

		double interval = (max-min) / size;

		for (int i = 0; i < inArrayI.length ; i++) {
			inArrayI[inArrayI.length - i- 1] =(int) (( Math.random() * interval ) + (min + (interval * i))) ;
		}

	}

	// Randomize the Order of the double array
	public void randomizeOrderD() {
		for (int i = 0; i < inArrayD.length; i++) {
			int num = (int) (Math.random() * inArrayD.length);
			double temp = inArrayD[i];
			inArrayD[i] = inArrayD[num];
			inArrayD[num] = temp;
		}
	}

	// Randomize the Order of the int array
	public void randomizeOrderI() {
		for (int i = 0; i < inArrayI.length; i++) {
			int num = (int) (Math.random() * inArrayI.length);
			int temp = inArrayI[i];
			inArrayI[i] = inArrayI[num];
			inArrayI[num] = temp;
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

		int myIntArray[] = new int[a.length];
		outArrayI = myIntArray.clone();
		if(a.length <= 10000) {
			//    			outArrayI = radixsort(myIntArray, myIntArray.length);
			radixsort(outArrayI, outArrayI.length);
		}else {
			//INSERT THE OTHER SORTH ALGORITHMS
			outArrayI = mergeForInts(a);
		}
	}

	public void chooseDoubleAlgorithm(double[] a) {
		outArrayD = mergesort(a);
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



	/////////////////////////////////////////
	////// MERGE SORT FOR DOUBLES
	////////////////////////////////////
	//Utilities
	////////////////////////////////////
	private static double[] merge(double[] a, double[] b) {
		double[] c = new double[a.length + b.length];
		int i = 0, j = 0;
		for (int k = 0; k < c.length; k++) {
			if      (i >= a.length) c[k] = b[j++];
			else if (j >= b.length) c[k] = a[i++];
			else if (a[i] <= b[j])  c[k] = a[i++];
			else                    c[k] = b[j++];
		}
		return c;
	}



	////////////////////////////////////////////
	// If you want to sort big doubles use this  
	////////////////////////////////////////////
	public static double[] mergesort(double[] input) {
		int N = input.length;
		if (N <= 1) return input;
		double[] a = new double[N/2];
		double[] b = new double[N - N/2];
		for (int i = 0; i < a.length; i++)
			a[i] = input[i];
		for (int i = 0; i < b.length; i++)
			b[i] = input[i + N/2];
		return merge(mergesort(a), mergesort(b));
	}


	///////////////////////////////////////////////////////
	//This is an auxiliary method to the method Merge Sort.
	//////////////////////////////////////////////////////
	public void auxiliaryForMerge(int[] arr,int a,int b,int c,int d){ 

		//It line finds the minimum value of an numeric array
		d = Math.min(d,arr.length-1);    

		//It is an auxiliary array 
		int aux [] = new int[d-a + 1]; 

		int k = 0; 
		int or = a; 

		while( k < aux.length) 
			if((a>b ?false: (c>d? true : arr[a] <= arr[c]))) 
				aux[k++] = arr[a++];         
			else 
				aux[k++] = arr[c++];      

		for(int i = 0; i < aux.length; i++) 
			arr[or + i] = aux[i];     
	}



	////////////////////////
	//Merge Sort for ints
	////////////////////////
	public int[] mergeForInts(int arr[]) {
		int i = 1; 
		for(i = 1; i < arr.length;i*=2){ 
			for(int j = 0;j < arr.length; j += i){ 
				int p = i >> 1; 
			auxiliaryForMerge(arr,j,j+p-1,j+p,j+p+p-1); 
			} 
		} 
		auxiliaryForMerge(arr,0,i/2 - 1,i/2, arr.length); 
		return arr; 
	}  


	///////////////////////////////////////////////////////
	//This is an auxiliary method to the method QuickSort 
	//that interchange the elements of array which are less than pivot selected.
	//////////////////////////////////////////////////////
	public void interchangeNumbers(int[] arr, int i, int j) {
		int temp = arr[i];
		arr[i] = arr[j];
		arr[j] = temp;
	}

	//////////////////////////////////////
	//This a is a main method of quicksort.
	///////////////////////////////////////
	public void quick(int[] arr, int first, int last) {
		int i = first;
		int j = last;

		// calculate pivot number, almost always is  pivot as middle index of array
		int pivot = arr[first+(last-first)/2];


		// Divide into two arrays
		while(i<=j) {
			while (arr[i] < pivot) {
				i++;
			}
			while (arr[j] > pivot) {
				j--;
			}
			if (i <= j) {
				interchangeNumbers(arr, i, j);
				//move index to next position on both sides
				i++;
				j--;
			}
		}

		// call quickSort method recursively
		if (first < j)
			quick(arr, first, j);
		if (i < last)
			quick(arr, i, last);
	} 


	///////////////////////////////////////////////////////
	//This is an auxiliary method to the method QuickSort  
	//who calls to recursive quick method
	//////////////////////////////////////////////////////
	public void sort(int[] arr) {
		quick(arr, 0, arr.length - 1);
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
