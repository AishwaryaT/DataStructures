package BitOperations;

import java.util.Scanner;

public class PackBytesToInt {

	/**
	 * @param args
	 * 
	 */
	
	public static  int[] getter(){
		Scanner s = new Scanner(System.in);
		
		System.out.println("Enter binary: ");
		int a = s.nextInt();
		int [] c = new int[10];
		
		for (int i=c.length - 1; i>=0; i--){
			int m = a %10;
			c[i]= m;
			a = a/10;	
		}
		return c;
	}
	
	
	public static long pack(int [] c)
	{
	    return ((0xFFL & c[0]) << 24) | ((0xFFL & c[1]) << 16) | ((0xFFL & c[2]) << 8) | (0xFFL & c[3]);
	}
	
	
	public static void main(String[] args) {
		
	int c[] =	PackBytesToInt.getter();
	//int c[] = {1,0,1,0};
	long ans =	PackBytesToInt.pack(c);
	System.out.println("Packed to Integer:" + ans);
	//int mask = 0xFF;
	//System.out.println(mask);
	}

}
