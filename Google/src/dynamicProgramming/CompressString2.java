package dynamicProgramming;

import java.util.LinkedList;
import java.util.Queue;

public class CompressString2 {
	public static String compressString(String s){
		if(s==null||s.length()<=1) return s;
		int count = 1;
		char last = s.charAt(0);
		StringBuilder result = new StringBuilder();
		for(int i = 1; i < s.length(); i++){
		    if(s.charAt(i) == last){
		    	count++;
		    }else{
		        result.append(count+""+last);
			    count = 1;
			    last = s.charAt(i);
		    }
		}
    	result.append(count+""+last);
		return result.toString();
	}
	public static String decompressString(String s){
		if(s==null || s.length()<=1) return s;
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
			char repeat = s.charAt(index);
			for(int j=0; j<times; j++){
				sb.append(repeat);
			}
			index=index+1;
			continue;
		}
		return sb.toString();
	}
	public static void main(String[] args){
		String s = "aaaaaaaaaaabbc";
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
