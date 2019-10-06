public class Tester {
public static void main(String[] args) {
	bTree<Double> myTree = new bTree<Double>();
	//insert keys and data 
	myTree.insert(25, -27.3);
	myTree.insert(15, -25.3);
	myTree.insert(8, -25.3);
	myTree.insert(17, -25.3);
	myTree.insert(19, -25.3);
	myTree.insert(16, -24.3);
	myTree.insert(3, -24.3);
	myTree.insert(35, -26.3);
	myTree.insert(40, -24.3);
	myTree.insert(37, -27.3);
	myTree.insert(28, -256.3);
	myTree.insert(4, -26.3);
	myTree.insert(27, -23.3);
	myTree.insert(20, -234.3);
	myTree.insert(23, -22.3);
	System.out.println("--------------InOrder--------------");
	myTree.InOrderTraversal();
	System.out.println();
	System.out.println("--------------PreOrder--------------");
	myTree.PreOrderTraversal();
	System.out.println();
	System.out.println("--------------PostOrder--------------");
	myTree.PostOrderTraversal();
	double data=myTree.remove(8);
	System.out.println();
	System.out.println("--------------After removing "+data+"--------------");
	myTree.InOrderTraversal();
	data=myTree.remove(23);
	System.out.println();
	System.out.println("--------------After removing "+data+"--------------");
	myTree.InOrderTraversal();
	data=myTree.remove(15);
	System.out.println();
	System.out.println("--------------After removing "+data+"--------------");
	myTree.InOrderTraversal();
	data=myTree.remove(25);
	System.out.println();
	System.out.println("--------------After removing "+data+"--------------");
	//display using preOrder
	myTree.PreOrderTraversal();
}
}