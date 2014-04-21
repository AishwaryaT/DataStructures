package Arrays;

import Sorting.CountingSort;

public class CountDuplicates {
	
	//If you are given array of size n.
	//It has integers from 1 to K where K < n. Find the duplicates 
	//and no of times repeated in o(1) space and o(n) time
	

		
		public static void main(String[] args) {
			CountDuplicates C = new CountDuplicates();
			int A[] = {5,4,4,5,1,2,5,2,8,7,6,2,1};
			C.countSort(A,10);
			
		}

		private void countSort(int[] a, int K) {
			int b[] = new int[K];
			for (int i : b)
				b[i] = 0;
			for(int j = 0; j < a.length; j++){
				b[a[j]] += 1;
			}
			
			//print the sorted list
			/*for(int k = 0; k < 10; k++){
				while (b[k] > 0){
					System.out.println(k);
					b[k] -= 1;
					//b[k] = 0;
				}
			}*/
			
			//print the duplicates and the # times it is repeated
					for(int k = 0; k < 10; k++){
						while (b[k] > 1){
							System.out.println(k +" is repeated "+b[k]+" times");
							//b[k] -= 1;
							 b[k] = 0;
						}
					}
			
		}

	}

