import java.util.NoSuchElementException;

public class MyHeap{

    private int size;
    private int type;
    private int[] data = new int[50];

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

    public void add(int s){
	if(size == data.length){
	    int[] temp = new int[data.length * 2];
	    for(int pos = 0; pos < data.length; pos++){
		temp[pos] = data[pos];
	    }
	    data = temp;
	}
	data[size + 1] = s;
	size++;
	pushUp();
    }

    public int remove(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    int toReturn = data[1];
	    data[1] = data[size];
	    size--;
	    pushDown();
	    return toReturn;
	}
    }

    public int peek(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[1];
	}
    }

    private void pushUp(){
	int pos = size;
	while(pos > 1 && (type * data[pos]) < data[pos/2]){
	    int temp = data[pos];
	    data[pos] = data[pos/2];
	    data[pos/2] = temp;
	}
    }

    private void pushDown(){
	int pos = 1;
	while(pos < size && (type * data[pos]) > data[pos*2]){
	    int temp = data[pos];
	    data[pos] = data[pos*2];
	    data[pos*2] = temp;
	}
    }

    public String toString(){
	String toReturn = "[";
        for(int pos = 0; pos <= size; pos++){
	    toReturn += data[pos] + ", ";
	}
	toReturn = toReturn.substring(0, toReturn.length() - 2) + "]";
	return toReturn;
    }

    public static void main(String[]args){
	MyHeap a = new MyHeap();
	a.add(12);
	System.out.println(a);
	a.add(88);
	System.out.println(a);
	a.add(9);
	System.out.println(a);
	a.remove();
	System.out.println(a);
    }




}
