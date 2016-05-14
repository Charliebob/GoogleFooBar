package googleInterview;
/**
 *  +-------+-------+-------+
	|   1   |   2   |   3   |
	|  .?!1 |  ABC2 |  DEF3 |
	+-------+-------+-------+
	|   4   |   5   |   6   |
	|  GHI4 |  JKL5 |  MNO6 |
	+-------+-------+-------+
	|   7   |   8   |   9   |
	| PQRS7 |  TUV8 | WXYZ9 |
	+-------+-------+-------+
	|   *   |   0   |   #   |
	|   ←   |SPACE 0|   →   |
	+-------+-------+-------+
	@see http://www.1point3acres.com/bbs/forum.php?mod=viewthread&tid=184198&extra=page%3D1%26filter%3Dsortid%26sortid%3D311%26searchoption%5B3090%5D%5Bvalue%5D%3D1%26searchoption%5B3090%5D%5Btype%5D%3Dradio%26searchoption%5B3046%5D%5Bvalue%5D%3D1%26searchoption%5B3046%5D%5Btype%5D%3Dradio%26sortid%3D311
 * */
public class CellPhoneKeyboardTyping {
	public static String cellPhoneKeyboardTyping(String s){
		String[] keys = {" 0",".?!1","ABC2","DEF3","GHI4","JKL5","MNO6","PQRS7","TUV8","WXYZ9"};
		String result = "";
		for(int i=0; i<s.length(); i++){
			Character digit = s.charAt(i);
			int index = getNumber(digit);
			for(int j=0; j<keys[index].length(); j++){
				if(digit.equals(keys[index].charAt(j))){
					result+=index;
					break;
				}else{
					result+=index;
				}
			}
		}
		return result;
	}
	public static int getNumber(char digit){
		if(digit=='A'||digit=='B'||digit=='C'||digit=='2') return 2;
		else if(digit=='D'||digit=='E'||digit=='F'||digit=='3') return 3;
		else if(digit=='G'||digit=='H'||digit=='I'||digit=='4') return 4;
		else if(digit=='J'||digit=='K'||digit=='L'||digit=='5') return 5;
		else if(digit=='M'||digit=='N'||digit=='O'||digit=='6') return 6;
		else if(digit=='P'||digit=='Q'||digit=='R'||digit=='S'||digit=='7') return 7;
		else if(digit=='T'||digit=='U'||digit=='V'||digit=='8') return 8;
		else if(digit=='W'||digit=='X'||digit=='Y'||digit=='Z'||digit=='9') return 9;
		else if(digit=='.'||digit=='?'||digit=='!'||digit=='1') return 1;
		else if(digit==' '||digit=='0') return 0;
		else return 0;
	}
	
	public static void main(String[] args){
		String s = "WATER";
		System.out.println(cellPhoneKeyboardTyping(s));
	}
}

