package dynamicProgramming;

public class FillTheScreen {
	public static int fillTheScreen(String strs, int row, int col){
		int result = 0;
		int rowCount = 0;
		int colCount = 0;
		int index = 0;
		String[] str = strs.split(" ");
		while(rowCount<row){
			colCount += str[index].length()+1;
			if(colCount-1<=col){
				index++;
			}else{
				rowCount++;
				colCount=0;
			}
			if(index==str.length){
				index = 0;
				result++;
			}
		}
		return result;
	}
	public static void main(String[] args){
		String s = "I am student";
		System.out.println(fillTheScreen(s, 5, 9));
	}
}
