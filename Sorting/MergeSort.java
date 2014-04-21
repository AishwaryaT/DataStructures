package Sorting;

import java.util.Arrays;

public class MergeSort {

	public static void main(String[] args) {
		int A[] = {1,23,43,2,25,53,33,02,45};
		MergeSort M = new MergeSort();
		M.split(A);
		for (int a: A)
			System.out.print(a +" ");
	}

	public void split(int[] a) {
		if (a.length <= 1)
			return;
		else{
				int left[] = Arrays.copyOfRange(a, 0, a.length/2);
				int right[] = Arrays.copyOfRange(a, a.length/2, a.length);
				split(left);
				split(right);
				mergeSort(a,left,right);
			}
			
	}

	private void mergeSort(int[] a, int[] left, int[] right) {
		int totLen = left.length + right.length;
		int i,li,ri;
		i = li = ri = 0;
		
		while ( i < totLen){
			if((li < left.length) && (ri < right.length)){
				if(left[li] < right[ri]){
					//System.out.println("Inside left < right :"+ri+" "+ li);
					a[i]= left[li];
					i++;
					li++;
				}
			
				else {
					//System.out.println(ri+" "+ li);
					a[i] = right[ri];
					i++;
					ri++;
				}
			} 
			
			else {
		
				if( li >= left.length){
					while(ri < right.length){
						a[i] = right[ri];
						i++;
						ri++;
					}
				}
		
				if (ri >= right.length){
					while(li < left.length){
						a[i] = left[li];
						i++;
						li++;
					}
				}
			}
		}
	}
}
