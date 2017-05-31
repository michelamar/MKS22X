import java.util.Stack;

public class FrontierStack implements Frontier{

    Stack<Location> a;

    public FrontierStack(){
	a = new Stack<Location>();
    }

    public void add(Location l){
	a.push(l);
    }

    public Location next(){
	return a.pop();
    }

}
