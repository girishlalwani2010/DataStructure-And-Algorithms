package string;

public class SmallestWindowInStringContainingAllCharactersOfOtherString {

	private static String findSmallestWindow(String text, String pattern){
		
		int []hashOfLowerCaseChars = new int[26];
		
		for(int i=0; i<pattern.length(); i++){
			hashOfLowerCaseChars[pattern.charAt(i) - 97] = pattern.charAt(i);
		}
		
		long patternHash = 0;
		for(int i=0; i<pattern.length(); i++){
			patternHash = patternHash + hashOfLowerCaseChars[pattern.charAt(i) - 97];
		}
		
		long textHash = 0;
		int start = 0;
		for(int j=0; j<text.length(); j++){
			textHash = textHash + hashOfLowerCaseChars[text.charAt(j) - 97]; 
			while(textHash > patternHash){
				textHash = textHash - hashOfLowerCaseChars[text.charAt(start) -97];
				start++;
			}
			if(textHash == patternHash){
				System.out.println("Starting Index : "+start);
				System.out.println("Ending Index : "+j);
				break;
			}
		}
		
		return null;
		
	}
	
	public static void main(String[] args) {
		
		String text = "thiis";
					 //0123456789
		String pattern = "this";
		
		System.out.println(findSmallestWindow(text,pattern));
		
		
		
	}
	
}
