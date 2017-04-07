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
	    toAdd.setNext(end);
	}
	else{
	    toAdd.setPrev(end);
	    toAdd.setNext(null);
	    end.setNext(toAdd);
	    //System.out.println (toAdd);
	    end = toAdd;
	}
	size++;
	return true;
    }

    public int get (int index){
	LNode n = getNthNode(index);
	return n.value;
    }

    public int set (int index, int value){
	LNode n = getNthNode(index);
	int oldVal = n.value;
	n.value = value;
	return oldVal;
    }

    private LNode getNthNode(int n){
	LNode current = start;
	for (int pos = 1; pos < n; pos++){
	    current = current.next;
	}
	return current;
    }

    public String toString(){
	String ans = "[";
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
	a.add(4);
	a.add(7);
	System.out.println(a);
    }

    
}
