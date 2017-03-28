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
	LNode toAdd = new LNode(value, start, null);
	start = toAdd;
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

	public LNode (int val, LNode nextNode, LNode prevNode){
	    value = val;
	    next = nextNode;
	    prev = prevNode;
	}
	
    }

    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	a.add(8);
	System.out.println(a);
    }

    
}
