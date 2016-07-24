package dynamicProgramming;

public class ConvertSortedString {
	public static int convertSortedString(String s) {
        int length = s.length();
        if (length <= 1)
            return length;
        //I assume we want aaa...bbb, ret can be all a or all b
//        let A[n] ends with a, B[n] ends with b
        //We can improve it without array....
        int [] a = new int [1+length];
        int [] b = new int [1+length];
        for (int i = 1; i <= length; ++i) {
            if (s.charAt(i-1) == 'a') {
                a[i] = a[i-1];
                b[i] = 1 + Math.min(a[i-1], b[i-1]);
            } else {
                a[i] = 1 + a[i-1];
                b[i] = Math.min(a[i-1], b[i-1]);
            }
        }

        return Math.min(a[length], b[length]);
    }
	public static void main(String[] args){
		String s = "abaaaabba";
		System.out.println(convertSortedString(s));
	}
}
