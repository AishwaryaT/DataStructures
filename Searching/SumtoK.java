package Searching;
import Sorting.MergeSort;
public class SumtoK {

	public boolean findABC(int K, int[] a){
		int i, j ,k;
		int n = a.length;
		
		for(k = 0; k < n; k++ ){
			for(i= k+1, j = n -1; i < j;){
				if(a[k]+a[i]+a[j] == K){
					System.out.println(a[k]+"+ " +a[i] +"+ "+a[j]);
					return true;
				}
				else if(a[k]+a[i]+a[j] < K)
					i++;
				else
					j--;
			}
			
			
		}
		
		return false;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		SumtoK s = new SumtoK();
		int[] A ={2,4,6,3,4,10};
		
		MergeSort m = new MergeSort();
		m.split(A);
		
		
		boolean yes_no = s.findABC(20, A);
		System.out.println(yes_no);
		
	}

}
