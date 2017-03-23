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

    public static int[] quicksort (int[] data){
	return quicksortHelper(data, 0, data.length);
    }

    public static int[] quicksortHelper(int[] data, int start, int end){
	int pivotIndex = start + (int)(Math.random() * (end - start));
	int value = data[pivotIndex];
	int currentIndex = 1;
	int lessThan = 0;
	int greaterThan = end - start - 1;
	swap (data, 0, pivotIndex);
	while (currentIndex < greaterThan){
	    if (data[currentIndex] == value){
		currentIndex++;
	    }
	    else if (data[currentIndex] < value){
		swap(data, currentIndex, lessThan);
		currentIndex++;
		lessThan++;
	    }
	    else{
		swap(data, currentIndex, greaterThan);
	    }
	}

	quicksortHelper(data, start, lessThan);
	quicksortHelper(data, greaterThan, end);
	
	return data;

    }

    public static void swap (int[] ary, int pos1, int pos2){
	int temp = ary[pos1];
	ary[pos1] = ary[pos2];
	ary[pos2] = temp;
    }

    public static String stringOf(int[] grid){
	String ans = "";
	for (int r = 0; r < grid.length; r++){
		ans += grid[r] +  " ";
	}
	return ans;
    }

    public static void main(String[]args){
	int[]ary = { 2, 10, 15, 23, 0,  5};
	System.out.println(stringOf(quicksort(ary)));
	// System.out.println(quickselect( ary , 0 ));  //would return 0
	// System.out.println("ln");
	// System.out.println(quickselect( ary , 1 ));  //would return 2
	// System.out.println("ln");
	// System.out.println(quickselect( ary , 2 ));  //would return 5
	// System.out.println("ln");
	// System.out.println(quickselect( ary , 3 ));  //would return 10
	// System.out.println("ln");
	// System.out.println(quickselect( ary , 4 ));  //would return 15
	// System.out.println("ln");
	// System.out.println(quickselect( ary , 5 ));  //would return 23



    }

}
