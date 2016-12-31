package sorting;
import java.io.IOException;

/**
* Bubble sort algorithm
*  
* @author Sergio Penavades
* @version 1.0
*/
public class bubbleSort {
	
	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   */
	public static void sort(int[] a){
		int N = a.length;
		for(int i = 0; i < N; i++){
			for(int j = 1; j < N-i; j++){
				if (comunFunctions.less(a[j], a[j-1])){
					comunFunctions.switchValues(a, j-1, j);	
				}				
			}
		}
	}

	public static void main(String args[]) throws IOException{
		
		System.out.println("Bubble Short Algorithm");
		comunFunctions.addToFile(constantsForTesting.PATH,"Starting Bubble Sort Algorithm\n");
		
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
		comunFunctions.addToFile(constantsForTesting.PATH, timeText+"\n");
		comunFunctions.addToFile(constantsForTesting.PATH,"------------------------------------------------------------------------\n");
		//Show the array after to be sorted
		//comunFunctions.showAray(comunFunctions.arrayToSort);
				
		//Show if the array is sorted
		if (comunFunctions.isSorted(comunFunctions.arrayToSort))
			System.out.println("The array is sorted");
		else System.out.println("The array is not sorted");	
	}	

}
