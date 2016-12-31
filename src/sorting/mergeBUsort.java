package sorting;
import java.io.IOException;

/**
* Merge Bottom-up sort algorithm
*  
* @author Sergio Penavades
* @version 1.0
*/
public class mergeBUsort {
	
	private static int[] aux;
	
	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   */
	private static void sort(int[] a){
		int N = a.length;
		aux = new int[N];
		for (int sz = 1; sz < N; sz = sz+sz) 
			for (int lo = 0; lo < N-sz; lo+= sz+sz)
				merge(a, lo, lo+sz-1, Math.min(lo+sz+sz-1, N-1));
	}
	
	/**
	   * This function move keys inside the array
	   * 
	   * @param a array to be sort 
	   * @param lo bottom position of the array 
	   * @param mid middle position of the array 
	   * @param hi top position of the array 
	   * 
	   */
	private static void merge(int[] a, int lo, int mid, int hi){
		
		int i = lo;
		int j = mid+1;
		for(int k = lo; k<hi; k++) aux[k] = a[k];
		for(int k = lo; k<hi; k++){
			if(comunFunctions.less(mid,i)) a[k]= aux[j++];
			else if(comunFunctions.less(hi,j)) a[k]= aux[i++];
			else if(comunFunctions.less(aux[j], aux[i])) a[k]= aux[j++];
			else a[k]= aux[i++];
		}
	}
	
public static void main(String args[]) throws IOException{
		
		System.out.println("Starting mergeshort Algorithm");
		comunFunctions.addToFile("/Users/sergio_pn_21/Documents/workspace/Algorithms/results.txt","Starting Merge Bottom-up Sort Algorithm\n");
		
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


