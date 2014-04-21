package Tree;


class Node {
	int data;
	Node left;
	Node right;
	
	Node(){
		data = 0;
		left = null;
		right = null;
	}
	
	Node (int data, Node left, Node right){
		this.data = data;
		this.left = left;
		this.right = right;
		}
	
	Node (int data){
		this.data= data;
		left = null;
		right = null;
	}
}
