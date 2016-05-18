package googleInterview;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
public class SpySnippet {
	public static String answer(String document, String[] searchTerms) {
		Set<String> searchSet = new HashSet<>(Arrays.asList(searchTerms));
	
	    String[] words = document.split("\\s+");
	
	    // This algorithm involves a lot of backtracking; might need to optimize
	    int start = -1;
	    int curr = 0;
	    int smallestSize = Integer.MAX_VALUE;
	    int smallestStart = 0;
	    Set<String> termsFound = new HashSet<>();
	    for (;;) {
	        if (curr == words.length) {
	            break;
	        }
	
	        String word = words[curr];
	        if (searchSet.contains(word)) {
	            if (termsFound.size() == 0) {
	                start = curr;
	            }
	
	            termsFound.add(word);
	
	            // We've found a snippet!
	            if (termsFound.size() == searchTerms.length) {
	                int end = curr;
	                int size = end - start + 1;
	                if (size < smallestSize) {
	                    smallestSize = size;
	                    smallestStart = start;
	                }
	
	                termsFound.clear();
	                curr = start;
	            }
	        }
	
	        curr++;
	    }
	
	    // Reconstruct the snippet from the data
	    StringBuilder sb = new StringBuilder();
	    for (int a = 0; a < smallestSize; a++) {
	        if (a != 0) {
	            sb.append(" ");
	        }
	        sb.append(words[smallestStart + a]);
	    }
	
	    	return sb.toString();
		}
	public static void main(String[] args){
		String document = "many google employees can program";
		String[] searchTerms = {"google", "program"};
		System.out.println(answer(document, searchTerms));
	}
	
}
