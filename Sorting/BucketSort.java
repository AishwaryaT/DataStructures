package Sorting;

public class BucketSort {

	static int[] bucketsort(int []A, int K){
		int bucket[] = new int[K];
		
		for(int i = 0 ; i < K; i++){
			bucket[i] = 0;
		}
		
		for(int i = 0 ; i < A.length; i++){
			bucket[A[i]] += 1;
		}
		// bucket[i] keeps track of count of ith element
		
		for(int i =0, j =0; j< K; j++)
			for(int k = bucket[j]; k >0; --k)
				A[i++] = j;
		
		return A;
		
	}
	
	public static void main(String []args){
		
		int [] arr = {2,3,5,5,6,6,3,4,7,3,2,5,1,1,9,4,3};
		int A[] = bucketsort(arr,10);
		for(int i : A)
			System.out.print(i+ " ");
		
	}
}
