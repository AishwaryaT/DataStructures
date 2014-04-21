package BitOperations;

public class TestBits {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		int a= Bits.countSetBits3(14);
		System.out.println(a);
		
		System.out.println("Check if n is power of 2: ");
		Bits.isPowerofTwo(7);
		Bits.isPowerofTwo(16);
		
		System.out.println();
		System.out.println();	
		
		int n = Bits.fillBitsRight(8);
		System.out.println(n);
	}

}
