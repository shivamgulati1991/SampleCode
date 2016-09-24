public class CommonSequence {

	public static boolean chkSubsequence(String input1, String input2){
		int index=0;
		for(int i=0;i<input2.length();i++){
			if(input1.charAt(index)==input2.charAt(i)){
				index++;
			}
		}
		if(index==input1.length())
		return true;
		return false;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println(chkSubsequence("bcca","baca"));
	}
}
