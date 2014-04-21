package Arrays;



public class KthLargest {

	
	static final int FRONT = 1;
	
	public static void main(String...arg)
    {
     KthLargest k = new KthLargest();
     int arr[] = {5,3,17,10,84,19,6,22};
     System.out.println(k.Kthlargest(arr, 4));
   
    }

	public int Kthlargest (int [] arr, int K){
		 MinHeap minHeap = new MinHeap(15);
		for (int i = 0; i < K-1; i++)
			minHeap.insert(arr[i]);
		minHeap.minHeap();
	
			//System.out.println("hihhi"+arr[4]);
			
		
		for (int j = K; j < arr.length; j++){
			if(arr[j] > minHeap.Heap[FRONT]){
				minHeap.Heap[FRONT] = arr[j];
				minHeap.minHeap();		
				for (int i = 1 ; i< K;i++)
					System.out.println("hihhi"+minHeap.Heap[i]);
			}
		}	
		K = minHeap.remove();
		return K;
	}
}

