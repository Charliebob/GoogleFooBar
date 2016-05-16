package googleInterview;

import java.util.Arrays;


class Pair implements Comparable<Pair> {
    public final int index;
    public final double value;
    public final int time;

    public Pair(int index, double value, int time) {
        this.index = index;
        this.value = value;
        this.time = time;
    }

    @Override
    public int compareTo(Pair other) {
    	if(Double.valueOf(this.value).compareTo(other.value)==0){
    		return Integer.valueOf(this.time).compareTo(other.time);
    	}
        return Double.valueOf(this.value).compareTo(other.value);
    }
}
public class MinionInterrogation2 {
	public static int[] answer(int[][] minions) { 

        // Your code goes here.
		int[] result = new int[minions.length];
		if(minions.length==0 || minions[0].length==0) return result;
		
		double[] timeExp = new double[minions.length];
		Pair[] indexTime = new Pair[minions.length];
		
		for(int i=0; i<minions.length; i++){
			timeExp[i] = minions[i][0]*minions[i][2]/minions[i][1];
			indexTime[i] = new Pair(i, timeExp[i], minions[i][0]);
		}
		Arrays.sort(indexTime);
		for(int i=0; i<minions.length; i++){
			result[i]=indexTime[i].index;
		}
		return result;	
	}
	public static void main(String[] args){
		int[][] minions = {{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20}
		,{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20}
		,{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20}
		,{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20}
		,{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {1,1,20},{1,1,20}, {2,1,20}};
		int[] result = answer(minions);
		for(int i: result){
			System.out.print(i+" ");
		}
	}
}
