import java.util.*;

public class FrontierQueue implements Frontier{

    Queue<Location> data;

    public FrontierQueue(){
	data = new ArrayDeque<Location>();
    }

    public void add(Location l){
	data.add(l);
    }

    public Location next(){
	return data.remove();
    }
    

}
