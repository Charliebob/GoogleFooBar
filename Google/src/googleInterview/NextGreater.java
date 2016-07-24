package googleInterview;

import java.util.Stack;

public class NextGreater {
	public static int[] nextGreaterElement(int[] nums) {
        if (nums == null || nums.length <= 1) return new int[]{};
        int n = nums.length;
        int[] indexes = new int[n];
        Stack<Integer> stack = new Stack<Integer>();
        stack.push(0);
        for (int i = 1; i < n; i++) {
            if (nums[i] <= nums[stack.peek()]) {
                stack.push(i);
            }
            else {
                while (!stack.isEmpty() && nums[i] > nums[stack.peek()]) {
                    indexes[stack.pop()] = i;
                }
                stack.push(i);
            }
        }
        while (!stack.isEmpty()) {
            indexes[stack.pop()] = -1;
        }
        return indexes;
    }
    
    public static void main(String[] args) {
       // int[] nums = {3,2,5,1,6,4};
        int[] nums = {13, 7, 6, 12};
        int[] indexes = nextGreaterElement(nums);
        for (int d : indexes) {
            System.out.print(d + " ");
        }            
    }
}
