package BitOperations;

public class AddBits {

	public static void main(String []args){
		String s1 = "00101001" , s2 = "10";
		int len1 = s1.length();
		int len2 = s2.length();
		
		//make the 2 strings equal in length
		if(len1 < len2){
			int diff = len2-len1;
			for(int i =0; i<diff; i++)
			{
				s1 = '0' + s1;
			}
		}

		else{
	
			int diff = len1-len2;
			for(int i =0; i<diff; i++)
			{
				s2 = '0' + s2;
			}
		}
		
		System.out.println("s1 "+s1+"   s2 "+s2);
		//sum = a ^ b^ carry;
		//carry = a&b | b&carry | a&carry 
		int sum =0; 
		int carry=0;
		String result ="";
		//System.out.println(result + (char)0);
		for (int i =s1.length()-1; i >= 0; i--){
			sum = s1.charAt(i)^s2.charAt(i)^carry;
			if( sum == 1)
				result = '1' + result;
			else
				result = '0' + result;
			//System.out.println(result);
			carry = s1.charAt(i)&s2.charAt(i) | s1.charAt(i)&carry | s1.charAt(i)&carry;
			System.out.println(carry);
		}
		
		if(carry == 1)
			result = '1' + result;
		System.out.println(result.toString());
	}
}
