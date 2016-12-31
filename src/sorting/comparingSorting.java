package sorting;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class comparingSorting {

public static void main(String args[]){
		
		//Create the List, capacity and maxValue
		
		final int NUMBER_OF_VALUES = 500;
		final int MAX_VALUE = 200;
		
		//Initialize the List with random values 
		//comunFunctions.randomArray(NUMBER_OF_VALUES, MAX_VALUE);
				
		//Initialize the List with known values 
		comunFunctions.reversedArray(NUMBER_OF_VALUES);	
		
		//------------------------------------------
		// 1-SELECTION SORT
		//------------------------------------------
		
		System.out.println("**Selection Sort Algorithm");
		
		//Copying values to a new List to be compared
		int[] arraySelection = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerSelection = new stopWatch();
		
		//The List is sorted 
		selectionSort.sort(arraySelection);
		
		//Show elapsed time
		System.out.println("Elapsed time in Selection Sort: " + timerSelection.elapsedTime() + " nanoseconds\n");

		//------------------------------------------
		// 2-HEAPSORT
		//------------------------------------------
		
		System.out.println("**Heapsort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayHeapsort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerHeapsort = new stopWatch();
				
		//The List is sorted 
		selectionSort.sort(arrayHeapsort);
				
		//Show elapsed time
		System.out.println("Elapsed time in Heapsort: " + timerHeapsort.elapsedTime() + " nanoseconds\n");

		//------------------------------------------
		// 3-INSERTION SORT
		//------------------------------------------
		
		System.out.println("**Insertion Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayInsertion = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerInsertion = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayInsertion);
						
		//Show elapsed time
		System.out.println("Elapsed time in Insertion Sort: " + timerInsertion.elapsedTime() + " nanoseconds\n");

		//------------------------------------------
		// 4-SHELL SORT
		//------------------------------------------
		
		System.out.println("**Shell Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayShellSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerShell = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayShellSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in Shell Sort: " + timerShell.elapsedTime() + " nanoseconds\n");

		
		//------------------------------------------
		// 5-BUBBLE SORT
		//------------------------------------------
		
		System.out.println("**Bubble Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayBubbleSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerBubble = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayBubbleSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in Bubble Sort: " + timerBubble.elapsedTime() + " nanoseconds\n");

		
		//------------------------------------------
		// 6-COCKTAIL SORT
		//------------------------------------------
		
		System.out.println("**Cocktail Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayCocktailSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerCocktail = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayCocktailSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in Cocktail Sort: " + timerCocktail.elapsedTime() + " nanoseconds\n");

		
		//------------------------------------------
		// 7-COMB SORT
		//------------------------------------------
		
		System.out.println("**Comb Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayCombSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerComb = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayCombSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in comb Sort: " + timerComb.elapsedTime() + " nanoseconds\n");

		//------------------------------------------
		// 8-ODD-EVEN SORT
		//------------------------------------------
		
		System.out.println("**Odd-Even Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayOddEvenSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		
		//Count start time
		stopWatch timerOddEven = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayOddEvenSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in Odd-even Sort: " + timerOddEven.elapsedTime() + " nanoseconds\n");

		//------------------------------------------
		// 9-GNOME SORT
		//------------------------------------------
		
		System.out.println("**Gnome Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayGnomeSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
			
		//Count start time
		stopWatch timerGnome = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayGnomeSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in Gnome Sort: " + timerGnome.elapsedTime() + " nanoseconds\n");

		//------------------------------------------
		// 10-MERGE SORT
		//------------------------------------------
		
		System.out.println("**Merge Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayMergeSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerMerge = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayMergeSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in Merge Sort: " + timerMerge.elapsedTime() + " nanoseconds\n");

		
		//------------------------------------------
		// 11-MERGE BOTTOM-UP SORT
		//------------------------------------------
		
		System.out.println("**Merge Bottom-up Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayMergeBU = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerMergeBU = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayMergeBU);
						
		//Show elapsed time
		System.out.println("Elapsed time in Merge Bottom-up Sort: " + timerMergeBU.elapsedTime() + " nanoseconds\n");

		
		//------------------------------------------
		// 12-QUICKSORT
		//------------------------------------------
		
		System.out.println("**Quicksort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayQuicksort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerQuicksort = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayQuicksort);
				
		//Show elapsed time
		System.out.println("Elapsed time in Quicksort: " + timerQuicksort.elapsedTime() + " nanoseconds\n");

		//------------------------------------------
		// 13-QUICKSORT THREE WAY PARTITION
		//------------------------------------------
		
		System.out.println("**Quicksort three way partition Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayQuicksort3Way = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerQuicksort3Way = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayQuicksort3Way);
						
		//Show elapsed time
		System.out.println("Elapsed time in Quicksort three way partition: " + timerQuicksort3Way.elapsedTime() + " nanoseconds\n");
		
		//------------------------------------------
		// 14-BUCKET SORT
		//------------------------------------------
		
		System.out.println("**Bucket Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayBucketSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerBucket = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayBucketSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in Bucket Sort: " + timerBucket.elapsedTime() + " nanoseconds\n");

		//------------------------------------------
		// 15-COUNTING SORT
		//------------------------------------------
		
		System.out.println("**Counting Sort Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayCountingSort = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerCounting = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayCountingSort);
						
		//Show elapsed time
		System.out.println("Elapsed time in Counting Sort: " + timerCounting.elapsedTime() + " nanoseconds\n");
		
		//------------------------------------------
		// 16-RADIX SORT (LSD)
		//------------------------------------------
		
		System.out.println("**Radix Sort (LSD) Algorithm");
		
		//Copying values to a new List to be sorted
		int[] arrayRadixSortLSD = comunFunctions.duplicateList(comunFunctions.arrayToSort);
		
		//Count start time
		stopWatch timerRadix = new stopWatch();
						
		//The List is sorted 
		selectionSort.sort(arrayRadixSortLSD);
						
		//Show elapsed time
		System.out.println("Elapsed time in Radix Sort (LSD): " + timerRadix.elapsedTime() + " nanoseconds\n");

		//Show if the list is sorted
		boolean sort = true;
		if (!comunFunctions.isSorted(arraySelection)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayHeapsort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayInsertion)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayShellSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayBubbleSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayCocktailSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayCombSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayOddEvenSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayGnomeSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayMergeSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayMergeBU)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayQuicksort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayQuicksort3Way)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayBucketSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayCountingSort)) 
			sort = false;
		if (!comunFunctions.isSorted(arrayRadixSortLSD)) 
			sort = false;
		if(sort)	
			System.out.println("The arrays are sorted");
		else System.out.println("The arrays are not sorted");			
	}
}
