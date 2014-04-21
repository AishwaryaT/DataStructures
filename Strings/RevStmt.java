package Strings;

import java.util.Stack;

public class RevStmt {
	public static void main(String []args){
	/*String input = "This is interview question";
	String output = "";
	String[] array = input.split(" ");
	for(int i = array.length-1; i >= 0; i--)
	{
	    output += array[i];
	    if (i != 0) { output += " "; }
	}
	System.out.println(output);*/
		ReverseByWord r = new ReverseByWord();
		System.out.println(r.reverseByWord("I am going there"));
}
	
}
class ReverseByWord {

	    public static String reversePart (String in){
	        // Reverses the complete string
	        String reversed = "";
	        for (int i=0; i<in.length(); i++){
	            reversed=in.charAt(i)+reversed;
	        }
	        return reversed;
	    }

	    public static String reverseByWord (String in){
	        // First reverses the complete string
	        // "I am going there" becomes "ereht gniog ma I"
	        // After that we just need to reverse each word.
	        String reversed = reversePart(in);
	        String word_reversal="";
	        int last_space=-1;
	        int j=0;
	        while (j<in.length()){
	            if (reversed.charAt(j)==' '){
	                word_reversal=word_reversal+reversePart(reversed.substring(last_space+1, j));
	                word_reversal=word_reversal+" ";
	                last_space=j;
	            }
	            j++;
	        }
	        word_reversal=word_reversal+reversePart(reversed.substring(last_space+1, in.length()));
	        return word_reversal;
	    }

	   /*// Stand alone program to rev a stmt:
	    * public static String reverseByWord (String in){
	    	//String reversed = reversePart(in);
	    	String arr[] = in.split(" ");
	    	Stack s = new Stack();
	    	StringBuilder sb = new StringBuilder();
	    	for(int i=0; i< arr.length; i++){
	    		System.out.print(arr[i] + " ");
	    		s.push(arr[i]);
	    	}
	    	for(int i=0; i< arr.length; i++){
	    		
	    		sb.append(s.pop() + " ");
	    	}
	    	
	    
	    	in = sb.toString();
	    	//System.out.println(in);
	    	return in;
	    }*/
	   
	}
