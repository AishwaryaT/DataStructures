package Numbers;

public class Median {
	
	
	static int partitions(int[] A, int low,int high)
	{
	    int p=low,r=high,x=A[r],i=p-1;
	    for(int j=p;j<=r-1;j++)
	    {
	        if (A[j]<=x)
	        {

	            i=i+1;
	            swap(A[i],A[j]);
	        }
	    }
	    swap(A[i+1],A[r]);
	    return i+1;
	}
	
	 static void swap(int a, int b) {
		a ^= b;
		b^=a;
		a^=b;
		
	}

	static int selection_algorithm(int A[], int left,int right,int kth)
	{
	    for(;;)
	    {
	        int pivotIndex=partitions(A, left,right);          //Select the Pivot Between Left and Right
	        int len=pivotIndex-left+1;

	        if(kth==len)
	            return A[pivotIndex];

	        else if(kth<len)
	            right=pivotIndex-1;

	        else
	        {
	            kth=kth-len;
	            left=pivotIndex+1;
	        }
	    }
	}
	
	public static void main(String []args ){
		int a[] = { 3,42,5,32};
		System.out.println(selection_algorithm(a, 1, a.length-1, (a.length-1)/2));
		
	}
}
