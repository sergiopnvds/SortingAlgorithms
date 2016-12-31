package sorting;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
* Bucket sort algorithm
*  
* @author Sergio Penavades
* @version 1.0
*/
public class bucketSort{
	
	private static final int DEFAULT_BUCKET_SIZE = 5;
	/**
	   * This function sort the array provided
	   * 
	   * @param a array to be sort 
	   */
	public static void sort(int[] a){
		  sort(a, DEFAULT_BUCKET_SIZE);
	}
	
	
	public static void sort(int[] a, int bucketSize) {
        if (a.length == 0) {
            return;
        }

        // Determine minimum and maximum values
        Integer minValue = a[0];
        Integer maxValue = a[0];
        for (int i = 1; i < a.length; i++) {
            if (comunFunctions.less(a[i], minValue)) {
                minValue = a[i];
            } else if (comunFunctions.less(maxValue, a[i])) {
                maxValue = a[i];
            }
        }
      
        // Initialise buckets
        int bucketCount = (maxValue - minValue) / bucketSize + 1;
        List<int[]> buckets = new ArrayList<int[]>(bucketCount);
        for (int i = 0; i < bucketCount; i++) {
            buckets.add(new int[bucketSize]);
        }
        
        // Distribute input array values into buckets
        
        	for (int i = 0; i < a.length; i++) {
            	for (int j = 0; j < a.length; j++) {
            		if (buckets.get((a[i] - minValue) / bucketSize)[j] == 0){
            			buckets.get((a[i] - minValue) / bucketSize)[j] = a[i];
            			break;
            		}
    			}       				
            }
        // Sort buckets and place back into input array
        int currentIndex = 0;
        for (int i = 0; i < buckets.size(); i++) {
            int[] bucketArray = new int[buckets.get(i).length];
            for (int k = 0; k < bucketArray.length; k++) {
				bucketArray[k] = buckets.get(i)[k]; 				
			}
            Sort(bucketArray);
            for (int k = 0; k < bucketArray.length; k++) {
            	if (bucketArray[k] != 0){
               a[currentIndex++] = bucketArray[k];
               }
            }
        }
    }
	
	public static void Sort(int[] a){
	    int N = a.length;
		for(int i=1; i<N; i++){
			for(int j=i; j>0 && comunFunctions.less(a[j], a[j-1]); j--)	
				comunFunctions.switchValues(a, j, j-1);	
		}
    }
	
	public static void main(String args[]) throws IOException{
		
		System.out.println("Starting Bucket Short Algorithm");
		comunFunctions.addToFile("/Users/sergio_pn_21/Documents/workspace/Algorithms/results.txt","Starting Bucket Sort Algorithm\n");
		
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
		comunFunctions.addToFile(constantsForTesting.PATH,"------------------------------------------------------------------------\n");//Show the array after to be sorted
		//comunFunctions.showAray(comunFunctions.arrayToSort);
				
		//Show if the array is sorted
		if (comunFunctions.isSorted(comunFunctions.arrayToSort))
			System.out.println("The array is sorted");
		else System.out.println("The array is not sorted");	
	}	

}

