import java.lang.Math;

public class Partition{

    public static int part(int[] data, int start, int end){
	int pivotIndex = start + (int)(Math.random() * (end - start));
	int value = data[pivotIndex];
	int currentIndex = start;
	int lessThan = start;
	int greaterThan = end - 1;
	//	System.out.println (value);
	swap (data, start, pivotIndex);
	while (currentIndex <= greaterThan){
	    if (data[currentIndex] == value){
		currentIndex++;
		//	System.out.println ("current = value");
	    }
	    else if (data[currentIndex] < value){
		//	System.out.println ("current < value");
		swap(data, currentIndex, lessThan);
		currentIndex++;
		lessThan++;
	    }
	    else{
		//System.out.println ("current > value");
		swap(data, currentIndex, greaterThan);
		greaterThan--;
	    }
	}
	
	return (greaterThan);
	    
    }
    
    public static String stringOf(int[] grid){
	String ans = "";
	for (int r = 0; r < grid.length; r++){
		ans += grid[r] +  " ";
	}
	return ans;
    }

    public static void swap (int[] ary, int pos1, int pos2){
	int temp = ary[pos1];
	ary[pos1] = ary[pos2];
	ary[pos2] = temp;
    }



    public static void main(String[]args){
	int[] a = {1, 5, 3, 2, 4, 0, 8, 6, 7};
	System.out.println(part(a, 0, a.length));
	System.out.println(stringOf(a));
    }

}
