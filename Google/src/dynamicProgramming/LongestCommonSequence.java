package dynamicProgramming;

import java.util.*;

public class LongestCommonSequence {
	public static int longestCommonSequence(String s1, String s2){
		char[] c1 = s1.toCharArray();
		char[] c2 = s2.toCharArray();
		int[][] dp = new int[s1.length()+1][s2.length()+1];
		int max = 0;
		for(int i=1; i<dp.length; i++){
			for(int j=1; j<dp[i].length; j++){
				if(c1[i-1]==c2[j-1]){
					dp[i][j] = dp[i-1][j-1]+1;
				}else{
					dp[i][j] = Math.max(dp[i][j-1], dp[i-1][j]);
				}
				if(dp[i][j]>max){
					max = dp[i][j];
				}
			}
		}
		return max;
	}
	public static int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int width = obstacleGrid[0].length;
        int[] dp = new int[width];
        dp[0] = 1;
        for (int[] row : obstacleGrid) {
            for (int j = 0; j < width; j++) {
                if (row[j] == 1)
                    dp[j] = 0;
                else if (j > 0)
                    dp[j] += dp[j - 1];
                	System.out.println(dp[j]);
            }
        }
        return dp[width - 1];
    }
	public static int maxEnvelopes(int[][] envelopes) {
        if(envelopes == null || envelopes.length == 0 
           || envelopes[0] == null || envelopes[0].length != 2)
            return 0;
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2){
                if(arr1[0] == arr2[0])
                    return arr2[1] - arr1[1];
                else
                    return arr1[0] - arr2[0];
           } 
        });
        int dp[] = new int[envelopes.length];
        
        int len = 0;
        for(int[] envelope : envelopes){
            int index = Arrays.binarySearch(dp, 0, len, envelope[1]);
            System.out.println(index);
            if(index < 0)
                index = -(index + 1); //not found	
            	System.out.println(index);
            dp[index] = envelope[1];  //insert
            if(index == len)
                len++;
        }
        return len;
    }
	
	public static void main(String[] args){
		String str1 = "abcdghlqr";
		String str2 = "aedphr";
		String test1 = "12";
		System.out.println(longestCommonSequence(str1, str2));
		Integer st = Integer.parseInt(test1.substring(0, 2));
		System.out.println(st);
		int[][] obj = {{0,0,0,0},
					   {0,0,0,0},
					   {0,1,1,0},
					   {0,0,0,0}};
		System.out.println(uniquePathsWithObstacles(obj));
		int[] dp = {0,0,0,3};
		
		int index= Arrays.binarySearch(dp, 0, 4, 4);
		System.out.println(index);
		int[][] test2 = {{5,4},{6,4},{6,7},{2,3}};
		System.out.println(maxEnvelopes(test2));
	}
}
