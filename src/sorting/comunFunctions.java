package sorting;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

/**
* Algorithms methods
* 
* <P>Various methods to use in the development, analysis and comparison of algorithms.
*  
* @author Sergio Penavades
* @version 1.0
*/
public class comunFunctions {
	
	/** Array subject to be sorted */
	public static int[] arrayToSort;

	/**
	   * This function compares two values to know what is less
	   * 
	   * @param valueA  
	   * @param valueB
	   * @return 
	   */
	public static boolean less(int valueA, int valueB){
		if (valueA < valueB)
			return 	true;
		else return false;
	}
	
	/**
	   * This function switches the values in positions 1 and 2 inside the array a
	   * 
	   * @param a array that contains the values
	   * @param position1 position of value 1
	   * @param position2 position of value 2
	   */
	public static void switchValues(int[] a, int position1, int position2){
		int temp = a[position1];	
		a[position1]= a[position2];
		a[position2]= temp;
	}
	
	/**
	   * This function prints the values of the array a
	   * 
	   * @param a array that contains the values
	   */
	public static void showAray(int[] a){
		for(int i=0; i<a.length; i++){
			System.out.print(a[i] + ", ");
		}
		System.out.println();
	}
	
	/**
	   * This function prints the values of the array a
	   * 
	   * @param a array that contains the values
	   * @return true if the array is sorted, false on the contrary 
	   */
	public static boolean isSorted(int[] a){
		for (int i=1; i<a.length; i++)
			if(less(a[i], a[i-1])) return false;
		return true;
	}
	
	/**
	   * This function generates a sorted array of N positions 
	   * 
	   * @param N length of the random array
	   */
	public static void sortedArray(int N){
		arrayToSort = new int[N];
		for(int i=0; i<N; i++){
			arrayToSort[i] = i;
		}
	}
	
	/**
	   * This function generates a random array of N positions 
	   * 
	   * @param N length of the random array
	   * @param maxValue maximum value of one value
	   */
	public static void randomArray(int N, int maxValue){
		arrayToSort = new int[N];
		for(int i=0; i<N; i++){
			arrayToSort[i] = (int) (Math.random()*maxValue);
		}
	}
	
	/**
	   * This function generates a known reverse array of N positions sorted from maximum to minimum
	   * 
	   * @param N length of the random array
	   */
	public static void reversedArray(int N){
		arrayToSort = new int[N];
		for(int i=0; i<N; i++){
			arrayToSort[i] = N-i;
		}
	}
	
	/**
	   * This function generates a nearly sorted array of N positions sorted from maximum to minimum
	   * 
	   * @param N length of the random array
	   */
	public static void nearlySortedArray(int N){
		arrayToSort = new int[N];
		int shuffleSize = (int) Math.sqrt(N);
		Random rnd = new Random();
		for(int i=0; i<N; i++){
			arrayToSort[i] = i;
		}
        for (int i = 0; i < N; i += shuffleSize){
            if (i + shuffleSize > N){
                shuffleSize = N - i;
                if (shuffleSize <= 1) 
                    continue;
            }
            if (i % shuffleSize == 0){
                for (int j = i; j < i + shuffleSize; j++){
                    // Pick random element to swap from our small section of the array
                    int k = rnd.nextInt(shuffleSize)+i;
                    // Swap
                    int tmp = arrayToSort[k];
                    arrayToSort[k] = arrayToSort[j];
                    arrayToSort[j] = tmp;
                }
            }
        }
	}
	
	/**
	   * This function generates a few unique array of N positions sorted from maximum to minimum
	   * 
	   * @param N length of the random array
	   * @param maxValue maximum value of one value
	   */
	public static void fewUniqueArray(int N, int maxValue){
		Random rnd = new Random();
		arrayToSort = new int[N];
		int nSections = (int) Math.sqrt(N);
		int[] sections = new int[nSections];
		for(int i=0; i<nSections; i++){
			sections[i] = (int) (Math.random()*maxValue);	
		}
		for (int i = 0; i < N; i++) {
			arrayToSort[i]=sections[(int)(rnd.nextDouble() * nSections)];
		}
		
	}
	
	/**
	   * This function returns a copy of the List chosen
	   * 
	   * @param a array to be copied
	   * @return array copied
	   */
	public static int[] duplicateList(int[] a){
		int N = a.length;
		int[] temp = new int[N];
		for (int i = 0; i < a.length; i++) {
			temp[i]= a[i];
		}
		return temp;
	}
	
	/**
	   * This function returns a copy of the List chosen
	   * 
	   * @param delay time to be delayed
	   */
	public static void delay(){
		try {

			//sleep 5 seconds
			Thread.sleep(0);


		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	/**
	   * This function writes in the file passed the String chosen
	   * 
	   * @param path file path where the data has to be written
	   * @param sentence text to add to the file
	   * 
	   * @throws IOException 
	   */
	public static void addToFile(String path, String text) throws IOException{
		File file = new File(path);
		BufferedWriter bw;
		if(file.exists()) {
			bw = new BufferedWriter(new FileWriter(file,true));
            bw.write(text);
		    bw.newLine();
		} else {
			bw = new BufferedWriter(new FileWriter(file));
			bw.write("##############################################\n");
		    bw.write("  SORTING ALGORITHMS RESULTS FILE\n");
			bw.write("##############################################\n\n");
		    bw.write(text);
		}
		bw.close();
	}
	
	public static void main(String args[]) throws IOException{
		nearlySortedArray(20);
		showAray(arrayToSort);
	}
	
}
