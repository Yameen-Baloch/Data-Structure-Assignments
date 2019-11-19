interface Stack{
	public void push(Object obj); // add element at first index
	public Object pop(); // removes first element
	public Object peek();// returns first element
	
	public Boolean isEmpty(); // return true if stack is empty
}

class LinkedStack implements Stack{

	public class Node{
		Object object;
		Node next;
	}

	Node start;

	public LinkedStack(){
		start = null;
	}

	// methd for adding new Node to Stack;
	public void push(Object obj){
		Node temp = new Node();
		temp.object = obj;
		temp.next = start;
		start = temp;
	}

	// method that checks if Node is not empty;
	public Boolean isEmpty(){
		return start == null;
	}

	// method for returning first element of the stack;

	public Object peek(){
		if(isEmpty())
			throw new IllegalStateException("Stack is empty");
		return start.object;
	}

	
	// method for removing first element of the stack
	public Object pop(){
		if(isEmpty()){
			throw new IllegalStateException("Stack is empty");
		}

		start = start.next;

		return start;
	}

	//method for converting LinkedStack to String

	public String toString(){
		String str = "";

		Node p = start;
		while(p != null){
			str += p.object;
			p = p.next;
		}
		return str;
	}


	// method for display
	public void display(){
		if(start == null){
			throw new IllegalStateException("Stack is empty");
		}

		Node temp = start;
		while( temp != null){
			System.out.print(temp.object+",");
			temp = temp.next;
		}
	}
}

class Test{
	public static void main(String[] args) {
		LinkedStack link = new LinkedStack();

		link.push("Hello");
		link.push("World");
		link.display();

		System.out.println("Head of the Stack is: "+link.peek());

		System.out.println("After in converting into String");
		System.out.println(link.toString());
	}
}

