package datastructure.recursion.backtracking.dfs.bfs.divideandconquer;

/**
 * @author girish_lalwani
 *
 *
 *Not Perfect passing 8/29 cases
 */
public class DecodeString {
	
	 public static String decodeString(String s) {
	        if (s.length() == 0) return "";
		    StringBuilder sb = new StringBuilder();
		    int digitEnd=0;
	        while(digitEnd<s.length() && (Character.isLowerCase(s.charAt(digitEnd)) || Character.isUpperCase(s.charAt(digitEnd)))) {
	        	sb.append(s.charAt(digitEnd));
	        	digitEnd++;
	        }
	        if(digitEnd<s.length() && Character.isDigit(s.charAt(digitEnd)))
	        {
	        	int digitStart = digitEnd;
		        while(Character.isDigit(s.charAt(digitEnd))) digitEnd++;
		        
		        int num = Integer.parseInt(s.substring(digitStart,digitEnd));
		        
		        if(!Character.isDigit(s.charAt(digitEnd))) {
		        	if(s.charAt(digitEnd) == '['){
		        		digitEnd++;
		                 String temp = decodeString(s.substring(digitEnd));
		                 for(int i=0; i<num; i++){
					            sb.append(temp);
					        }
		                 digitEnd = digitEnd + temp.length();
		            }
		        	digitEnd++;   
		        }
		        sb.append(decodeString(s.substring(digitEnd)));  
	        }
		    return sb.toString();
		    }
	
	public static void main(String[] args) {
		//System.out.println(decodeString("abc2[ab]"));
		System.out.println(decodeString("2[abc]3[ad]ef"));
	}

}
