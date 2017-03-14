import java.util.ArrayList;

public class Quiz2Redux{

    public static ArrayList<String> combinations(String s){
	ArrayList<String> words = new ArrayList<String>();
	combinationH(s, words, 0);
	return words;
    }

    public static void combinationH(String s, ArrayList<String> words, int start){
	if (start >= s.length()){
	    return;
	}
	else{
	    if (start == 0){
		words.add("");
	    }

	    int originalSize = words.size();
	    for (int pos = 0; pos < originalSize; pos++){
		words.add(words.get(pos) + s.charAt(start));
	    }

	    combinationH(s, words, start+1);
	}	
    }

    public static void main(String[]args){
	System.out.println(combinations("wxof"));
    }
}
