package Numbers;

//given a range of 0 to k numbers and number of bits n: 
//generate all permutations of n bit number with its digit value ranging from 0 to k

public class K_aryPermutation {
	int A[];
	K_aryPermutation(int n){
		A = new int[n];
	}
	
	void k_ary (int n, int k){
		if(n<1){
		
			for(int i =0; i<A.length; i++)
				System.out.print(A[i]);
			System.out.println();
		}
			
		else{
			for(int j=0; j<k; j++){
				A[n-1] = j;
				k_ary(n-1,k);
			}
		}
	}
	
	public static void main(String []args){
		int n = 2;
		K_aryPermutation bit = new K_aryPermutation(n);
		bit.k_ary(n,3);
		
	}
}	