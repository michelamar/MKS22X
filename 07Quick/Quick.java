public class Quick{

    public static int quickselect(int[] data, int k){
	return select(data, k, 0, data.length);
    }

    public static int select(int []data, int k, int low, int high){
	int pivot = Partition.part(data, low, high);
	if (pivot < k){
	    return select(data, k, pivot+1, high);
	}
	else if (pivot > k){
	    return select(data, k, low, pivot);
	}
	else{
	    System.out.println(Partition.stringOf(data));
	    return data[k];
	}
    }

    public static void main(String[]args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(quickselect( ary , 0 ));  //would return 0
	System.out.println("ln");
	System.out.println(quickselect( ary , 1 ));  //would return 2
	System.out.println("ln");
	System.out.println(quickselect( ary , 2 ));  //would return 5
	System.out.println("ln");
	System.out.println(quickselect( ary , 3 ));  //would return 10
	System.out.println("ln");
	System.out.println(quickselect( ary , 4 ));  //would return 15
	System.out.println("ln");
	System.out.println(quickselect( ary , 5 ));  //would return 23



    }

}
