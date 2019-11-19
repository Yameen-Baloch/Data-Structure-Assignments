import java.util.*;

interface Stacks{
	public void push(Object obj);
	public Object pop();
}

class ArrayStacks implements Stacks{
	private Object arr[];
	private int size;

	public ArrayStacks(int capacity){
		arr = new Object[capacity];
	}

	// pushing new Element...
	public void push(Object obj){
		if(size == arr.length){
			resize();
		}
		arr[size++] = obj;
	}

	//resizing an array...
	public void resize(){
	Object[] aa = arr;
	arr = new Object[2*aa.length];
	System.arraycopy(aa, 0, arr, 0, size);
	}


	//deletes array element from the end of an array
	public Object pop(){
		if(size == 0)
			throw new IllegalStateException("Stack is empty");
		Object obj = arr[--size];
		arr[size] = null;
		return obj;
	}

	//method for to convert all elements in string
	//toString method in ArrayStack
	public String toString(){
		String str = "";
		for(int i = 0; i < size; i++){
			str += arr[i];
		}
		return str;
	}

	// method for display all elements in ArrayStack
	
	public void display(){
		for(int i = 0; i < size; i++){
			System.out.print(arr[i]);
			if(i < size-1){
				System.out.print(",");
			}
		}
	}
}

class main{
	public static void main(String[] args) {
		ArrayStacks as = new ArrayStacks(10);
		as.push("Hello");
		as.push("world");
		System.out.println(as.toString());

		as.display();
	}
}