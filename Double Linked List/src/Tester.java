
public class Tester {
	public static void main(String[] args){
		//create a list 
		DLList<Integer> obj = new DLList<Integer>();
		//display it
		System.out.println(obj.toString());
		//insert at the back -2, -11, -9
		obj.addBack(-2);
		obj.addBack(-11);
		obj.addBack(-9);
		//display the list 
		System.out.println(obj.toString());
		//insert -23 at the front 
		obj.addfront(-23);
		//display the list 
		System.out.println(obj.toString());
		//insert -35 at the back 
		obj.addBack(-35);
		//display the list 
		System.out.println(obj.toString());
		//insert -95 at index 3
		obj.add(-95,3);
		//display the list
		System.out.println(obj.toString());
		
		System.out.println(obj.removeFront());
		System.out.println(obj.toString());
		int val=obj.removeBack();
		System.out.println(val);
		System.out.println(obj.toString());
		Integer num=obj.remove(5);
		System.out.println(num);
		System.out.println(obj.toString());
		 num=obj.remove(2);
		System.out.println(num);
		System.out.println(obj.toString());
		num=obj.remove(1);
		System.out.println(num);
		System.out.println(obj.toString());
		
		
	}
}