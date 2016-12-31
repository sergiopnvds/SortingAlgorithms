package sorting;
import java.io.IOException;

/**
* Quicksort three way partition algorithm
*  
* @author Sergio Penavades
* @version 1.0
*/
public class quick3WaySort {

	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   */
	public static void sort(int[] a, int lo, int hi){
		if (hi <= lo) return;
		int lt=lo, i=lo+1, gt=hi;
		int v=a[lo];
		while(i <= gt){
			if (comunFunctions.less(a[i], v)) comunFunctions.switchValues(a, lt++, i++);
			else if (comunFunctions.less(v,a[i])) comunFunctions.switchValues(a, i, gt--);
			else i++;
		}
		sort(a, lo, lt-1);
		sort(a, gt+1, hi);
	}
	
	public static void main(String args[]) throws IOException{
		
		System.out.println("Starting quicksort3Way Algorithm");
comunFunctions.addToFile("/Users/sergio_pn_21/Documents/workspace/Algorithms/results.txt","Starting Quicksort three way Algorithm\n");
		
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
		sort(comunFunctions.arrayToSort, 0, comunFunctions.arrayToSort.length -1);

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
