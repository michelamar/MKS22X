public class StackCalc{

    public static int eval (String s){
	tokens = s.split(" ");
	Stack<Double> values = new Stack<Double>;
	for (token:tokens){
	    if (isOperator(token)){
		a = apply(token, values.pop(), values.pop());
		a.push(values);
	    }
	    else{
		push token;
	    }
	}
	return values.pop();
    }

    public boolean isOperator(String a){
	return a.equals("+") || a.equals("-") || a.equals("/") || a.equals("*");
    }

    public boolean 

}
