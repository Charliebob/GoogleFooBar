package dynamicProgramming;

import java.util.LinkedList;
import java.util.Stack;

public class DecompressString {
	public static String decompressString(String s){
		if(s==null || s.length()==0) return s;
		Stack<Character> stack = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i)!=']'){
				stack.push(s.charAt(i));
			}else{
				StringBuilder sb = new StringBuilder();
				char c = stack.pop();
				while(c!='['){
					sb.append(c);
					c = stack.pop(); //
				}
				String temp = sb.reverse().toString();
				int times = 0;
				int base = 1;
				while(!stack.isEmpty() && stack.peek()-'0'>=0 && stack.peek()-'0'<=9){
					times += (stack.pop()-'0')*base;
					base*=10;
				}
				if(times==0) times = 1;
				for(int j=0; j<times; j++){
					for(int k=0; k<temp.length(); k++){
						stack.push(temp.charAt(k));
					}
				}
				
			}
		}
		StringBuilder word = new StringBuilder();
		while(!stack.isEmpty()){
			word.append(stack.pop());
		}
		return word.reverse().toString();
	}
	public static void main(String[] args){
		String s = "3[[2[[pk]2[ab]]]jk]";
		System.out.println(decompressString(s));
	}
}
