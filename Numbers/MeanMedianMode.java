package Numbers;

import java.awt.List;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MeanMedianMode {

	public static double mean(double[] m) {
	    double sum = 0;
	    for (int i = 0; i < m.length; i++) {
	        sum += m[i];
	    }
	    return sum / m.length;
	}
	
	//Brilliant way of finding median of 3 numbers with just 2 comparisons at most
	public static int medianOfThree(int a, int b, int c){
		
		    if ( (a - b) * (c - a) >= 0 ) // a >= b and a <= c OR a <= b and a >= c
		        return a;
		    else if ( (b - a) * (c - b) >= 0 ) // b >= a and b <= c OR b <= a and b >= c
		        return b;
		    else
		        return c;
	}	
	
	// the array double[] m MUST BE SORTED
	public static double median(double[] m) {
	    int middle = m.length/2;
	    if (m.length%2 == 1) {
	        return m[middle];
	    } else {
	        return (m[middle-1] + m[middle]) / 2.0;
	    }
	}
	
	public static ArrayList<Integer> mode(final int[] numbers) {
	    final ArrayList<Integer> modes = new ArrayList<Integer>();
	    final Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();

	    int max = -1;

	    for (final int n : numbers) {
	        int count = 0;

	        if (countMap.containsKey(n)) {
	            count = countMap.get(n) + 1;
	        } else {
	            count = 1;
	        }

	        countMap.put(n, count);

	        if (count > max) {
	            max = count;
	        }
	    }

	    for (final Map.Entry<Integer, Integer> tuple : countMap.entrySet()) {
	    	System.out.println("Hii"+tuple);
	        if (tuple.getValue() == max) {
	            modes.add(tuple.getKey());
	        }
	    }

	    return modes;
	}
	
	public static void main(String []args){
		double A[] ={1,1,1,2,3,5,6,6,8,9,9,9};
		System.out.println(mean(A));
		System.out.println(median(A));
		int B[] ={1,1,1,2,3,5,6,6,8,9,9};
		System.out.println(mode(B));
		System.out.println("Median of 3 numbers: "+medianOfThree(1,1,0));
		
	}
}
