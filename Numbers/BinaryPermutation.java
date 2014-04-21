package Numbers;

public class BinaryPermutation {
	int A[];
	BinaryPermutation(int n){
		A = new int[n];
	}
	
	void binary (int n){
		if(n<1){
		
			for(int i =0; i<A.length; i++)
				System.out.print(A[i]);
			System.out.println();
		}
			
		else{
			A[n-1]=0;
			binary(n-1);
			A[n-1]=1;
			binary(n-1);
		}
	}
	
	public static void main(String []args){
		int n = 2;
		BinaryPermutation bit = new BinaryPermutation(n);
		bit.binary(n);
		
	}
}
