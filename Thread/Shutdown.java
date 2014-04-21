package Thread;

public class Shutdown {  
public static void main(String[] args)throws Exception {  
  
 
Runnable myrunnable = new Runnable(){  
public void run(){  
    System.out.println("Shutdown hook is initiated. all tasks completed.");  
    }  
};  
 
Thread t = new Thread(myrunnable);  

Runtime.getRuntime().addShutdownHook(t);
System.out.println("JVM Shutdown Hook Registered.");
System.out.println("Pre exit.");
System.exit(0);
//System.out.println("Now main sleeping... press ctrl+c to exit");  
//try{Thread.sleep(3000);}catch (Exception e) {}  
System.out.println("Post exit.");	
}  
 
}  