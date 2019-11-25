class QueueList implements QueueInterface{

	private Node head = new Node(null);
	private int size;

	public class Node{
		Object obj;
		Node prev = this;
		Node next = this;
	

	public Node(Object obj, Node prev, Node next){
		this.obj = obj;
		this.prev = prev;
		this.next = next;
	}

	public Node(Object obj){
		this.obj = obj;
	}
}

	// method for adding new Element
	public void add(Object obj){
		head.prev.next = new Node(obj, head.prev, head);
		head.prev = head.prev.next;
		size++;
	}


	//Remove an element from Queue
	public Object remove(){
		Object obj = head.next;
		head.next = head.next.next;
		--size;
		return obj;
	}


	// Returning first element of queue
	public Object first(){
		return head.next;
	}


	//Size of queue
	public int size(){
		return size;
	}

	//Convert Queue into an Array
	public void toArray(){
		Object a[] = new Object[size];
		int i = 0;
		Node temp = head.next;
		while(temp != head.prev.next){
			a[i] = temp.obj;
			temp = temp.next;
			i++;
		}

		// for printing array
		for(int j = 0; j < size; j++){
			if(j == 0){
				System.out.print("[");
			}
			System.out.print(a[j]);
			if(j < size-1){
				System.out.print(",");
			}
			if(j == size-1){
				System.out.print("]");
			}
		}
			System.out.println();

	}


		// toString method
		public String toString(){
			String str = "";
			Node temp = head.next;
			while(temp != head.prev.next){
				str += temp.obj;
				temp = temp.next;
			}
			return str;
		}


		// method for returning second element
		public Object second(){
			return head.next.next.obj;
		}

		//method for returning SecondLast element in the Queue
		public Object secondLast(){
			Node temp = head.next;
			while(temp.next != head.prev){
				temp = temp.next;
			}
			return temp.obj;
		}
	

	// for printing queue;
	public void printQ(){
		Node temp = head.next;
		while(temp != head.prev.next){
			System.out.println(temp.obj);
			temp = temp.next;
		}
	}

}

class QClass{
	public static void main(String[] args) {
		QueueList q = new QueueList();
		q.add(10);
		q.add(20);
		q.add(30);
		q.add(40);
		q.add(50);
		q.add(60);
		//q.remove();
		q.printQ();
		System.out.println("After Converting into An Array");
		q.toArray();
		System.out.println("After Converting into String "+q.toString());
		System.out.println("Second element of the Queue is "+q.second());
		System.out.println("Second Last Element of the Queue is: "+q.secondLast());
		
		
	}
}