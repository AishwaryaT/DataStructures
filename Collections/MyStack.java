package Collections;

public class MyStack {
	   private int maxSize;
	   private long[] stackArray;
	//   int[] a; 
	   private int top;
	   public MyStack(int s) {
		//  a= new int[8];
	      maxSize = s;
	      stackArray = new long[maxSize];
	      top = -1;
	   }
	   public void push(long j) {
	      stackArray[++top] = j;
	   }
	   public long pop() {
	      return stackArray[top--];
	   }
	   public long peek() {
	      return stackArray[top];
	   }
	   public boolean isEmpty() {
	      return (top == -1);
	   }
	   public boolean isFull() {
	      return (top == maxSize - 1);
	   }
	  
	   public static void main(String[] args) {
	      MyStack theStack = new MyStack(10); 
	      theStack.push(10);
	      theStack.push(20);
	      theStack.push(30);
	     
	      while (!theStack.isEmpty()) {
	         long value = theStack.pop();
	         System.out.print(value);
	         System.out.print(" ");
	      }
	      System.out.println("");
	   }
	}