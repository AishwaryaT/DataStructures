package Sorting;

public class BubbleSort {
	
	
	int[] bubbleSort(int[] A){
		boolean swapped = true;
		int temp;
		for(int i = 0; i < A.length && swapped; i++){
			swapped = false;
			for(int j=0; j< A.length - 1; j++){ //largest element will sink to the bottom at each round
												//meaning that smallest element slowly bubbles up.
				if(A[j] > A[j+1]){
					temp = A[j];   // swap A[j] and A[j+1]
					A[j] = A[j+1];
					A[j+1]=temp;
					swapped = true;
				}
			}
		}
		return A;
	}
	
	public static void main(String[] args) {
	BubbleSort b = new BubbleSort();
	int A[] = {2,3,1};
	A = b.bubbleSort(A);
	for (int a : A)
		System.out.print(a +" ");
	}

}
