
/** This class is a user-defined class that contains one methods cube.*/  
public class M{  
  
public static void main(String args[]) throws InterruptedException{
	for(int i =0; i <10000; i++){
		System.out.println("Print : "+i);
		Thread.sleep(200);
		if(i==10){
			System.exit(0);
		}
	}
}
}  