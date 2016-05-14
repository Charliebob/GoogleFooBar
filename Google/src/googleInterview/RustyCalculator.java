package googleInterview; 
import java.util.*;

public class RustyCalculator {  
    private enum Operator{
        //Define Additon Precedence as 1
        //Define Multiply Precedence as 2
        ADD(1), MULTIPLY(2);
        //Multiply precedence is higher than addition
        final int precedence;
        //Constructor
        Operator(int p){
            precedence = p;
        }
    }
    @SuppressWarnings("serial")
	private static Map<Character, Operator> operator = new HashMap<Character, Operator>(){{
        put('+',Operator.ADD);
        put('*',Operator.MULTIPLY);
    }};
    private static boolean isHigherPrecedence(Character op, Character sub){
        return (operator.containsKey(sub) && operator.get(sub).precedence > operator.get(op).precedence);
    }
    public static String answer(String str) { 
        // Your code goes here.
        //seperate the string into a char array
        char[] chars = str.toCharArray();
        //stack saves operators
        Stack<Character> stack = new Stack<Character>();
        //stringbuilder save the result
        StringBuilder result = new StringBuilder();
        //loop the char array
        for(int i=0; i<chars.length; i++){
            //if the character is in the operator
            if(operator.containsKey(chars[i])){
                while(!stack.isEmpty() && isHigherPrecedence(chars[i], stack.peek())){
                    result.append(stack.pop());
                }
                //the stack is empty
                stack.push(chars[i]);
            }else{ //if is digits
                result.append(chars[i]);
            }
        }//is the stack still got some operators left append to the end of the string
        while(!stack.isEmpty()){
            result.append(stack.pop());
        }
        //return result;
        return result.toString();
    } 
    public static void main(String[] args){
    	String s = "2*4*3+9*3+5";
    	System.out.println(answer(s));
    }
}
