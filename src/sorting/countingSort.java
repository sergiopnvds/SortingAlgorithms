package sorting;
import java.io.IOException;

/**
* Counting sort algorithm
*  
* @author Sergio Penavades
* @version 1.0
*/
public class countingSort {
	
	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   */
	public static void sort(int[] a) {
        if (a.length == 0) {
            return;
        }
        // Determine minimum and maximum values
        Integer minValue = a[0];
        Integer maxValue = a[0];
        for (int i = 1; i < a.length; i++) {
            if (comunFunctions.less(a[i], minValue)) {
                minValue = a[i];
            } 
            else if (comunFunctions.less(maxValue, a[i])) {
                maxValue = a[i];
            }
        }
        sort(a, minValue, maxValue);
    }

	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   * @param minValue bottom bucket value 
	   * @param maxValue top bucket value 
	   */
    public static void sort(int[] a, int minValue, int maxValue) {
        int[] buckets = new int[maxValue - minValue + 1];
        for (int i = 0; i < a.length; i++) {
            buckets[a[i] - minValue]++;
        }
        int sortedIndex = 0;
        for (int i = 0; i < buckets.length; i++) {
            while (comunFunctions.less(0, buckets[i])) {
                a[sortedIndex++] = i + minValue;
                buckets[i]--;
            }
        }
    }
    
	public static void main(String args[]) throws IOException{
		
		System.out.println("Starting Counting Short Algorithm");
		comunFunctions.addToFile("/Users/sergio_pn_21/Documents/workspace/Algorithms/results.txt","Starting Counting Sort Algorithm\n");
		
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
