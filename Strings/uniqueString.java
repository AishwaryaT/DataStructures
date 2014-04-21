package Strings;

public class uniqueString {

	/**
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		String s = "ishwaryz";
		uniqueString u = new uniqueString();
		System.out.println(u.isUniquebit(s));
		System.out.println(u.isUnique(s));
	}
	
	
	public boolean isUnique(String s){
		boolean [] char_val = new boolean[256];
		if (s.length()>256) return false;
		
		for(int i =0; i < s.length(); i++){
			int val = s.charAt(i);
			System.out.println(s.charAt(i)+"--- "+val);
			if(char_val[val])
				return false;
			else
				char_val[val]=true;
		}
		return true;
	}

	
	
	public boolean isUniquebit(String s){
		if (s.length()>256) return false;
		int checker = 0;
		for(int i =0; i < s.length(); i++){
			int val = s.charAt(i) - 'a';
			System.out.println(s.charAt(i)+" "+val);
			if ((checker & (1<<val)) > 0) {
				System.out.println(checker+" "+(1<<val));
				return false;
			}
			checker |= (1 << val);
			System.out.println(checker+" "+(1<<val));
		}
		return true;
	}
}
