package dynamicProgramming;

public class MinModifyPalindrome {
	public static int minStepModifyPalindrome(String s){
		String t = reverse(s);
		int[][] dp = new int[s.length()+1][s.length()+1];
		for(int i=0; i<=s.length(); i++){
			dp[0][i] = 0;
		}
		for(int i=0; i<=s.length(); i++){
			dp[i][0] = 0;
		}
		for(int i=1; i<=s.length(); i++){
			for(int j=1; j<=t.length(); j++){
				if(s.charAt(i-1)==t.charAt(j-1)){
					dp[i][j] = dp[i-1][j-1] + 1;
				}else{
					dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		return s.length() - dp[s.length()][s.length()];
	}
	private static String reverse(String s){
		char[] word = s.toCharArray();
		int start = 0;
		int end = s.length()-1;
		while(start<end){
			char temp = word[start];
			word[start] = word[end];
			word[end] = temp;
			start++;
			end--;
		}
		return new String(word);
	}
//	public static void main(String[] args){
//		String s = "SARGAM";
//		System.out.println(minStepModifyPalindrome(s));
//	}
	
}


