package dynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class CompressString {
	public static String compressString(String s){
		if(s==null||s.length()<=2) return s;
		int count = 1;
		char last = s.charAt(0);
		StringBuilder result = new StringBuilder();
		for(int i = 1; i < s.length(); i++){
		    if(s.charAt(i) == last){
		    	count++;
		    }else{
		        if(count > 2){
		            result.append(count+"x"+last);
		        }
		        else{
		        	for(int j=0; j<count; j++){
		        		result.append(last);
		        	}
		        }
			    count = 1;
			    last = s.charAt(i);
		    }
		}
		if(count > 2){
            result.append(count+"x"+last);
        }
        else{
        	for(int j=0; j<count; j++){
        		result.append(last);
        	}
        }
		return result.toString();
	}
	public static String decompressString(String s){
		if(s==null || s.length()<=2) return s;
		StringBuilder sb = new StringBuilder();
		Queue<Integer> queue = new LinkedList<Integer>();
		int index = 0;
		while(index<s.length()){
			while(true){
				char c = s.charAt(index);
				if((c-'0')>=0 && (c-'0')<=9){
					queue.add(Integer.parseInt(c+""));
					index++;
					continue;
				}
				break;
			}
			int times = 0;
			while(!queue.isEmpty()){
				times = times*10 + queue.poll();
			}
			
			if(times>0 && s.charAt(index)=='x'){
				char repeat = s.charAt(index+1);
				for(int j=0; j<times; j++){
					sb.append(repeat);
				}
				index=index+2;
				continue;
			}else{
				sb.append(s.charAt(index));
			}
			index++;
		}
		return sb.toString();
	}
	public static void main(String[] args){
		String s = "aabbttt";
		System.out.println(compressString(s));
		System.out.println(decompressString(compressString(s)));
		
	}
}

//int[] nums = new int[10];
//int[] num = new int[nums.length+2];
//int n = 1;
//for(int x: nums) num[n++] = x;
//num[0] = num[n++] = 1;
//System.out.println(n);
