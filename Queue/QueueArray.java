package Queue;

class ArrayQueue<E> implements Queue<E>{
	int capacity;		//an integer representing the capacity of our ArrayQueue
	int items;			//an integer representing the amount of items stored in our ArrayQueue
	int front;			//an integer representing where the front element is located in the array
	int rear; 			//an integer representing where the rear element is located in the array
	E elements[]; 		//an generic array to store the elements in the ArrayQueue

	//Default constructor. If this is called, an ArrayQueue with capacity 10 is instantiated
	public ArrayQueue(){
		this.front = 0;
		this.rear = 0;
		this.capacity = 10;
		elements =  (E[]) new Object[this.capacity];
		
	}
	
	//Constructor to create an arrayqueue with a user defined size
	public ArrayQueue(int capacity){
		this.front = 0;
		this.rear = 0;
		this.items = 0;
		this.capacity = capacity;
		elements =  (E[]) new Object[this.capacity];
	}


//Return the amount of stored items in the ArrayQueue
public int size(){
	return this.items;
}

//Determine whether the ArrayQueue is empty
public boolean isEmpty(){
	return(this.items == 0);
}

//Determine if the ArrayQueue is full
public boolean isFull(){
	return(this.items == this.capacity);
}

//Enqueue a new item in the array queue
public void enqueue(E newItem) {
	//Check if the ArrayQueue is full
	if(this.isFull())
		throw new FullQueueException("Cannot enqueue, ArrayQueue is full");
	
	//Add the element
	elements[rear] = newItem;
	items++;
	rear = (rear + 1) % capacity;
}

//Dequeue an item from the ArrayQueue
public E dequeue() {
	//Check if the arrayQueue is empty
	if(this.isEmpty())
		throw new EmptyQueueException("Cannot dequeue, ArrayQueue is empty");
	
	E temp = elements[front];
	elements[front] = null;
	items--;
	front = (front+1) % this.capacity;
	return temp;
}

//Allow the user to "look" at the first element in the queue
public E front(){
	return elements[front];

	
}

//The string representation of the ArrayQueue
public String toString(){
		String temp = "<ArrayQueue[";
		
		for(int i = front; i < capacity; i++)
			if(elements[i] != null)
				temp += elements[i].toString() +",";
		
		if(front == this.rear)
			for(int i = 0; i < this.rear; i++)
				if(elements[i] != null)
					temp += elements[i].toString() +",";
		
		if(temp.charAt(temp.length()-1) == '[')
			return temp + "]>";
		else
			return temp.substring(0, temp.length()-1) + "]>";
	}



}