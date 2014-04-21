package Sorting;

public class InsertionSort {
	
	int[] insertionSort(int[] A){
		int cache;
		for(int i=0+1; i<A.length; i=i+1){
			int j = i; 
			cache = A[j];
			while(j-1 >=0 && A[j-1]>cache){
				A[j]=A[j-1];
				j--;
			}
			A[j] = cache;
		}
		
		return A;
	}

	
	
	public static void main(String[] args) {
		InsertionSort i = new InsertionSort();
		int A[] = {111,23,43,2,25,53,33,02,45};
		A = i.insertionSort(A);
		for (int a : A)
			System.out.print(a +" ");
	}

}
