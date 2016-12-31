package sorting;
import java.io.IOException;

/**
* Comb sort algorithm
*  
* @author Sergio Penavades
* @version 1.0
*/
public class oddEvenSort {
	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   */
	public static void sort(int[] a){
		boolean sorted = false;
        while (!sorted) {
            sorted = innerSort(a, 1);
            sorted = innerSort(a, 0) && sorted;
        }
	}
	
	/**
	   * This function sort the odd or even
	   * 
	   * @param a array to be sort 
	   * @param i index to be sort 
	   */
	private static boolean innerSort(int[] a, int i) {
		boolean sorted = true;
        for (; i < a.length - 1; i += 2)
        {
            if (comunFunctions.less(a[i+1],a[i]))
            {
                comunFunctions.switchValues(a, i, i + 1);
                sorted = false;
            }
        }
        return sorted;
	}



	public static void main(String args[]) throws IOException{
		
		System.out.println("Starting Odd-even Short Algorithm");
		comunFunctions.addToFile("/Users/sergio_pn_21/Documents/workspace/Algorithms/results.txt","Starting Odd-even Sort Algorithm\n");
		
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
