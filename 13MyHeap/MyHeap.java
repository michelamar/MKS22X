import java.util.NoSuchElementException;

public class MyHeap{

    private int size;
    private int type;
    private String[] data;

    public MyHeap(){
	size = 0;
	type = 1;
    }

    public MyHeap(boolean minMax){
	if (minMax){
	    size = 0;
	    type = 1;
    	}
	else{
	    size = 0;
	    type = -1;
	}
    }

    public void add(String s){
	if(size == data.length){
	    String[] temp = new String[data.length * 2];
	    for(int pos = 0; pos < data.length; pos++){
		temp[pos] = data[pos];
	    }
	    data = temp;
	}
	data[size + 1] = s;
	size++;
	pushUp();
    }

    public String remove(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    String toReturn = data[1];
	    data[1] = data[size];
	    size--;
	    pushDown();
	    return toReturn;
	}
    }

    public String peek(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[1];
	}
    }

    private void pushUp(){
	int pos = size;
	while(pos > 1 && type * (data[pos].compareTo(data[pos/2])) > 0){
	    String temp = data[pos];
	    data[pos] = data[pos/2];
	    data[pos/2] = temp;
	}
    }

    private void pushDown(){
	int pos = 1;
	while(pos < size && type * (data[pos].compareTo(data[pos*2])) < 0){
	    String temp = data[pos];
	    data[pos] = data[pos*2];
	    data[pos*2] = temp;
	}
    }




}
