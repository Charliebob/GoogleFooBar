package googleInterview;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindStrobogrammatic1_N {
	public static List<String> findStrobogrammatic(int n) {
		List<String> result = new ArrayList<String>();
		for(int i=1; i<=n; i++){
			result.addAll(helper(i,i));
		}
        return result;
    }
    private static List<String> helper(int n, int m){
        if(n==0) return new ArrayList<String>(Arrays.asList(""));
        if(n==1) return new ArrayList<String>(Arrays.asList("0","1","8"));
        List<String> list = helper(n-2, m);
        //System.out.println(n +" " + m);
        List<String> res = new ArrayList<String>();
        for(int i=0; i<list.size(); i++){
            String s= list.get(i);
            
            if(n!=m) res.add("0"+s+"0");
            res.add("1"+s+"1");
            res.add("6"+s+"9");
            res.add("8"+s+"8");
            res.add("9"+s+"6");
            
            
        }
//        for(String s: list){
//        	System.out.println(s);
//        }
        return res;
    }
    
    public static void nextPermutation(int[] A) {
        if(A == null || A.length <= 1) return;
        int i = A.length - 2;
        while(i >= 0 && A[i] >= A[i + 1]) i--; // Find 1st id i that breaks descending order
        if(i >= 0) {                           // If not entirely descending
            int j = A.length - 1;              // Start from the end
            while(A[j] <= A[i]) j--;           // Find rightmost first larger id j
            swap(A, i, j);                     // Switch i and j
        }
        reverse(A, i + 1, A.length - 1);       // Reverse the descending sequence
    }

    public static void swap(int[] A, int i, int j) {
        int tmp = A[i];
        A[i] = A[j];
        A[j] = tmp;
    }

    public static void reverse(int[] A, int i, int j) {
        while(i < j) swap(A, i++, j--);
    }
    
    public static void main(String[] args){
//    	List<String> result = new ArrayList<String>();
//    	result = findStrobogrammatic(4);
//    	for(String s: result){
//    		System.out.println(s);
//    	}
    	int[] num={2,3,1};
    	nextPermutation(num);
    	for(int i: num){
    		System.out.println(i);
    	}
    }
}
