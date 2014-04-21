package Stack;


public class StackArr {

	int stackarr[];
	int data;
	int top;
	int capacity;
	
	StackArr(int capacity){
		this.capacity = capacity;
		stackarr = new int[this.capacity];
		top = -1;
	}
	
	private int pop() {
		if(!isEmpty()){
			int tempdata = stackarr[top];
			top--;
			return tempdata;
		}
		return -1;
	}

	private boolean isEmpty() {
		return top == -1;
	}

	private boolean isFull() {
		return top == capacity-1;
	}
	private int top() {
		if (!isEmpty())
			return stackarr[top];
		return -1;
	}

	private void push(int data) throws StackFullException{
		if(!isFull()){
			stackarr[++top] = data;
		}
		else
		
		
		 throw new StackFullException("Stack is full..!");
		
	}
	
	public static void main(String args[]){
		StackArr s = new StackArr(3);
		
		try {
			s.push(4);
		} catch (StackFullException e) {
			e.printStackTrace();
		}
		try {
			s.push(3);
		} catch (StackFullException e) {
		
			e.printStackTrace();
		}
		try {
			s.push(2);
		} catch (StackFullException e) {
		
			e.printStackTrace();
		}
		try {
			s.push(1);
		} catch (StackFullException e) {
		
			e.printStackTrace();
		}
		
		System.out.println(" Top " + s.top());
		System.out.println("Is empty " + s.isEmpty());
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}

}
