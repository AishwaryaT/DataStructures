package Thread;
 class Reentrant {
    public synchronized void a() {
	b();
	System.out.println("here I am, in a()");
    }
    public synchronized void b() {
	System.out.println("here I am, in b()");
    }
}

public class ReentrantDemo{
	public static void main(String[] args){
		Reentrant r = new Reentrant();
		r.a();
	}
}