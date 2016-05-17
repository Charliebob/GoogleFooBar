package googleInterview;

import java.util.ArrayList;
import java.util.Collections;

public class StringCleaning {  
    public static String answer(String chunk, String word) { 

        // Your code goes here.
    	if(chunk==null || chunk.length()==0 ||chunk.length()<word.length()) return null;
        if(word==null || word.length()==0) return chunk;
    	ArrayList<String> string = new ArrayList<String>();
    	
    	
		String result = "";
		if(chunk.substring(0).startsWith(word)){
			result = chunk.replace(word, "");
			string.add(result);
			//System.out.println(string.get(0));
			result = "";
			//System.out.println(result);
			result = chunk.substring(0, word.length()-1) + chunk.substring(word.length()-1).replace(word, "");
			string.add(result);
			//System.out.println(string.get(1));
		}else{
			result = chunk.replace(word, "");
			string.add(result);
		}
    	Collections.sort(string);
    	String res = string.get(0);
    	return res;

    } 
    public static void main(String[] args){
    	String chunk = "l";
    	String word = "";
    	String result = answer(chunk, word);
    	System.out.println(result);
    }

}



//Test cases
//==========
//
//Inputs:
//    (string) chunk = "lololololo"
//    (string) word = "lol"
//Output:
//    (string) "looo"
//
//Inputs:
//    (string) chunk = "goodgooogoogfogoood"
//    (string) word = "goo"
//Output:
//    (string) "dogfood"