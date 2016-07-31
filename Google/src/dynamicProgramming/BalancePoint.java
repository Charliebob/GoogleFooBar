package dynamicProgramming;

public class BalancePoint {
	public static int balancePoint(int[] nums){
		int[] leftSum = new int[nums.length];
		int[] rightSum = new int[nums.length];
		leftSum[0] = nums[0];
		for(int i=1; i<nums.length; i++){
			leftSum[i] = leftSum[i-1] + nums[i];
		}
		rightSum[nums.length-1] = nums[nums.length-1];
		for(int i=nums.length-2; i>=0; i--){
			rightSum[i] = rightSum[i+1] + nums[i];
		}
		for(int i=0; i<leftSum.length; i++){
			if(leftSum[i]==rightSum[i]) return i;
		}
		return -1;
	}
	public static void main(String[] args){
		int[] nums={1,2,3,4,5,4,3,2,1};
		System.out.println(balancePoint(nums));
	}
}
