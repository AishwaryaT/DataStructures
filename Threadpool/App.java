// 5 tasks, each thread to process a task; if one thread finishes a task start on a new task
//submit tasks to executor

package Threadpool;


import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

class Processor implements Runnable{
	private int id;
	public Processor(int id){
		this.id = id;
	}
	@Override
	public void run() {
		System.out.println("Starting: "+ id);
		try{
		Thread.sleep(5000);
		}
		catch(InterruptedException e){
			e.printStackTrace();
		}
		System.out.println("Completed: "+ id);
		
	}
	
}

public class App {
	public static void main(String[] args){
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		for(int i=0; i<5; i++)
			executor.submit(new Processor (i));
		System.out.println("All tasks submitted");
		executor.shutdown();
		
		try {
			executor.awaitTermination(1, TimeUnit.DAYS);
		} catch (InterruptedException e) {
		
			e.printStackTrace();
		}
		System.out.println("All tasks completed");
	
	}
}