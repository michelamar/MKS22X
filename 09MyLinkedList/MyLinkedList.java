public class MyLinkedList{
    int size;
    LNode start;
    LNode end;

    public MyLinkedList(){
	size = 0;
	start = null;
	end = null;
    }

    public boolean add (int value){
	LNode toAdd = new LNode(value);
	if(size == 0){
	    start = toAdd;
	}
	toAdd.setNext(start);
	toAdd.setPrev(null);
	start.setPrev(toAdd);
	//System.out.println (toAdd);
	start = toAdd;
	size++;
	return true;
    }

    public String toString(){
	String ans = "";
	LNode current = start;
	for (int pos = 0; pos < size; pos++){
	    ans += current.value + ", ";
	    current = current.next;
	}
	return ans;
    }
	
	

    public class LNode{
	private int value;
	private LNode next;
	private LNode prev;


	public LNode (int val){
	    value = val;
	}
	
	public void setNext(LNode nextNode){
	    next = nextNode;
	}
	public void setPrev(LNode prevNode){
	    prev = prevNode;
	}

	public String toString(){
	    return "" + value;
	}
	
    }

    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	a.add(8);
	System.out.println(a);
    }

    
}
