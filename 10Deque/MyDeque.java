import java.util.*;

public class MyDeque{

    private String[] data = new String[16];
    int size = 0;
    int front = 0;
    int back = 0;

    public void addFirst(String toAdd){
	if (toAdd == null){
	    throw new NullPointerException();
	}
	else if (size == data.length){
	    String[] temp = new String[data.length * 2];
	    for (int pos = 0; pos < data.length; pos++){
		temp[pos] = data[pos];
	    }
	}
	if (size == 0){
	    data[0] = toAdd;
	    size++;
	}
	else if (front == 0){
	    data[data.length-1] = toAdd;
	    front = data.length - 1;
	    size++;
	}
	else{
	    data[front-1] = toAdd;
	    front--;
	    size++;
	}
    }

    public void addLast(String toAdd){
	if (toAdd == null){
	    throw new NullPointerException();
	}
	else if (size == data.length){
	    String[] temp = new String[data.length * 2];
	    for (int pos = 0; pos < data.length; pos++){
		temp[pos] = data[pos];
	    }
	}
	if (size == 0){
	    data[0] = toAdd;
	    size++;
	}
	else if (back == data.length-1){
	    data[0] = toAdd;
	    back = 0;
	    size++;
	}
	else{
	    data[back+1] = toAdd;
	    back++;
	    size++;
	}
    }

    public String removeFirst(){
	if (size == 0){
	    throw new  NoSuchElementException();
	}
	else if (front == data.length-1){
	    String toReturn = data[front];
	    data[front] = null;
	    front = 0;
	    size--;
	    return toReturn;
	}
	else{
	    String toReturn = data[front];
	    data[front] = null;
	    front++;
	    size--;
	    return toReturn;
	}
    }

    public String removeLast(){
	if (size == 0){
	    throw new  NoSuchElementException();
	}
	else if (back == 0){
	    String toReturn = data[back];
	    data[back] = null;
	    back = data.length - 1;
	    size--;
	    return toReturn;
	}
	else{
	    String toReturn = data[back];
	    data[back] = null;
	    back--;
	    size--;
	    return toReturn;
	}
    }

    public String getFirst(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[front];
	}
    }
    
    public String getLast(){
	if (size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[back];
	}
    }

    public int size(){
	return size;
    }
    
    public String toString(){
	String toReturn = "[";
	int count = 0;
	for(int pos = front; count < size; pos++){
	    toReturn += data[pos] + ", ";
	    count++;
	    if(pos == data.length-1){
		pos = 0;
	    }
	}
	toReturn = toReturn.substring(0, toReturn.length() - 2);
	toReturn += "]";	
	return toReturn;
    }

    public static void main(String[]args){
	MyDeque md = new MyDeque();
	for(int i = 0; i<20; md.addFirst("apple")) {i++;}
	System.out.println(md + " size: " + md.size());
	for (int i=0; i<100; md.addLast(md.removeFirst())) {i++;}
	System.out.println(md + " size: " + md.size());
	while (true)
	    try {
		md.removeFirst();
		md.removeLast();
	    } catch (NoSuchElementException e) {
		break;
	    }
	md.addFirst("banana");
	for (int i=0; i<16; md.addFirst(md.getFirst() + "na")) {i++;}
	System.out.println(md + " size: " + md.size());
	for (int i=0; i<8; md.addLast(md.getLast() + "na")) {i++;}
	System.out.println(md + " size: " + md.size());
    }
    
}
