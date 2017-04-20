import java.util.*;

public class MyLinkedList implements Iterable<Integer>{
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
	    end = toAdd;
	}
	else{
	    toAdd.setPrev(end);
	    end.setNext(toAdd);
	    //System.out.println (toAdd);
	    end = toAdd;
	}
	size++;
	return true;
    }

    public int get (int index){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    LNode n = getNthNode(index);
	    return n.value;
	}
    }

    public int set (int index, int value){
	if (index < 0 || index >= size()){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    LNode n = getNthNode(index);
	    int oldVal = n.value;
	    n.value = value;
	    return oldVal;
	}
    }

    public int size(){
	return size;
    }

    private LNode getNthNode(int n){
	if (n<0 || n>=size){
	    throw new IndexOutOfBoundsException("Index out of bounds: " + n);
	}
	else if (n < size/2){
	    LNode current = start;
	    for (int pos = 0; pos < n; pos++){
		current = current.next;
	    }
	    return current;
	}
	else{
	    LNode current = end;
	    for (int pos = size-1; pos > n; pos--){
		current = current.prev;
	    }
	    return current;
	}
    }

    private void addAfter(LNode location, LNode toBeAdded){
	if (location == end) {
	    end.setNext(toBeAdded);
	    toBeAdded.setPrev(end);
	    end = toBeAdded;
	    return;
	}
	toBeAdded.setPrev(location);
	toBeAdded.setNext(location.next);
	location.next.setPrev(toBeAdded);
	location.setNext(toBeAdded);
    }

    public void add(int index,int value){
	if (index < 0 || index > size()){
	    throw new IndexOutOfBoundsException();
	}
	else{
	    LNode toAdd = new LNode(value);
	    if (index == 0){
		start.prev = toAdd;
		toAdd.next = start;
	    }
	    else{
		LNode previous = getNthNode(index-1);
		addAfter(previous, toAdd);
		size++;
	    }
	}
    }

    private void remove(LNode target){
	target.next.setPrev(target.prev);
	target.prev.setNext(target.next);
    }

    public int remove(int index){
	LNode toRemove = getNthNode(index);
	if(index == 0){
	    start.next.setPrev(null);
	    start = start.next;
	}
	else if (index == size-1){
	    end.prev.setNext(null);
	    end = end.prev;
	}
	else{
	    remove(toRemove);
	}
	size--;
	return toRemove.value;
    }

    public int indexOf(int value){
	LNode current = start;
	for(int pos = 0; pos < size; pos++){
	    if(current.value == value){
		return pos;
	    }
	    else{
		current = current.next;
	    }
	}
	return -1;
    }

    public String toString(){
	String ans = "[";
	LNode current = start;
	for (int pos = 0; pos < size; pos++){
	    ans += current.value + ", ";
	    current = current.next;
	}
	if(ans.length() > 2){
	    ans = ans.substring(0, ans.length()-2);
	}
	ans += "]";
	return ans;
    }

    public Iterator<Integer> iterator(){
	MyLinkedListIterator toReturn = new MyLinkedListIterator(this);
	return toReturn;
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

    public class MyLinkedListIterator implements Iterator<Integer>{
	MyLinkedList data;
	LNode current;

	public MyLinkedListIterator(MyLinkedList inputList){
	    data = inputList;
	    current = data.start;
	}

	public boolean hasNext() {
	    return current != null;
	}

	public Integer next(){
	    Integer toReturn = current.value;
	    current = current.next;
	    return toReturn;
	}

	public void remove(){
	    throw new UnsupportedOperationException();
	}
    }
	    

    public static void main(String[]args){
	MyLinkedList a = new MyLinkedList();
	a.add(8);
	a.add(4);
	a.add(7);
	a.add(1, 5);
	System.out.println(a.getNthNode(1));
	System.out.println(a);
	a.remove(1);
	System.out.println(a);
	System.out.println(a.indexOf(8));
	System.out.println(a.indexOf(0));
    }

    
}
