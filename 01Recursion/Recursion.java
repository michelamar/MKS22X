public class Recursion{

    public static String name(){
	return "Marchini,Michela";
    }
    
    public static double sqrt(double n){
	if (n < 0){
	    throw new IllegalArgumentException();
	}
	else{
	    return sqrtGuess(n, 1);
	}
    }

    public static double sqrtGuess(double n, double guess){
	if (n == 0){
	    return 0.0;
	}
	else if (closeEnough(guess*guess, n)){
	    return guess;
	}
	else{
	    return sqrtGuess(n, ( n / guess + guess) / 2);
	}
    }

    public static boolean closeEnough (double n1, double n2){
	double diff = n1 - n2;
	return (diff / n1) <= .0000000000000001 && (diff / n1) >= -.0000000000000001;
    }

    public static void main(String[]args){
	System.out.println(sqrt(0));
    }
		       

}
