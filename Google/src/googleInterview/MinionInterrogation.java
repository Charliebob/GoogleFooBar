package googleInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MinionInterrogation {
	public static int[] answer(int[][] minions) { 

        // Your code goes here.
		int[] result = new int[minions.length];
		if(minions.length==0 || minions[0].length==0) return result;
		int[] indexPermutation = generateArray(minions.length);
		//index permutation
		List<List<Integer>> permutation = permute(indexPermutation);
		int numberOfPermutations = permutation.size();
	
		ArrayList<Double> timeArray = new ArrayList<Double>();
		for(int i=0; i<numberOfPermutations; i++){
			double time = 0.0;
			double multiplexor = 1.0;
			for(int j=0; j<minions.length; j++){
				//The ith permutation, jth index of the minions
				int index = permutation.get(i).get(j);
				time+= minions[index][0]*multiplexor;
				multiplexor*=(minions[index][2]-minions[index][1])/(double)minions[index][2];
			}
			timeArray.add(time);
		}
		int minIndex = timeArray.indexOf(Collections.min(timeArray));
		for(int i=0; i<minions.length; i++){
			result[i] = permutation.get(minIndex).get(i);
		}
		return result;
    } 
	private static List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<List<Integer>>();
	    perm(result,nums,0,nums.length-1);
	    return result;
	}
	private static void perm(List<List<Integer>> result, int[] nums, int start, int end){
	    if(start==end){
	        Integer[] ele = new Integer[nums.length];
	        for(int i=0; i<nums.length; i++){
	            ele[i] = nums[i];
	        }
	        result.add(Arrays.asList(ele));
	    }
	    else{
	        for(int i=start; i<=end; i++){
	            int temp = nums[start];
	            nums[start] = nums[i];
	            nums[i] = temp;

	            perm(result, nums,start+1,end);

	            temp = nums[start];
	            nums[start] = nums[i];
	            nums[i] = temp;
	        }
	    }
    
    }
	private static int[] generateArray(int length){
		//length>=0
		int[] result = new int[length];
		if(length<=0) return result;
		for(int i=0; i<length; i++){
			result[i] = i;
		}
		return result;
	}
	
	public static void main(String[] args){
		int[][] minions = {{390, 185, 624}, {686, 351, 947}, {276, 1023, 1024}, {199, 148, 250}};
		int[] result = answer(minions);
		for(int i: result){
			System.out.print(i+" ");
		}
	}
}
