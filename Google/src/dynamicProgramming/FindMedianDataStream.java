package dynamicProgramming;

import java.util.PriorityQueue;
import java.util.Queue;

public class FindMedianDataStream {
	private static Queue<Long> max = new PriorityQueue(), //maxHeap
							   min = new PriorityQueue(); //minHeap
	static PriorityQueue<Integer> pq = new PriorityQueue<Integer>();
	public static void addNum(int num) {
		min.add((long) num);
		max.add(-min.poll());
		if (min.size() < max.size())
			min.add(-max.poll());
	}
	
	public static double findMedian() {
		return min.size() > max.size()
		   ? min.peek()
		   : (min.peek() - max.peek()) / 2.0;
		}
	public static void main(String[] args){
		pq.add(2);
		pq.add(1);
		pq.add(4);
		pq.add(6);
		pq.add(5);
		pq.add(3);
		System.out.println(-pq.poll());
	}
}
