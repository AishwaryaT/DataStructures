
public class AnonymousInner {
	
	
	
	 static Superclass sc = new Superclass(){
		 @Override
		 public  void read(){
			 System.out.println("Inside Annonymous Subclass");
		 }
		 
		 public void write(){
			 System.out.println("Inside annanymous subclass - write method");
		 }
	 };
	 
	 
	 public static void main(String []args){
		// Superclass s1 = new Superclass();
	 sc.read();
	 //sc.write();
	}
	
}

class Superclass{
	public void read(){
		System.out.println("Inside Superclass");
	}

}
