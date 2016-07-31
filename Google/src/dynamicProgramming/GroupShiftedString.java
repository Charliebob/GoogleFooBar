package dynamicProgramming;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public class GroupShiftedString {
	public static List<List<String>> groupStrings(String[] strings) {
        
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        
        for(String word : strings){
            String key = "";
            int offset = word.charAt(0) - 'a';
            for(int i = 1; i < word.length(); i++){
                key += (word.charAt(i) - offset) % 26;
            }
            System.out.println(key);
            
            if(!map.containsKey(key)){
                map.put(key, new ArrayList<String>());
            }
            map.get(key).add(word);
        }
        
        for(List<String> list : map.values()){
            Collections.sort(list);
            res.add(list);
        }
        
        return res;
    }
	public static void main(String[] args){
		String[] strings = {"abc","bcd","xyz","gjl"};
		List<List<String>> result = groupStrings(strings);
		for(int i=0; i<result.size(); i++){
			for(int j=0; j<result.get(i).size(); j++){
				System.out.print(result.get(i).get(j)+" ");
			}
			System.out.println(" ");
		}
	}
	
}
