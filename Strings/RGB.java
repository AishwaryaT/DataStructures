package Strings;

public class RGB {
	 public static String formatRGB ( int r, int g, int b ) {
	        return (toHex(r) + toHex(g) + toHex(b)).toUpperCase();
	    }

	    public static String toHex ( int c ) {
	        String s = Integer.toHexString ( c );
	        return ( s.length() == 1 ) ? "0" + s : s;
	    }
	    public static void main(String []args){
	    	System.out.println(formatRGB(434,5134,6134));
	    }
}
