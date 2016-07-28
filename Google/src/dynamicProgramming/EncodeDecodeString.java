package dynamicProgramming;

import java.util.LinkedList;
import java.util.List;

public class EncodeDecodeString {
	public static String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String s: strs){
            sb.append(s.length()).append('/').append(s);
        }
        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> result = new LinkedList<String>();
        int index = 0;
        while(index<s.length()){
            int slash = s.indexOf('/',index); //first occurence of '/'
            int size = Integer.valueOf(s.substring(index,slash));
            result.add(s.substring(slash+1, slash+size+1));
            index=slash+size+1;
        }
        return result;
    }
    public static void main(String[] args){
    	List<String> list = new LinkedList<String>();
    	list.add("abc");
    	list.add("de");
    	String code = encode(list);
    	List<String> result = new LinkedList<String>();
    	result = decode(code);
    	for(String s: result){
    		System.out.println(s);
    	}
    }
}
