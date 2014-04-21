package Sorting;

public class largestkelems_Bubblesort {

	
		
		int[] bubbleSort(int[] A, int k){
			boolean swapped = true;
			int temp;
			for(int i = 0; i < k && swapped; i++){
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
		largestkelems_Bubblesort b = new largestkelems_Bubblesort();
		int A[] = {2,3,1,5,3,5,9};
		int k =4;
		A = b.bubbleSort(A,k);
		int size = A.length -1; 
		for (int a= size; a> A.length - k ; a--)
			System.out.print(A[a] +" ");
		}

}


