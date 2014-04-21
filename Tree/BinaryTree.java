package Tree;
import java.util.*;
import java.util.Queue.*;
import java.util.LinkedList.*;

public class BinaryTree {

	Node root = null;
	
	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		bt.insert( 4);
		bt.insert( 6);
		bt.insert( 5);
		bt.insert( 8);
		bt.insert( 3);
		System.out.println("Level Order Traversal");
		bt.levelTraversal();
		System.out.println("InOrder Traversal");
		bt.inorderTraverse(bt.root);
	
		//System.out.println("LCA: \n" +bt.LCA(bt.root, 3,4).data);
		System.out.println("Zigzag Traversal");
		bt.Zigzag(bt.root);
		
		/*Stack s1 = new Stack(), s2 = new Stack();
		for(int i = 0; i < 5 ; i++){
			s1.add(i);
			s2.add(i+5);
		}
		System.out.println("before swap:");
		for(int i = 0; i < 5 ; i++){
			System.out.println(s1.pop());
			System.out.println(s2.pop());
		}
		for(int i = 0; i < 5 ; i++){
			s1.add(i);
			s2.add(i+5);
		}
		bt.swap(s1,s2);
		System.out.println("after swap:");
		for(int i = 0; i < 5 ; i++){
			System.out.println(s1.pop());
			System.out.println(s2.pop());
		}*/
	}


	
	private void insert(int data) {
			
		if (root == null){
			root =new Node(data);
			return;
		}
		Node temp = null;
		LinkedList<Node> q = new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			temp = q.remove();
			
			if(temp.left != null)
				q.add(temp.left);
			
			else{
				temp.left = new Node(data);
				return;
				}
			
			if(temp.right != null)
				q.add(temp.right);
			else{
				temp.right = new Node(data);
				return;
			}
		}
		
	}
		

	private Node LCA(Node root, int a, int b) {
		if (root == null) return null;
		if ( root.data == a || root.data == b)
			return root;
		Node l = LCA (root.left, a, b);
		Node r = LCA (root.right, a, b);
		if( l != null && r != null)
			return root;
		return (l != null)? l : r;
		
	}

	private void inorderTraverse(Node node) {
		;
		if ( node == null) 
					return;
	    inorderTraverse(node.left);
		System.out.println(node.data);
		inorderTraverse(node.right);
		
	}
	
	
	private void levelTraversal() {
	
		if(root == null)	return;
		
	    Node temp = null;
		LinkedList<Node> q =  new LinkedList<Node>();
		q.add(root);
		
		while(!q.isEmpty()){
			temp = q.remove();
		 	System.out.println(temp.data);
			if(temp.left != null)
				q.add(temp.left);
			if(temp.right != null)
				q.add(temp.right);
			
		}
		
	}
		
	
	

void Zigzag(Node root){
	
if (root == null) return;
int leftToRight = 0; // right to left 
Stack<Node> currentLevel = new Stack<Node>(), nextLevel = new Stack<Node>();
currentLevel.push(root);

while (!currentLevel.isEmpty()){
    Node temp = currentLevel.pop();
    
    if(temp != null){
        System.out.println(temp.data);
        
        if(leftToRight == 0){
             if(temp.right != null)
                nextLevel.push(temp.right); 
             if(temp.left != null)
                  nextLevel.push(temp.left);            
         }
         else {
              if(temp.left != null)
                  nextLevel.push(temp.left);
              if(temp.right != null)
                nextLevel.push(temp.right);
         }    
        }
        if(currentLevel.isEmpty()){
          leftToRight = 1 - leftToRight;
          swap(currentLevel, nextLevel);
          }
	}
}

	private void swap(Stack<Node> currentLevel, Stack<Node> nextLevel) {
		Stack<Node> temp = new Stack();
		temp.addAll(currentLevel);
		currentLevel.clear();
		currentLevel.addAll(nextLevel);
		nextLevel.clear();
		nextLevel.addAll(temp);
	}
}
