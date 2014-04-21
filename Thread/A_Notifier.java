package Thread;

public class A_Notifier implements Runnable {
	 
    private A_Message msg;
     
    public A_Notifier(A_Message msg) {
        this.msg = msg;
    }
 
    @Override
    public void run() {
        String name = Thread.currentThread().getName();
        System.out.println(name+" started");
        try {
            Thread.sleep(1000);
            synchronized (msg) {
                msg.setMsg(name+" Notifier work done");
                msg.notify();
               // msg.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
         
    }
 
}