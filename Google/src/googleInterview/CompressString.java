package googleInterview;

public class CompressString {
	public static String compressString(String s){
		int count = 1;
		char last = s.charAt(0);
		StringBuilder output = new StringBuilder();
		for(int i = 1; i < s.length(); i++){
		    if(s.charAt(i) == last){
		    	count++;
		    }else{
		        if(count > 1){
		            output.append(""+count+last);
		        }else{
		            output.append("1"+last);
		        }
		    count = 1;
		    last = s.charAt(i);
		    }
		}
		if(count > 1){
		    output.append(""+count+last);
		}else{
		    output.append("1"+last);
		}
		return output.toString();
	}
	public static void main(String[] args){
		String s = "abcxxabcxx";
		System.out.println(compressString(s));
	}
}
