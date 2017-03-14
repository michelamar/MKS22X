import java.lang.Math;

public class Partition{

    public static int part(int[] data, int start, int end){
	int pivotIndex = start + (int)(Math.random() * (end - start));
	System.out.println(data[pivotIndex]);
	int smallEnd = 0;
	int bigEnd = end - start - 1;
	int[] tempArray = new int[end - start]; 
	for(int pos = start; pos < end; pos++){
	    if(data[pos] < data[pivotIndex]){
		tempArray[smallEnd] = data[pos];
		smallEnd++;
	    }
	    else if(data[pos] > data[pivotIndex]){
		tempArray[bigEnd] = data[pos];
		bigEnd--;
	    }
	}
	tempArray[smallEnd] = data[pivotIndex];
	
	for(int pos = start, tempPos = 0; pos < end; pos++, tempPos++){
	    data[pos] = tempArray[tempPos];
	}
	
	return smallEnd+start;
	    
    }
    
    public static String stringOf(int[] grid){
	String ans = "";
	for (int r = 0; r < grid.length; r++){
		ans += grid[r] +  " ";
	}
	return ans;
    }



    public static void main(String[]args){
	int[] a = {100, 0, 0, 0, 1, 2, 3, 5, 9, 6, 52, 4, 33};
	part(a, 6, a.length);
	System.out.println(stringOf(a));
    }

}
