package googleInterview;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
class Interval {
	 int start;
	 int end;
     Interval() { start = 0; end = 0; }
     Interval(int s, int e) { start = s; end = e; }
}

public class MergeIntervals {
	public static int answer(int[][] intervals) { 
        // Your code goes here.
		if(intervals.length==0 || intervals[0].length==0) return 0;
		ArrayList<Interval>input = new ArrayList<Interval>();
		for(int i=0; i<intervals.length;i++){
			Interval interval = new Interval(intervals[i][0],intervals[i][1]);
			input.add(interval);
		}
		List<Interval> result = merge(input);
		int length = 0;
		for(int i=0; i<result.size(); i++){
			length += result.get(i).end - result.get(i).start;
		}
		return length;
    }  
	
	public static List<Interval> merge(List<Interval> intervals) {
	    if (intervals.size() <= 1)
	        return intervals;

	    // Sort by ascending starting point using an anonymous Comparator
	    Collections.sort(intervals, new Comparator<Interval>() {
	        @Override
	        public int compare(Interval i1, Interval i2) {
	            return Integer.compare(i1.start, i2.start);
	        }
	    });

	    List<Interval> result = new LinkedList<Interval>();
	    int start = intervals.get(0).start;
	    int end = intervals.get(0).end;

	    for (Interval interval : intervals) {
	        if (interval.start <= end) // Overlapping intervals, move the end if needed
	            end = Math.max(end, interval.end);
	        else {                     // Disjoint intervals, add the previous one and reset bounds
	            result.add(new Interval(start, end));
	            start = interval.start;
	            end = interval.end;
	        }
	    }

	    // Add the last interval
	    result.add(new Interval(start, end));
	    return result;
	}
	public static void main(String[] args){
		int[][] input = {{10, 14}, {4, 18}, {19, 20}, {19, 20}, {13, 20}};
		System.out.println(answer(input));
	}
}
