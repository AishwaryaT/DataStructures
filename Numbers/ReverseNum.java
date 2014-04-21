package Numbers;

public class ReverseNum {
	
	public static void main(String arg[]){
		System.out.println(reverseANumber(1548));
	}
	public static int reverseANumber(int num){
		int reverse = 0;
		int remainder = 0;
	
		while(num > 0){
			remainder = num % 10;
			reverse = reverse * 10 + remainder;
			num = num /10;
		}
		return reverse;
	}
}
