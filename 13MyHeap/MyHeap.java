public class MyHeap{

    private int size;
    private int type;
    private int[] data;

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


}
