package dynamicProgramming;

public class ThreeLarge {
	public static boolean hasSuch(int[] nums){
		if(nums==null || nums.length==0) return false;
		int start = 0;
		int end = nums.length-1;
		while(start<end){
			for(int i=start+1; i<=end-1; i++){
				if(nums[start]<=nums[i] && nums[i]<=nums[end]){
					return true;
				}
			}
			start++;
			end--;
		}
		return false;
	}
	public static boolean hasSuch2(int[] nums){
		int small = Integer.MAX_VALUE;
		int big = Integer.MIN_VALUE;
		for(int n: nums){
			if(n<=small) small = n;
			else if(n<=big) big = n;
			else return true;
		}
		return false;
	}
	public static void main(String[] args){
		int[] nums = {3,2,1,4,7,8};
		System.out.println(hasSuch2(nums));
	}
}
