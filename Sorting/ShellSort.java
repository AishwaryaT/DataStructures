package Sorting;

public class ShellSort
 {
	private int a[];
    public ShellSort(int[] anArray)
    {
       a = anArray;
    }
      
    public void sort()
    {
      int increment = a.length / 3 + 1;
 
       // Sort by insertion sort at diminishing increments.
       while(increment > 1) 
       {
          for ( int start = 0; start < increment; start++ )
        	 // if( increment > 1 )
        		  insertSort1( start, increment );
        	  
        		  increment = increment / 3 + 1; 
        
       } 
 
       // Do a final pass with an increment of 1.
   
       insertSort1( 0, 1 );
    }
       
    /**
       Insertion sort modified to sort elements at a
       fixed increment apart.
 
 
       @param start      the start position 
       @param increment  the increment
    */
    
    public void insertSort1( int start, int increment )
    {
       int i, j, k, temp;
 
       for ( i = start + increment; i < a.length; i += increment )
       {
          j = i;
         
          temp = a[j];
        while ( j - increment >= start && a[j - increment] > temp ) {
                a[j] = a[j - increment];
                j = j - increment;
           } 
          a[j] = temp;
       }
    } 
    public static void main(String[] args) {
    	int A[] = {1111,23,43,2,25,53,33,02,45,87,45,56,34,7,634,56,3434,34,55,453,232,1245,467,23,5645,32232,332324,76,3,33335,1,0};
    	ShellSort s = new ShellSort(A);
		
    	s.sort();
		for (int a : A)
			System.out.print(a +" ");
	}

}