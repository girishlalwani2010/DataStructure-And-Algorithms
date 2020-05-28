package stack;

import java.util.Stack;

public class MinimumRemoveToMakeValidParentheses {
	
	 public String minRemoveToMakeValid(String s) {
	       if(s.length()==0){
	           return "";
	       } 
	       Stack<Integer> stack = new Stack<>();
	       char[] sArr = s.toCharArray();
	       for(int i=0; i<sArr.length; i++){
	           if(sArr[i] == '('){
	               stack.push(i);
	           }else if(sArr[i] == ')'){
	               if(!stack.isEmpty() && sArr[stack.peek()]=='('){
	                   stack.pop();
	               }else{
	                   stack.push(i);
	               }
	           }
	       }
	       StringBuilder sb = new StringBuilder(s) ;
	       while(!stack.isEmpty()){
	           sb.deleteCharAt(stack.pop());
	       }
	       return sb.toString(); 
	    }

}
