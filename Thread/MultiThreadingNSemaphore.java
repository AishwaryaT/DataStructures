package Thread;

//imports
import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
import java.util.concurrent.Semaphore;

public class MultiThreadingNSemaphore
{
//Declaration and initialization  variables
	static final int Noofcust = 5;
	static final int Noofwrkrs = 2;
	//Declaration and initialization of semaphore variables
	public static Semaphore max_capacity = new Semaphore(3);
	public static Semaphore cust_ready = new Semaphore(0);

	public static Semaphore employee = new Semaphore(Noofwrkrs);
	
	public static Semaphore mutex1 = new Semaphore(1);
	public static Semaphore mutex2 = new Semaphore(1);
	public static Semaphore mutex3 = new Semaphore(1);
	
	public static Semaphore[] finished_cust = new Semaphore[Noofcust];
//Declaration of Global Variables
	static int Count = 0;
	
//Declaration of Queues
	Queue<Integer> q = new LinkedList<Integer>();
	Queue<Integer> qRand = new LinkedList<Integer>();

//Customer  to perform the task of customer 	
	class Customer extends Thread {
		int cust_id;	
		public Customer(int i) {
			cust_id = i;
		}
		public void run() {
			int custno;
			try {
//Max capacity semaphore allows only 10 customers
				max_capacity.acquire();
				customer_enters_PO(this.cust_id);
				
				mutex1.acquire();				
//Assigning customer number for the each customer
				custno = Count;
				Count++;
				mutex1.release();

				mutex2.acquire();
//Pushing the customer number and task into the Queue
				q.add(custno);
				int task1 = random(); 
				qRand.add(task1);
				cust_ready.release();
				mutex2.release();

				finished_cust[custno].acquire();
//After completion of the task, customer leaves the post office
				max_capacity.release();

			//	Joined_customer(this.cust_id);
				
			} catch (InterruptedException e) {				
				e.printStackTrace();
			}		}
		
	//Random number for the task to the customer	
		private int random() {
			Random randomGenerator = new Random();
			int randomInt = randomGenerator.nextInt(100);
			int task2 = randomInt%3;
			return task2;
		}
		private void Joined_customer(int cust_id2) {
			System.out.println(" Joined Customer " + cust_id2 );
			
		}
		private void customer_enters_PO(int cust_id2) {
			System.out.println("  Customer " + cust_id2 + " Enters Post Office");
			
		}	}


	//Worker  to perform the task of worker 
	class Workers extends Thread {
		int Wrkr_id;
		public Workers(int i) {
			Wrkr_id = i;
		}
		public void run() {
			int cust_no = 0;
			boolean flag = true;
			while(flag) {
				try {

					cust_ready.acquire();
//dequeue customer_number and  task of the customer
					mutex2.acquire();
					if (cust_no < Noofcust)
						cust_no = q.remove();

					int task = qRand.remove();
					mutex2.release();

					employee.acquire();
					//Postal worker job depending  on customer's task
					serve_worker(this.Wrkr_id, cust_no);
	
					//If the task is buying stamps					
					if(task == 0){

					
						System.out.println("Customer " +cust_no+ " asks postal worker " +this.Wrkr_id + " to buy stamps");
						Thread.sleep(1000);
						System.out.println("Postal worker: " + this.Wrkr_id + " finished serving customer :" +cust_no);
						System.out.println("Customer "+cust_no+" finished buying stamps");


					}
					//If the task is Mailing letter	
					if(task == 1){
					
						System.out.println("Customer " +cust_no+ " asks postal worker " +this.Wrkr_id + " to mail a letter");
						Thread.sleep(1500);
						System.out.println("Postal worker: " + this.Wrkr_id + " finished serving customer :" +cust_no);
						System.out.println("Customer "+cust_no+" finished mailing letter");

					}
					//If the task is Mailing package
					if(task == 2){
						
						System.out.println("Customer " +cust_no+ " asks postal worker " +this.Wrkr_id + " to mail a package");
						mutex3.acquire();
						//Function  Scale used for mailing package  
						scale_in_use(this.Wrkr_id);
						Thread.sleep(2000);
						System.out.println("Scales released by postal worker : "+this.Wrkr_id);
						mutex3.release();
						System.out.println("Postal worker: " + this.Wrkr_id + " finished serving customer :" +cust_no);
						System.out.println("Customer "+cust_no+" finished Mailing Package");

					}
					if(cust_no == Noofcust-3)
						flag = false;
					if(cust_no == Noofcust-2)
						flag = false;
					if(cust_no == Noofcust-1)
						flag = false;
					//Release employee semaphore once done with the task
					employee.release();
					Thread.sleep(100);

					System.out.println("Customer "+ cust_no +  " leaves post office");
					finished_cust[cust_no].release();				

				} catch (InterruptedException e) {
					e.printStackTrace();
				}	}	}
		//Postal worker Serving customer
		private void serve_worker(int wrkr_id2, int cust_no1) {
			System.out.println("Postal worker: " + wrkr_id2 + " Serving customer: " +cust_no1 );
			
		}
		//Scales used for packaging 
		private void scale_in_use(int wrkr_id2) {
			System.out.println(" Scales in use by postal worker  : "+wrkr_id2);


		}}	



//start of the main function
	public static void main(String args[]) {		
		MultiThreadingNSemaphore thr = new MultiThreadingNSemaphore();
		thr.run();
			
	}

//Method used  to generate Threads
	public void run(){

		//Initializing finished_cust thread for each customer 
		for(int index =0; index< finished_cust.length; index++)     {
			finished_cust[index] = new Semaphore(0);
		}
			
		
		//Declaration of Customer thread
		//Customer c[] = new Customer[Noofcust];
		Thread myThreadc[] = new Thread[Noofcust];
		
		
		
		//Creation of 50 threads for the Customer
		for (int i=0; i<Noofcust; i++) {
			//c[i] =  new Customer(i);
			//myThreadc[i] = new Thread(c[i]);
			myThreadc[i] = new Customer(i);
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println(" Customer "+ i +" Created");
			myThreadc[i].start();		}

		//Declaration of Worker thread
		//Workers w[] = new Workers[Noofwrkrs];
		Thread myThreadw[] = new Thread[Noofwrkrs];
		
		//Creation of 3 threads for the Worker
		for (int i=0; i<Noofwrkrs; i++) {
			//w[i] =  new Workers(i);
			myThreadw[i] = new Workers(i);

			System.out.println(" Postal worker "+ i +" Created");
			myThreadw[i].start();

		}	} }






