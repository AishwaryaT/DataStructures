package Sorting;

public class CountingSort {
// if there are 10 elements less than X, then X comes in 11 th position
	
	public static void main(String[] args) {
		
		int A[] = {5,4,4,5,1,2,5,2,0,8,7,6,2,1};
		//0 1 1 2 2 2 4 4 5 5 5 6 7 8 
		int B[] = countSort(A,10);
		for (int i : B)
			System.out.print(i + " ");
		
	}

	private static int[] countSort(int[] a, int K) {
		int b[] = new int[a.length];
		int c[] = new int[K];
		for (int i : c)
			c[i] = 0;
		for(int j = 0; j < a.length -1 ; j++){
			c[a[j]] += 1;
		}
		//c[i] contains the number of times i is repeated in the given list
		
		for(int i = 1; i < K; i++)
			c[i] += c[i-1];
		//c[i] contains the number of elements <= i
		
		for(int i = a.length -1; i >= 0  ; i--){
			b[c[a[i]]] = a[i]; 
			c[a[i]] -= 1;
		}
		return b;
		
	}

}
