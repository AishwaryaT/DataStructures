package Sorting;

public class SelectionSort {
	
	int[] selectionSort(int[] A){
		int min, temp;
		for(int i = 0; i<A.length; i++){
			min = i;
			for(int j =i+1; j< A.length; j++){
				if(A[j] < A[min]){
					min = j;
				}
			}
			temp = A[i];
			A[i] = A[min];
			A[min] = temp;
		}
		
		return A;
	}
	

	public static void main(String[] args) {
		SelectionSort s = new SelectionSort();
		//int A[] = {1,23,43,2,25,53,33,02,45};
		int A[] = {2,3,1};
		A = s.selectionSort(A);
		for (int a : A)
			System.out.print(a +" ");
		}

}
