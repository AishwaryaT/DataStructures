package Tree;


public class BinarySearchTree {
	
	Node root = null;
	
	
	public static void main (String []args){
		BinarySearchTree bst = new BinarySearchTree();
		bst.insert(2);
		bst.insert(1);
		bst.insert(9);
		bst.insert(6);
		bst.insert(5);
		bst.insert(8);
		
		//bst.delete(12);
		
		bst.inorderTraverse(bst.root);
		System.out.println(bst.LCA(bst.root,1,8).data);
		
	}

	private Node LCA(Node root, int a, int b) {
	
		if (root.data == a || root.data == b)
			return root;
		
		else if( root.data < a && root.data < b)
				return LCA (root.right ,a ,b);
		else if( root.data > a && root.data > b)
			return LCA (root.left, a,b);
		else return root; 
		
		
		
	}

	private void delete(int data) {
		delete(root, data);
	}

	private Node delete(Node root, int data) {
		if(root == null)
			return null;
		
		if(data < root.data)
			root.left = delete(root.left, data);
		
		else if(data > root.data)
			root.right = delete(root.right, data);
		
		else{ 
			if(root.left != null && root.right != null){
				Node temp = findMax(root.left);
				root.data = temp.data;
				root.left = delete(root.left, root.data);
			}
			else{
				//Node temp = root;
				if(root.left == null && root.right ==null)
					return null;
				if(root.left == null){
					root = root.right;
					//root.right = null;
				}
				if(root.right == null) {
					root = root.left;
					//root = null;
				}
				
				//temp = null;
			}
		}
		return root;
	}

	private Node findMax(Node root) {
		Node maxNode = null;
		if (root == null) 
			return null;
		
		if ( root.right != null)
			return	findMax(root.right);
		else 
			return root;
	}

	private void inorderTraverse(Node node) {
		//System.out.println("In order Traversal of BST: \n");
		if ( node == null) 
			return;
		
		inorderTraverse(node.left);
		System.out.println(node.data);
		inorderTraverse(node.right);
		
	}

	public void insert(int data) {
		
		if (root == null) 
			root = new Node(data);
		else
			insert (root, data);
	}
	
	
	
	private void insert(Node root, int data) {
			
		if (root.data == data)
			return;
					
		if (data < root.data) {
			if (root.left == null)
				root.left = new Node(data); 
			else 
				insert(root.left, data);
		}
				
			
		if (data > root.data){
			if (root.right == null)
				root.right = new Node(data);
			else
				insert(root.right, data);
		}
	}
			
	
}
