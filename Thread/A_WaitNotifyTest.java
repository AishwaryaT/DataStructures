package Thread;

public class A_WaitNotifyTest {
	 
    public static void main(String[] args) {
        A_Message msg = new A_Message("process it");
        A_Waiter waiter = new A_Waiter(msg);
        new Thread(waiter,"waiter").start();
         
        A_Waiter waiter1 = new A_Waiter(msg);
        new Thread(waiter1, "waiter1").start();
         
        A_Notifier notifier = new A_Notifier(msg);
        new Thread(notifier, "notifier").start();
        System.out.println("All the threads are started");
    }
 
}