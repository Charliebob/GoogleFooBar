package dynamicProgramming;

public class PopularElement {
	public static int popularElement(int[] nums){
		if(nums==null || nums.length==0) return -1;
		for(int i=0; i<4; i++){
			int[] result = searchRange(nums, 0, nums.length-1, nums[i*nums.length/4]);
			if(result[1]-result[0]>=nums.length/4) 
				return nums[i*nums.length/4];
		}
		return -1;
	
	}
	private static int[] searchRange(int[] A, int l, int r, int target){
        int[] result = new int[] {-1, -1};
        while(l<=r){
            int mid = (l+r)/2;
            if(A[mid] < target){
                l=mid+1;
            }else if(A[mid] > target){
                r = mid -1;
            }else{
                int[] left = searchRange(A, l, mid -1, target);
                result[0] = left[0] == -1 ? mid: left[0]; 
                int[] right = searchRange(A, mid+1, r, target);
                result[1] = right[1] == -1 ? mid: right[1];
                break;
            }
        }
        return result;
    }
	public static void main(String[] args){
		int[] nums = {1,1,1,2,3,4,5,6,7,7};
		System.out.println(popularElement(nums));
	}
}
