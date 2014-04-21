package Sorting;

public class MaxHeapSort {
	public static void main(String []args){
		MaxHeap m = new MaxHeap(10);
		m.insert(5);
		m.insert(25);
		m.insert(15);
		m.insert(53);
		m.insert(235);
		m.insert(55);
		m.insert(54);
		m.insert(65);
		
		m.maxHeap();
		m.print();
	}

}
