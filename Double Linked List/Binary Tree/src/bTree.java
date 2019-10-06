
public class bTree <T>{
	int size;
	Node<T> root;
	private class Node<T> {
		int key;
		T data;
		//left child and right child 
		Node<T> left;
		Node<T> right;
		public Node(){
			key = 0;
			data = null;
			left = right = null;
		}
		public Node (int k, T d){
			key = k;
			data = d;
			left = right = null;
		}
		public String toString() {
			String st = "(" + key + ", " + data+")";
			return st;
		}
	}
	//CTOR for the tree
	public bTree(){
		size = 0;
		root = null;
	}
	
	public void insert (int k, T d){
		//build a node using k and d
		Node<T> newNode = new Node<T>(k, d);
		//test if the tree is empty, 
		//if it is then assign root to the new node 
		if(root == null){
			root = newNode;
			size = 1;
			return;
		}
		//loop (infinite loop that will break to stop)
		//if k is smaller than current node key go the the left
		//if any, otherwise connect the node to the left. 
		//return to break the loop.
		//If k is larger go to the right, if any otherwise connect the 
		//new node to the right and return to break the loop.
		Node<T> temp = root;
		while(true){
			if(k < temp.key){
				if(temp.left != null) {
					//go to the left
					temp = temp.left;
					continue;//skip everything and go back one loop
				}else {
					//insert the node right here
					temp.left = newNode;
					size++;
					return;
				}
			}else {//the key is larger
				if(temp.right != null) {
					//go to the right
					temp = temp.right;
					continue;//skip everything and go back one loop
				}else {
					//insert the node right here
					temp.right = newNode;
					size++;
					return;
				}
			}
		}
	}
	public void InOrderTraversal() {
		InOrder(root);//first call with the root of the tree
	}
	private void InOrder(Node<T> n){
		if(n == null)
			return;
		InOrder(n.left);
		System.out.print(n.toString());
		InOrder(n.right);
	}
	public void PreOrderTraversal() {
		PreOrder(root);//first call with the root of the tree
	}
	private void PreOrder(Node<T> n){
		if(n == null)
			return;
		System.out.print(n.toString());
		PreOrder(n.left);
		PreOrder(n.right);
	}
	public void PostOrderTraversal() {
		PostOrder(root);//first call with the root of the tree
	}
	private void PostOrder(Node<T> n){
		if(n == null)
			return;
		PostOrder(n.left);
		PostOrder(n.right);
		System.out.print(n.toString());
	}
	//Method to return the reference to a parent of a specific node
		//null if it does not exist
		public Node<T> findParent(int k){
			Node<T> pt = root;
			Node<T> current = root;
			while(current != null && current.key != k) {
				//remember the previous 
				pt = current;
				//move to left or right depending on the key
				if(k < current.key){//move to the left
					current = current.left;
				}else {//move to the right
					current = current.right;
				}
			}
			if(current == null)
				return null;
			return pt;
		}
		//design a method remove that will remove a specific node and 
		//return the data 
		public T remove (int k){
			//Check if the node to be deleted is the root 
			//without a left or a right
			if(root.key == k) {
				T retVal = root.data;
				if (root.right == null){
					root = root.left;
					size--;
					return retVal;
				}else if (root.left == null){
					root = root.right;
					size--;
					return retVal;
				}else {
					//both left and right child is not null
					///both left and right of child are not null
					//either you replace by the largest on the left
					//or the smallest on the right
					//we chose to the smallest on the right
					Node<T> smallest = root.right;
					Node<T> pSmall = root;
					while(smallest.left != null) {
						//remember the parent
						pSmall = smallest;
						//go left;
						smallest = smallest.left;
					}
					//save the data to return 
					T save = root.data;
					//copy smallest to the node to be removed (child)
					root.key = smallest.key;
					root.data = smallest.data;
					if(pSmall.left!=null && pSmall.left.key == smallest.key){
						//smallest is attached to its parent on the left
						//attach left of the parent to the right of child
						pSmall.left = smallest.right;
					}else {
						//it has to be on the right
						//Attach right of the parent  to the right of smallest
						pSmall.right = smallest.right;
					}
					size--;
					return save;
				}
			}
			//find the parent of the node to be removed
			Node<T> parent=findParent( k);
			if (parent==null){
				System.out.println("Node does not exist");
				return null;
			}
			//test that the node does not have right or left child
			if(parent.left!=null && parent.left.key==k){///node to be removed is left child of parent
			Node<T> child= parent.left;
				if(child.left==null){
					parent.left=parent.left.right;//this could be null, that's fine
					size--;
					return child.data;
				}
				else if(child.right==null){
					parent.left=parent.left.left;
					size--;
					return child.data;
				}
				else{///both left and right of child are not null
					//either you replace by the largest on the left
					//or the smallest on the right
					//we chose to the smallest on the right
					Node<T> smallest = child.right;
					Node<T> pSmall = child;
					while(smallest.left != null) {
						//remember the parent
						pSmall = smallest;
						//go left;
						smallest = smallest.left;
					}
					//save the data to return 
					T save = child.data;
					//copy smallest to the node to be removed (child)
					child.key = smallest.key;
					child.data = smallest.data;
					if(pSmall.left!=null && pSmall.left.key == smallest.key){
						//smallest is attached to its parent on the left
						//attach left of the parent to the right of child
						pSmall.left = smallest.right;
					}else {
						//it has to be on the right
						//Attach right of the parent  to the right of smallest
						pSmall.right = smallest.right;
					}
					size--;
					return save;
				}
			}
			else {//The node has to be on the right
				Node<T> child= parent.right;
				if(child.left==null){
					parent.right=parent.right.right;
					size--;
					return child.data;
				}
				else if(child.right==null){
					parent.right=parent.right.left;
					size--;
					return child.data;
				}
				else{///both left and right of child are not null
					///both left and right of child are not null
					//either you replace by the largest on the left
					//or the smallest on the right
					//we chose to the smallest on the right
					Node<T> smallest = child.right;
					Node<T> pSmall = child;
					while(smallest.left != null) {
						//remember the parent
						pSmall = smallest;
						//go left;
						smallest = smallest.left;
					}
					//save the data to return 
					T save = child.data;
					//copy smallest to the node to be removed (child)
					child.key = smallest.key;
					child.data = smallest.data;
					if(pSmall.left!=null && pSmall.left.key == smallest.key){
						//smallest is attached to its parent on the left
						//attach left of the parent to the right of child
			
						pSmall.left = smallest.right;
					}else {
						//it has to be on the right
						//Attach right of the parent  to the right of smallest
						pSmall.right = smallest.right;
					}
					size--;
					return save;				
				}
			}
		}
}