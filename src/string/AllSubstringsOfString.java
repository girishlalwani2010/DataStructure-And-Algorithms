package string;

public class AllSubstringsOfString {

	static void subString(String str) { 
        // Pick starting point 
		int strLen = str.length();
        for (int len = 1; len <= strLen; len++) { 
            // Pick ending point 
            for (int i = 0; i <= strLen - len; i++) { 
                System.out.println(str.substring(i, i+len)); 
            } 
        } 
    } 
  
// Driver program to test above function 
    public static void main(String[] args) { 
        subString("abc"); 
  
    } 
}
