package Strings;
import java.util.Arrays;


public class RevStr {

	
	public static void main(String[] args) {
		RevStr t1 = new RevStr();
		//System.out.println(t1.reverse("Aishu"));
		t1.reverseStrBuf("muruga");
		t1. reverseStrBuf2("aishwarya");
		System.out.println(t1. ReverseBitwise("aishwarya"));
		System.out.println(t1. reverseRecurion("arunkumar"));
		System.out.println("Hii "+"aishwarya".substring(2, 5));
		System.out.println(RotateStr("Sathya",4));
		
	}

	// normal method using char array and temp variable
	public static String reverse(String str){
		char [] chararr = str.toCharArray();
		int length = str.length();
		int last = length - 1;
		for(int i = 0; i < length/2 ; i++){
			char c = chararr[i];
			chararr[i] = chararr[last - i];
			chararr[last - i] = c ;
		}
		return new String(chararr);
	//return chararr.toString();
	}
	
	//---------------------------------------------------------------------------------------------------------------------------------	
	
	public static String RotateStr( String str, int k){
		if (str == null || str.length() <= 1)
			return str;
		for(int i = 0; i < k; i++)
			str = str.substring(1)+str.charAt(0);
		return str;
	}
	
//---------------------------------------------------------------------------------------------------------------------------------	
	public String ReverseBitwise(String str)
	{
	    // convert the string to char array
	    char[] charArray = str.toCharArray();
	    int len = str.length() - 1;
	    /*
	    now this for is a bit unconventional at first glance because there
	    are 2 variables that we're changing values of: i++ and len--.
	    the order of them is irrelevant. so basicaly we're going with i from 
	    start to end of the array. with len we're shortening the array by one
	    each time. this is probably understandable.
	    */
	    for (int i = 0; i < len; i++, len--)
	    {
	        /*
	        now this is the tricky part people that should know about it don't.
	        look at the table below to see what's going on exactly here.
	        */
	        charArray[i] ^= charArray[len];
	        charArray[len] ^= charArray[i];
	        charArray[i] ^= charArray[len];
	    }
	    return new String(charArray);
	}
//---------------------------------------------------------------------------------------------------------------------------------	
	public String reverseStrBuf(String s){
		int len = s.length();
		StringBuffer sb = new StringBuffer(len);
		for (int i = len - 1; i >= 0; i-- ){
			sb.append(s.charAt(i));
		}
		//System.out.println(sb.toString());
		s = sb.toString();
		return s;
	}

//---------------------------------------------------------------------------------------------------------------------------------
	public void reverseStrBuf2(String s){
		String sb = new StringBuffer(s).reverse().toString();
		System.out.println(sb);
	}
	
//---------------------------------------------------------------------------------------------------------------------------------	
	public String reverseRecurion(String str) {
        if ((str == null) || (str.length()  <= 1)) {
            return str;
        }
        //System.out.println(str.substring(1) + str.charAt(0));
        return reverseRecurion(str.substring(1)) + str.charAt(0);
    }
	
}