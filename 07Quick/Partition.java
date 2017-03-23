import java.lang.Math;

public class Partition{

    public static int part(int[] data, int start, int end){
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
	
	return (greaterThan - lessThan) / 2;
	    
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
	int[] a = {100, 0, 0, 0, 1, 2, 3, 5, 9, 6, 52, 4, 33};
	System.out.println(part(a, 6, a.length));
	System.out.println(stringOf(a));
    }

}
