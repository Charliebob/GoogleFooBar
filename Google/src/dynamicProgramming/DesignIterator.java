package dynamicProgramming;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class DesignIterator {
	public static String designIterator(List<Integer> list){
		Iterator it = list.iterator();
		StringBuilder sb = new StringBuilder();
		while(it.hasNext()){
			int times = (Integer)it.next();
			int nums = (Integer)it.next();
			for(int i=0; i<times; i++){
				sb.append(nums+"");
			}
		}
		return sb.toString();
	}
	public static void main(String[] args){
		List<Integer> list = new ArrayList<Integer>();
		list.add(1);
		list.add(9);
		list.add(2);
		list.add(3);
		list.add(4);
		//list.add(5);
		System.out.println(designIterator(list));
	}
}
