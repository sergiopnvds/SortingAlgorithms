package sorting;
import java.io.IOException;

/**
* Radix sort (LSD) sort algorithm
*  
* @author Sergio Penavades
* @version 1.0
*/
public class radixSortLSD {
	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   */
	public static void sort(int[] a) {
        sort(a, 10);
    }

	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort
	   * @param radix to use in sort 
	   */
    public static void sort(int[] a, int radix) {
        if (a.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        int minValue = a[0];
        int maxValue = a[0];
        for (int i = 1; i < a.length; i++) {
            if (comunFunctions.less(a[i], minValue)) {
                minValue = a[i];
            } else if (comunFunctions.less(maxValue, a[i])) {
                maxValue = a[i];
            }
        }
        // Perform counting sort on each exponent/digit, starting at the least
        // significant digit
        int exponent = 1;
        while ((maxValue - minValue) / exponent >= 1) {
            countingSortByDigit(a, radix, exponent, minValue);
            exponent *= radix;
        }
    }

    /**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort
	   * @param radix to use in sort 
	   * @param exponent to use in sort 
	   * @param minValue to use in sort 
	   */
    private static void countingSortByDigit(int[] a, int radix, int exponent, int minValue) {
        int bucketIndex;
        int[] buckets = new int[radix];
        int[] output = new int[a.length];
        // Initialize bucket
        for (int i = 0; i < radix; i++) {
            buckets[i] = 0;
        }
        // Count frequencies
        for (int i = 0; i < a.length; i++) {
            bucketIndex = (int)(((a[i] - minValue) / exponent) % radix);
            buckets[bucketIndex]++;
        }

        // Compute cumulates
        for (int i = 1; i < radix; i++) {
            buckets[i] += buckets[i - 1];
        }

        // Move records
        for (int i = a.length - 1; i >= 0; i--) {
            bucketIndex = (int)(((a[i] - minValue) / exponent) % radix);
            output[--buckets[bucketIndex]] = a[i];
            comunFunctions.delay();
        }

        // Copy back
        for (int i = 0; i < a.length; i++) {
            a[i] = output[i];
            comunFunctions.delay();
        }
    }
    
	public static void main(String args[]) throws IOException{
		
		System.out.println("Starting Radix sort (LSD) Short Algorithm");
		comunFunctions.addToFile("/Users/sergio_pn_21/Documents/workspace/Algorithms/results.txt","Starting Radix Sort (LSD) Algorithm\n");
		
		//Create capacity and maxValue
		int numberOfValues = constantsForTesting.NUMBER_OF_VALUES;
		int maxValue = constantsForTesting.MAX_VALUE;

		switch (constantsForTesting.TYPE_OF_ARRAY ){
		case "SORTED":
			//Initialize the array with sorted values 
			comunFunctions.sortedArray(numberOfValues);
			comunFunctions.addToFile(constantsForTesting.PATH,"Sorted array of "+numberOfValues+" keys\n");

		case "RANDOM":
			//Initialize the array with random values 
			comunFunctions.randomArray(numberOfValues ,maxValue);
			comunFunctions.addToFile(constantsForTesting.PATH,"Random array of "+numberOfValues+" keys and max. value of "+maxValue+"\n");						
			break;

		case "NEARLY_SORTED":
			//Initialize the array with random values 
			comunFunctions.nearlySortedArray(numberOfValues);
			comunFunctions.addToFile(constantsForTesting.PATH,"Nearly sorted array of "+numberOfValues+" keys\n");						
			break;

		case "REVERSED":
			//Initialize the array with a known reversed array 
			comunFunctions.reversedArray(numberOfValues);	
			comunFunctions.addToFile(constantsForTesting.PATH ,"Reversed array of "+numberOfValues+" keys\n");
			break;

		case "FEW_UNIQUE":
			//Initialize the array with a few unique array 
			comunFunctions.fewUniqueArray(numberOfValues, maxValue);
			comunFunctions.addToFile(constantsForTesting.PATH ,"Few unique array of "+numberOfValues+" keys and max. value of "+maxValue+"\n");
			break;
		}

		//Show the array before to be sorted
		//comunFunctions.showAray(comunFunctions.arrayToSort);

		//Count start time
		stopWatch timer = new stopWatch();

		//The array is sorted 
		sort(comunFunctions.arrayToSort);

		//Show elapsed time
		String timeText = "Elapsed time: " + timer.elapsedTime() + " nanoseconds";
		System.out.println(timeText);
		comunFunctions.addToFile(constantsForTesting.PATH,timeText+"\n");
		comunFunctions.addToFile(constantsForTesting.PATH,"------------------------------------------------------------------------\n");//Show the array after to be sorted
		//Show the array after to be sorted
		//comunFunctions.showAray(comunFunctions.arrayToSort);

		//Show if the array is sorted
		if (comunFunctions.isSorted(comunFunctions.arrayToSort))
			System.out.println("The array is sorted");
		else System.out.println("The array is not sorted");	
	}	

}