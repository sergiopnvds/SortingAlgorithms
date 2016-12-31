package sorting;

public class stopWatch {

	private final long start;

    /**
     * Constructor
     * 
     * Initializes a new stopWatch.
     */
    public stopWatch() {
        //start = System.currentTimeMillis();
    	start = System.nanoTime();
    } 

    /**
     * Returns the elapsed CPU time (in seconds) since the stopwatch was created.
     *
     * @return elapsed CPU time (in seconds) since the stopwatch was created
     */
    public double elapsedTime() {
        //long now = System.currentTimeMillis();
    	long now = System.nanoTime();
        return (now - start) / 1000.0; 
    }
}
