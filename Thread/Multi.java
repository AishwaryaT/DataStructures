package Thread;
class Multi extends Thread{  
	 public void run(){  
	  System.out.println("Name: "+Thread.currentThread().getName());  
	  System.out.println("Daemon: "+Thread.currentThread().isDaemon());  
	 }  
	  
	 public static void main(String[] args){  
	  Multi t1=new Multi();  
	  Multi t2=new Multi();  
	  t1.setDaemon(true);  
	    
	  t1.start();  
	  t2.start();  
	 }  
	}  