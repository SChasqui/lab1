package tests;

import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.Test;

import model.Array;

public class ArrayTest {
	
	private Array myArray;
	
	void setupEstage1() {
		myArray = new Array();
		
	}
	
	//Test for Integers sorted by Radix algorithm with a regular input
	@Test
	void testRegularIntRadix() {
		
		//Testing RadixSort for small inputs
		setupEstage1();
		myArray.randomWithoutRepetitionOI(1, 100, 90);
		myArray.randomizeOrderI();
		
		int[] inputArray = myArray.getInArrayI();
		//When the input is smaller than 10000, the algorithm choose RadixSort (Method that we're actually testing)
		myArray.radixsort(inputArray, inputArray.length);
		
		for (int i = 0; i < inputArray.length; i++) {
			
			if(i+1 < inputArray.length)
			assertTrue(inputArray[i] < inputArray[i+1]);
		}
		

	}
	
	//Test for Integers sorted by Radix algorithm  with an input wich is in the limit
	@Test
	void testIntRadixInLimit() {
		
		setupEstage1();
		//Testing RadixSort for our limit (10x10^-4)
		setupEstage1();
		myArray.randomWithoutRepetitionOI(1, 800000, 9999);
		myArray.randomizeOrderI();
		
		int[] inputArray = myArray.getInArrayI();
		//When the input is smaller than 10000, the algorithm choose RadixSort (Method that we're actually testing)
		myArray.radixsort(inputArray, inputArray.length);
		
		for (int i = 0; i < inputArray.length; i++) {
			
			if(i+1 < inputArray.length)
			assertTrue(inputArray[i] < inputArray[i+1]);
		}
	}
	
	//Test for Integers sorted by Merge algorithm  with an input wich is in the limit of java
	@Test
	void testRegularIntMerge() {
		
		//Testing RadixSort for small inputs
		setupEstage1();
		myArray.randomWithoutRepetitionOI(1, 1000000000, 90000000);
		myArray.randomizeOrderI();
		long timeStart, timeFinish, total;
		timeStart = System.currentTimeMillis();
		int[] inputArray = myArray.getInArrayI();
		//When the input is smaller than 10000, the algorithm choose RadixSort (Method that we're actually testing)
		int[] outArray = myArray.mergeForInts(inputArray);
		
    	timeFinish = System.currentTimeMillis(); 
    	total = timeFinish - timeStart;
//    	System.out.println("Aprecien el poder de la estabilidad del Merge: " + total);
		
		for (int i = 0; i < outArray.length; i++) {
			
			if(i+1 < outArray.length)
			assertTrue(outArray[i] < outArray[i+1]);
		}
	}
	
	//Test for Integers sorted by Merge algorithm  with an input wich is in the limit of java
	@Test
	void testLimitIntMerge() {
		
		//Testing RadixSort for small inputs
		setupEstage1();
		myArray.randomWithoutRepetitionOI(1, 1000000000, 90000000);
		myArray.randomizeOrderI();
		
		int[] inputArray = myArray.getInArrayI();
		//When the input is smaller than 10000, the algorithm choose RadixSort (Method that we're actually testing)
		long timeStart, timeFinish, total;
		timeStart = System.currentTimeMillis();
		int[] outArray = myArray.mergeForInts(inputArray);
		
    	timeFinish = System.currentTimeMillis(); 
    	total = timeFinish - timeStart;
//    	System.out.println("Aprecien el poder de la estabilidad del Merge: " + total);
		
		for (int i = 0; i < outArray.length; i++) {
			
			if(i+1 < outArray.length)
			assertTrue(outArray[i] < outArray[i+1]);
		}
	}
	
	@Test
	void testLimitIntQuick() {
		
		//Testing RadixSort for small inputs
		setupEstage1();
		myArray.randomWithoutRepetitionOI(1, 50000, 90000);
		myArray.randomizeOrderI();
		
		int[] inputArray = myArray.getInArrayI();
		long timeStart, timeFinish, total;
		timeStart = System.currentTimeMillis();
		//When the input is smaller than 10000, is positive and the percentage of disroder is less than 50%, the algorithm will choose 
		//The sort that we are testing
		myArray.chooseAlgorithm(inputArray);
		
		
    	timeFinish = System.currentTimeMillis(); 
    	total = timeFinish - timeStart;
//    	System.out.println("Aprecien el poder de la estabilidad del Merge: " + total);
		
		for (int i = 0; i < myArray.getOutArrayI().length; i++) {
			
			if(i+1 < myArray.getOutArrayI().length)
			assertTrue(myArray.getOutArrayI()[i] < myArray.getOutArrayI()[i+1]);
			
		}
	}
}
