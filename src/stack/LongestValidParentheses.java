package stack;

import java.util.Stack;

public class LongestValidParentheses {
	
    public int longestValidParentheses(String s) {
        if(s.length()==0){
            return 0;
        } 
        Stack<Integer> stack = new Stack<>();
        stack.push(-1); 
        char[] sArr = s.toCharArray();
        int maxLen = 0; 
        for(int i=0; i<s.length(); i++){
           if(sArr[i] == '('){
                stack.push(i);       
           }else{
               stack.pop();
               if(stack.isEmpty()){
            	   // store the last unmatched position, so it will be start for next balance parenthesis.
                   stack.push(i);
               }else{
            	   //calculate length of balance parenthesis from last unmatched position;
                   maxLen = Math.max(maxLen,i-stack.peek());
               }
           }
       }
       return maxLen;  
    }

}
