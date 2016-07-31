package dynamicProgramming;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class KZigzag {
	LinkedList<Iterator> list;
	public KZigzag(List<List<Integer>> v){
		list = new LinkedList<Iterator>();
		for(int i=0; i<v.size(); i++){
			if(!v.get(i).isEmpty()) list.add(v.get(i).iterator());
		}
	}
	public int next(){
		Iterator poll = list.remove();
		int result = (Integer)poll.next();
		if(poll.hasNext()) list.add(poll);
		return result;
	}
	public boolean hasNext(){
		return !list.isEmpty();
	}
}
