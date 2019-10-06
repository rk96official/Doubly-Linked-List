
public class DLList <T> {
		//define a private class Node, the node has to be generic
		private class Node<T>{
			T data;
			Node next;
			Node prev;
			//default constructor set both to null
			Node(){
				data = null;
				next = null;
				prev=null;
			}
			//constructor that accepts the data and next to null
			Node(T a){
				data = a;
				next = null;
				prev = null;
			}
			//constructor that accepts both 
			Node(T a, Node b){
				data = a;
				next = b;
				prev = null;
			}
			//accessors and setters.
			void setdata(T a) {
				data = a;
			}
			T getdata() {
				return data;
			}
			void setnext(Node a) {
				next=a;
			}
			Node getnext() {
				return next;
			}
			void setprev(Node a) {
				prev = a;
			}
			Node getprev() {
				return prev;
			}
		}
		//For our list, we need head tail and size 
		private Node Head, Tail;
		private int size;
		//default constructor for ourList. Head and Tail to null size to 0
		DLList(){
			Head=Tail=null;
			size=0;
		}
		//accessor for size only. No setters for head and tail, nor getters
		int getsize() {
			return size;
		}
		//public isEmpty(): returns true if the list is empty, false otherwise
		public boolean isEmpty() {
			return (size==0);
		}
		//public void addFront(T e): creates a node, with e data and inserts 
		//the node at the head
		public void addfront(T e) {
			Node node = new Node(e);
			if (isEmpty()) {
				Head=Tail=node;
				size=1;
			}else {
				node.next=Head;
				Head.prev= node;
				Head=node;
				size++;
			}
		}
		//public void addBack(T e): creates a node, with data e and inserts 
		//the node at the tail
		public void addBack(T e) {
			Node node = new Node(e);
			if (isEmpty()) {
				Head=Tail=node;
				size=1;
			}else {		
				node.prev=Tail;
				Tail.next=node;
				Tail=node;
				size++;
			}
		}
		//public void add(T e, int index): creates a node, with data e and inserts 
		//the node at the specified index
		public void add(T e, int index) {
			if (index<0 || index>size) {
				System.out.println("Invalid index");
				return;
			}else if(index ==0)
				addfront(e);
			else if (index ==size) 
				addBack(e);
			else {
				Node node = new Node(e);
				Node temp = Head;
				for (int i=0; i<index-1; i++) {
					temp = temp.next;
				}
				node.next = temp.next;
				node.prev=temp;
				temp.next.prev=node;
				temp.next =node;
				size++;
			}
		}
		//public T removeFront(): removes front (head) from the list and returns the data
		public T removeFront() {
			if (isEmpty()) {
				return null;
			}
			T save = (T)Head.data;
			Head=Head.next;
			if (Head != null){
				Head.prev=null;
			}
			size--;
			if(size==0) {
				Head = null;
				Tail=null;
			}	
			return save;
		}
		//public T removeBack(): removes back (tail) from the list and returns the data
		public T removeBack() {
			if (isEmpty()) {
				return null;
			}
			T save = (T)Tail.data;
			if (size==1) {
				size=0;
				Head=Tail=null;
				return save;
			}
			//Tail=Tail.prev;
			Tail.prev.next=null;
			size--;
			return save;
		}
		//public T remove(int index): removes the node at specified index
		//from the list and returns the data
		T remove(int index) {
			if (isEmpty() || index<0 || index >size-1) {
				return null;
			}else if (index == 0) {
				return removeFront();
			}else if (index == size-1) {
				return removeBack();
			}
			Node temp = Head;
			for (int i =0; i<index-1; i++) {
				temp=temp.next;
			}
			T save = (T)temp.next.data;
			temp.next=temp.next.next;
			temp.next.prev=temp;
			size--;
			return save;
		}
		
		//String toString() returns the list as a string to be displayed
		public String toString() {
			if (Head == null)
				return "[]";
			Node temp = Head;
			String st = "[";
			while (temp.next != null) {
				st = st+ temp.data + ", ";
				temp = temp.next;
			}
			if(temp!= null)
				st = st+ temp.data + "]";
			else 
				st = st + "]";
			return st;
		}
}
