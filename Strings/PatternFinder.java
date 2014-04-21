package Strings;

public class PatternFinder {
	public static void main(String []args){
		PatternFinder p = new PatternFinder();
		System.out.println(p.Find("aiiishwarya","warya"));
	}

	//method 1
	int Find(String text, String pattern){
		int n = text.length();
		int m = pattern.length();
		int j=0;
		for(int i = 0; i < n; i++){ 
			if(j < m){
				if(text.charAt(i) == pattern.charAt(j))
					j++;
				else{
					i = i - j; //if kks doesn't start at 1st k of akkkshwarya, it might start at 2nd k. so reset the i value 
					j = 0;//reset to the start of pattern
				}
			}
			
		}
		if(j == m) return 1;
		
		else return 0;
	}
	
	//method 2
	int Find2(String text, String pattern){
		int n = text.length();
		int m = pattern.length();
		
		for(int i = 0; i < n-m+1; i++){ //aishwarya =9, war=3, u only need to search till r. ie. till 9-3+1 letters.
			int j=0;
			while((j < m)&&(text.charAt(i+j) == pattern.charAt(j))) // for each i, browse the next m-1 letters
					j++;
			if(j == m)		
				return 1;			
		}
		return 0;
	}
	
}
