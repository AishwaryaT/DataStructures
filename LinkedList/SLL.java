package LinkedList;

//import DataStructures.SLL.Node;

public class SLL{

	Node Head = null;
	
	class Node{
		int data;
	    Node next;
		
		Node(int data){
			this.data = data;
		}

		Node(int data, Node next){
			this.data = data;
			this.next = next;
		}
	}
	
	public void insert(int data) {
	if (Head == null){
		Head = new Node(data, null);
		}
	else {
		Node currentNode = Head;
		while (currentNode.next != null)
			currentNode = currentNode.next;
		currentNode.next = new Node(data, null);
		}
	}

	public void insert(int data, int position) {
		int size = this.listLength();
		if (position > size || position < 1)
			return;
		
		if (position == 1){
			Node currentNode = new Node(data,Head);
			Head = currentNode;
			
		}
		else{
			
			Node preNode = Head;
			int count = 1;
			while(count < position - 1){
				preNode = preNode.next;
				count ++;
			}
			
			//1  2 3 4 5 6
			Node newNode = new Node(data);
			newNode.next=preNode.next;
			preNode.next=newNode;
		}
			
	}

	public void delete(int data) {
		System.out.println("Delete() :" + data);
		Node preNode = Head;
		int found = 0;	
		if(Head.data == data){
			Head = Head.next;
			return;
		}
		
		while (preNode.next != null){
			if(preNode.next.data == data)
			{  
				found = 1;
				break;
			}
			preNode = preNode.next;
			
		}
			
		if (found == 1){
			Node currentNode = preNode.next;
			preNode.next = currentNode.next;
			currentNode = null;
		}
		else
			System.out.println("Elem Not found");
	}

	
	public void traverse(Node Head) {
		Node currentNode = Head;
		while (currentNode != null) {
			System.out.print(" "+currentNode.data);
			currentNode = currentNode.next;
			
		}
		System.out.println(" ");
	}

	public void cirTraverse(Node Head) {
		//System.out.println("Double HIIIIIIIII");
		Node currentNode = Head.next;
		System.out.print(Head.data);
		while (currentNode != Head) {
			System.out.print(" "+currentNode.data);
			currentNode = currentNode.next;
			
		}
		System.out.println(" ");
	}
	public void nthNode(int n) {
		Node nthNode = Head;
		Node temp = Head;
		int size = listLength();
		if(n < 1 || n > size) {
			System.out.println("Check position");
			return;
		}
		for(int i = 1; i < n; i++){
			temp = temp.next;
		}
		while(temp.next != null){
			nthNode = nthNode.next;
			temp = temp.next;
		}
		System.out.println("the "+n+"th node from end is "+nthNode.data);
	}

	public Node reverse(Node list) {
		Node nextNode = null, temp = null;
		while (list != null){
			nextNode = list.next;
			list.next = temp;
			temp = list;
			list = nextNode;
		}
		
		return temp;
		//System.out.println("Reversed:");
		//while (temp !=null){
			//System.out.print(temp.data+ " ");
			//temp = temp.next;
	}
	

	public int listLength() {
		Node currentNode = this.Head;
		int count = 1;
		
		while(currentNode.next != null){
			currentNode = currentNode.next;
			count++;
		}
		return count;
		
	}

	public void loop() {
		
		Node currentNode = Head;
		while( currentNode.next != null){
			currentNode = currentNode.next;
			}
		Node newNode = new Node(100,Head);
	    currentNode.next = newNode;
	    
	}

	public int findLoop() {
		Node fastPtr = Head, slowPtr = Head;
		
		while(slowPtr != null && fastPtr != null){
			
			fastPtr = fastPtr.next;
			if(fastPtr == slowPtr) return 1;
			
			if (fastPtr == null) return 0;
			
			fastPtr = fastPtr.next;
			if(fastPtr == slowPtr) return 1;
			
			slowPtr = slowPtr.next;
		}
		return 0;
	}

	public Node findBeginningOfLoop() {
		Node slowPtr = Head, fastPtr = Head;
		int loopExists = 0;
		while(slowPtr != null && fastPtr != null){
			fastPtr = fastPtr.next;
			if(fastPtr == slowPtr){
				loopExists = 1;
				System.out.println(loopExists);
				break;
			}
			if(fastPtr == null){
				loopExists = 0;
				System.out.println(loopExists);
				break;
			}
			fastPtr = fastPtr.next;
			if(fastPtr == slowPtr){
				loopExists = 1;
				System.out.println(loopExists);
				break;
			}
			slowPtr = slowPtr.next;
		}
		
		if(loopExists == 1){
			slowPtr = Head;
			System.out.println("inside loopexists");
			//int count = 0;
			while(slowPtr != fastPtr){
				slowPtr = slowPtr.next;
				fastPtr = fastPtr.next;
				//count++;
			}
			return slowPtr;
		}
		return null;
	}

	public int loopLength() {
		Node slowPtr = Head, fastPtr = Head;
		int loopExists = 0, counter = 1;
		while(slowPtr != null && fastPtr != null){
			fastPtr = fastPtr.next;
			if(fastPtr == slowPtr){
				loopExists = 1;
				//System.out.println(loopExists);
				break;
			}
			if(fastPtr == null){
				loopExists = 0;
				//System.out.println(loopExists);
				break;
			}
			fastPtr = fastPtr.next;
			if(fastPtr == slowPtr){
				loopExists = 1;
				//System.out.println(loopExists);
				break;
			}
			slowPtr = slowPtr.next;
		}
		
		if(loopExists == 1){
			slowPtr = slowPtr.next;
			//System.out.println("inside loopexists");
		
			while(slowPtr != fastPtr){
				slowPtr = slowPtr.next;
				
				counter++;
			}
			return counter;
		}
		return counter;
		
	}

	public int middleElem() {
		Node fastPtr = Head, slowPtr = Head;
		if (Head == null) return 0;
		while(fastPtr.next != null){
			fastPtr = fastPtr.next;
			if(fastPtr.next != null)
				fastPtr = fastPtr.next;
			
			slowPtr = slowPtr.next;
			
		}
		return slowPtr.data;
	}

	public Node middleElem1() {
		Node fastPtr = Head, slowPtr = Head;
		if (Head == null) return null;
		while(fastPtr.next != null){
			fastPtr = fastPtr.next;
			if(fastPtr.next != null)
				fastPtr = fastPtr.next;
			
			slowPtr = slowPtr.next;
			
		}
		
		return slowPtr;
	}
	public void fromLast(Node Head) {
		if (Head == null) return;
		
		fromLast(Head.next);
		System.out.print(Head.data + " ");
	}

	public int evenOdd(Node list) {
		if (list == null) return 0;
		while(list != null && list.next != null){
			list = list.next.next;
		}
		if(list == null)
		    return 0;
		else
			return 1;
	}

	public Node mergeSort(Node list1, Node list2) {
		Node result = new Node(0,null); 
		if (list1 == null) return list2;
		if (list2 == null) return list1;
		if (list1.data < list2.data){
			result.data = list1.data;
			result.next = mergeSort(list1.next, list2);
		}
		else {
			result.data = list2.data;
			result.next = mergeSort(list2.next, list1);
			}
		return result;
	}

	
	
	public  Node swapInPair(Node n) {
	    Node buffer = null;
	    Node newRoot = null;
	   while (n != null && n.next != null) {
		     if (buffer != null) {
	            buffer.next.next = n.next;
	        }
	 
	        buffer = n.next;
	        n.next = n.next.next;
	        buffer.next = n;
	        if (newRoot == null)
	            newRoot = buffer;
	        	        
	        n = n.next;
	    }
	    return newRoot;
	}

	public void SplitCirList() {
		if (Head == null || Head.next == Head)
			return;
		Node fastPtr = Head, slowPtr = Head, head1, head2;
		while(fastPtr.next != Head && fastPtr.next.next != Head){
			fastPtr = fastPtr.next.next;
			slowPtr = slowPtr.next;
		}
		if(fastPtr.next.next == Head)
			fastPtr = fastPtr.next;
		head1 = Head;
		head2 = slowPtr.next;
		fastPtr.next = head2;
		slowPtr.next = head1;
		//System.out.println("Hiiiiiiiiiiiii");
		this.cirTraverse(head1);
		this.cirTraverse(head2);
	}

	public void palindrome(Node head) {
		Node mid = middleElem1();
		Node rev = reverse(mid);
		traverse(head);
		traverse(rev);
		while(head != mid){
			
			if(head.data != rev.data){
				System.out.println("Not a palindrome");
				return;
			}
			head = head.next;
			rev = rev.next;
		}
		System.out.println("It's a palindrome");
	
	}

	public void josephusCircle(Node head, int M) {
		int size = loopLength();
		for (int i = size; i > 1; --i){
			for (int j =1; j < M-1; ++j){
				head = head.next;
			}
			head.next = head.next.next;
		}
		System.out.println(head.data);
	}
}


 class LL {
	
	public static void main( String[] args){
		SLL s1 = new SLL();
		SLL s2 = new SLL();
		SLL s3 = new SLL();
		SLL mergeSorted = new SLL();
		SLL reversed = new SLL();
//Insert
		System.out.println("Insert");
		s1.insert(3);
		s1.insert(34);
		s1.insert(344);
		s1.insert(35);
		s1.insert(36);
		s1.insert(37);
		//s1.insert(39);
		//s1.insert(33);
		
		// s2 & s3
		s2.insert(2);
		s2.insert(78);
		s2.insert(134);
		s2.insert(140);
		
		s3.insert(1);
		s3.insert(45);
		s3.insert(45);
		s3.insert(10);
		
// Insert(data, position)
		s1.insert(15,5);
		//s1.insert(4,1);
		s1.traverse(s1.Head);

//Delete
		//System.out.println("Delete:");
		s1.delete(20);
		s1.delete(33);

//Traverse
		System.out.println("Traverse:");
		s1.traverse(s1.Head);
		
//Nth node from the end of LinkedList
		System.out.println("Nth node from end:");
		s1.nthNode(4);

//Reverse
		//System.out.println("Reverse:");
 		//reversed.Head = s1.reverse(s1.Head);
 		//reversed.traverse(s1.Head);

//List Length
		System.out.println("List Length:");
		System.out.println(s1.listLength());
		

		
//Find the loop length
		//System.out.println("Find loop length:");
		//System.out.println(s1.loopLength());
		
//Find middle Element
		System.out.println("Middle Element:");
		System.out.println(s1.middleElem());
		
//Display linked list from end
		System.out.println("From the end: ");
		s1.fromLast(s1.Head);
		
//List length is even or odd
		System.out.println("\nList length is even or odd");
		int evenOdd = s1.evenOdd(s1.Head);
		if (evenOdd == 0)
			System.out.println("Even");
		else
			System.out.println("Odd");

//Merge sort two lists
		System.out.println("Merge sort 2 sorted lists:");
		mergeSorted.Head = s1.mergeSort(s2.Head, s3.Head);
		mergeSorted.traverse(mergeSorted.Head);

//Reverse Linked list in pair
		s2.traverse(s1.Head);
		System.out.println("Reverse in pair:");
		reversed.Head = s1.swapInPair(s1.Head);
		reversed.traverse(reversed.Head);

//creating a loop:
		System.out.println("Create a loop:");
		s1.loop();
		s1.cirTraverse(s1.Head);

//Find loop
		//System.out.println("Find Loop:");
		//System.out.println("Is there a loop? "+s1.findLoop());

//Find beginning of loop //not works
		//System.out.println("Find beginning of loop:");
		//System.out.println("Where does the loop begin? "+s1.findBeginningOfLoop());

//Split Circular list
		System.out.println("Split Circular List:");
		s1.SplitCirList();
//traverse circular list
		//System.out.println("Traverse a circular list");
		
//palindrome or not
		System.out.println("Palindrome or not:");
		s3.palindrome(s3.Head);
		
//josephus circle
		System.out.println("Josephus Circle");
		s1.josephusCircle(s1.Head, 5);
	}
}
