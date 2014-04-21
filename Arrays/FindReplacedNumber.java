package Arrays;
//you have an array of numbers from 0 to N-1, one of the numbers is removed, 
//and replaced with a number already in the array which makes a duplicate of that number. 
//How can we detect this duplicate in time O(N)
public class FindReplacedNumber {

	public void findReplaced(int []arr){
		int N = arr.length;
		int A = N* (N-1) /2;
		int B = N * (N-1) *(2*N -1) /6;
		int sum =0, sumsq =0;
		int numRemoved, numReplaced;
		
		for(int i =0; i < arr.length; i++){
			sum += arr[i];
			sumsq += arr[i]* arr[i]; 
		}
		
		A = A -sum;
		B = (B -sumsq)/A;
		numRemoved = (B+A)/2;
	   numReplaced = (B-A)/2;
	   System.out.println("Number removed: "+ numRemoved + " Number Replaced: " + numReplaced);
	}
	
	public static void main(String []args){
		int arr[] = {0, 1, 1, 2, 3, 5};
		FindReplacedNumber f = new FindReplacedNumber();
		f.findReplaced(arr);
	}
}
