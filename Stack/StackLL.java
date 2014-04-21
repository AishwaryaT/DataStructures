package Stack;

public class StackLL {
	
	Node Head = null;
	
	class Node{
		int data;
		Node next;
		
		Node(){
			data = 0;
			next = null;
		}
		
		Node(int data){
			this.data = data;
			next = null;
		}
		
		Node (int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public int pop(){
		if (Head != null){
			int tempdata = Head.data;
			Head = Head.next;
			return tempdata;
		}
		else return -1;
	}

	public void push(int data){
		if (Head == null)
			Head = new Node (data);
		else {
			Node newNode = new Node(data, Head);
			Head = newNode;
		}
	}
	
	public boolean isEmpty(){
		return Head == null;
	}
	
	public int top(){
		if (Head != null){
			Node topData = Head;
			return topData.data;
		}
		else
			return -1;
	}
	
	public static void main(String []args){
		StackLL s = new StackLL();
		
		s.push(4);
		s.push(3);
		s.push(2);
		s.push(1);
		
		System.out.println(" Top " + s.top());
		System.out.println("Is empty " + s.isEmpty());
		
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());
	}
	
}
