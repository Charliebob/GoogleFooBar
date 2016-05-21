package googleInterview;

public class BreedingLikeRabbit {
	public static String answer(String str_S) { 

        // Your code goes here.
		int target = Integer.parseInt(str_S);
		int dp[] = new int[target+1];
		dp[0]=1;
		dp[1]=1;
		dp[2]=2;
		int count = 1;
		for(int i=3; i<target; i++){
			if(2*count+1 == i){
				dp[i] = dp[count-1]+dp[count]+1;
			}else if(2*count==i){
				dp[i] = dp[count]+dp[count+1]+count;
			}
			count++;
			System.out.println(dp[i]);
			if(dp[i]==target) return Integer.toString(i);
		}
		return "NONE";
    } 
	public static void main(String[] args){
		String s = "6";
		System.out.println(answer(s));
	}
}
