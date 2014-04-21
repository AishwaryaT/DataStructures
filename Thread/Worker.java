package Thread;

import java.util.ArrayList;
import java.util.Random;

public class Worker{  
	 Object lock1 = new Object();
	 Object lock2 = new Object();
	 
	 static ArrayList<Integer> arr1 = new ArrayList<Integer>();
	 static ArrayList<Integer> arr2 = new ArrayList<Integer>();
	 
	 Random r = new Random();
	 
	 //synchronized
	 void method1(){ 
   
		 synchronized(lock1){//synchronized block  
			 try{  
				 Thread.sleep(1);  
			 }catch(Exception e){
				 System.out.println(e);
			 }  
		 
			 arr1.add(r.nextInt(100));
       
		 }// block end  
	}
    
	 //synchronized 
	void method2(){
    	        
		synchronized(lock2){//synchronized block  
    		   try{  
    		        Thread.sleep(1);  
    		    }catch(Exception e){
    		        System.out.println(e);
    		    }  
    			 
    	     arr2.add(r.nextInt(100));
     	}// block end  
	}  
	
	void process(){
		for(int i =0; i<1000; i++){
			method1();
			method2();
		} 
	}


 	public static void main(String[] args){  
 	final Worker w = new Worker();
	Thread t1 = new Thread(new Runnable(){

		@Override
		public void run() {
			w.process();
			
		}
		
	});
	
	Thread t2 = new Thread(new Runnable(){

		@Override
		public void run() {
			w.process();
			
		}
		
	});
	
	//===============================================
	long start = System.currentTimeMillis();
	//w.process();  // without threads.. normal exe..
	t1.start();  //with one thread
	t2.start();  //with 2 threads
	
	try {
		t1.join();
		t2.join();
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	long end = System.currentTimeMillis();
	//=============================================
	System.out.println("time taken: "+ (end - start));
	
	System.out.println(arr1.size());	
	System.out.println(arr2.size());
	}  
}  