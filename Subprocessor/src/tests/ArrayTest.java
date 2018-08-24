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
		
		int[] inputArray = myArray.getInArrayI();
		//When the input is smaller than 10000, the algorithm choose RadixSort (Method that we're actually testing)
		int[] outArray = myArray.mergeForInts(inputArray);
		
		for (int i = 0; i < outArray.length; i++) {
			
			if(i+1 < outArray.length)
			assertTrue(outArray[i] < outArray[i+1]);
		}
	}
}
