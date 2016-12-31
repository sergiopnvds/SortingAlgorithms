package sorting;
import java.io.IOException;

/**
* Heapsort algorithm
*  
* @author Sergio Penavades
* @version 1.0
*/
public class heapSort {

	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   */
	public static void sort(int[] a){
		int N = a.length-1;
		for (int k = N/2; k >= 1; k--) {
		sink(a, k, N);
		}
		while(N > 1){	
			comunFunctions.switchValues(a, 1, N--);
			sink(a, 1, N);
		}
	}
	
	/**
	   * This function move keys down to form the queue
	   * 
	   * @param a array to be sort 
	   * @param k iteration value in heap 
	   * @param N number of values in the array
	   * 
	   */
	private static void sink(int[] a, int k, int N){
		while (2*k <= N) {
			int j = 2*k;
			if(j<N && comunFunctions.less(a[j], a[j+1]))j++;
			if(!comunFunctions.less(a[k],a[j]))break;
			comunFunctions.switchValues(a, k, j);
			k=j;
		}
	}
	
	public static void main(String args[]) throws IOException{
		
		System.out.println("Starting heapSort Algorithm");
		comunFunctions.addToFile("/Users/sergio_pn_21/Documents/workspace/Algorithms/results.txt","Starting Heapsort Algorithm\n");
		
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
