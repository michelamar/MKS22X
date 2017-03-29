import java.util.Arrays;

public class Merge{

    public static void mergesort (int[] ary){

	if (ary.length <= 1){
	    return;
	}

	else{
	    int[] left = Arrays.copyOfRange(ary, 0, ary.length/2);
	    int[] right = Arrays.copyOfRange(ary, ary.length/2, ary.length);
	    mergesort(left);
	    mergesort(right);
	    merge(left, right, ary);
	}
	
    }

    public static void merge (int[] a, int[] b, int[] destination){
	int posA = 0;
	int posB = 0;
	int posDest = 0;
	while (posDest < destination.length){
	    if (posA >= a.length){
		destination[posDest] = b[posB];
		posB++;
		posDest++;
	    }
	    else if (posB >= b.length){
		destination[posDest] = a[posA];
		posA++;
		posDest++;
	    }
	    else if (a[posA] <= b[posB]){
		destination[posDest] = a[posA];
		posA++;
		posDest++;
	    }
	    else{
		destination[posDest] = b[posB];
		posB++;
		posDest++;
	    }
	}
    }

    public static String stringOf(int[] grid){
	String ans = "";
	for (int r = 0; r < grid.length; r++){
		ans += grid[r] +  " ";
	}
	return ans;
    }

    public static void main(String[]args){
	int[] a = {};
	mergesort(a);
	System.out.println(stringOf(a));
    }

}
