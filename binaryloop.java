
public class binaryloop {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		for(int b = Integer.parseInt("1010", 2); b<= Integer.parseInt("1111", 2);b++)
			System.out.println(b);
		
		int z =5;
		System.out.println(Integer.bitCount(z));
	}

}
