import java.util.NoSuchElementException;

public class FrontierPriorityQueue implements Frontier{
    private int size;
    private Location[] data = new Location[50];

    public FrontierPriorityQueue(){
	size = 0;
    }


    public void add(Location s){
	if(size == data.length){
	    Location[] temp = new Location[data.length * 2];
	    for(int pos = 0; pos < data.length; pos++){
		temp[pos] = data[pos];
	    }
	    data = temp;
	}
	data[size + 1] = s;
	size++;
	pushUp();
    }


    public Location next(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    Location toReturn = data[1];
	    data[1] = data[size];
	    size--;
	    pushDown();
	    return toReturn;
	}
    }

    public Location peek(){
	if(size == 0){
	    throw new NoSuchElementException();
	}
	else{
	    return data[1];
	}
    }

    private void pushUp(){
	int pos = size;
	while(pos > 1 && data[pos].compareTo(data[pos/2]) < 0){
	    Location temp = data[pos];
	    data[pos] = data[pos/2];
	    data[pos/2] = temp;
	}
    }

    private void pushDown(){
	int pos = 1;
	while(pos < size && data[pos].compareTo(data[pos*2]) > 0){
	    Location temp = data[pos];
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
    
    }


}
