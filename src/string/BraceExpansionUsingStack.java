package string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.Stack;
import java.util.TreeSet;

/**
 * @author girish_lalwani
 *
 *For example for {a,b,c} d {e,f}
 *
 *	Start scanning the String
 *
 * Rule-1). Keep pushing into stack till we found '}'
 * 
 * Rule-2). If we get '}', then will do poping from stack and will construct union string till we found '{',
 * `		then will do one more pop to remove '{' and push union string into the stack
 * 			
 * For above example Stack after 1st Rule is ["{","a","b","c"] , then 2 Rule will come as we found '}' in scanning,
 * So after 2nd Rule unionStr will become  "a,b,c", and will push this into stack and character '}'. So stack will
 * become ["a,b,c","}"], then again Rule-1 and Rule-2 comes, as string is scanned till last '}' after f, So stack will become 
 * ["a,b,c","}","d","e,f","}"]
 * 
 * Then Rule-3 Comes as we scanned whole string so we start empting the stack, and "}" will treat as product/concat operator and will store the result in treeset,
 * as '}' is the top of Stack So will start poping from stack till we found another '}'
 * 
 * So tempResult will be ["de","df"]
 * 
 * then will concat it with resultSet, then in further poping from stack, 
 * 
 * tempResult will be ["a,b,c"]
 * 
 * then will concat it with resultSet
 * So resultSet will become ["ade","adf","bde","bdf","cde", "cdf"]
 *    
 *    
 * For BraceExpansionII we can modify it like two concat in last two poped elements from stack, while empting the stack 
 * and while pushing into the stack, that is in for loop will keep on construct the unionStr but will not push '}' as close braces '}' will be cancelled with '{' open braces  
 * pushed earlier only in BraceExpansionII will push '{' this also, So to make it more generic in comparison to BraceExpansion 
 *
 *So for example for string {a,b}{c,{d,e}}, after for loop stack will be ["a,b","c,d,e"] 
 *then it is simple will do concat on stack elements
 */
public class BraceExpansionUsingStack {

	public static String[] expand(String S) {

		Stack<String> stack = new Stack<>();

		char[] charArray = S.toCharArray();

		Set<String> resultSet = new TreeSet<String>();

		for (int i = 0; i < charArray.length; i++) {
			if (charArray[i] == '}') {
				StringBuilder unionStr = new StringBuilder();
				// pop from stack
				while (!stack.peek().equals("{")) {
					unionStr.insert(0, stack.pop());
				}
				// for poping '{'
				stack.pop();
				stack.push(unionStr.toString());
			}
			stack.push("" + charArray[i]);

		}
		//{a,b}{c,{d,e}}
		while (!stack.isEmpty()) {
			List<String> unionOperands = new ArrayList<String>();
			StringBuilder firstOperand = new StringBuilder();
			Set<String> tempResult = new TreeSet<String>();
			Set<String> prevresult = resultSet;
			resultSet = new TreeSet<String>();
			// apply concat operation
			if (stack.peek().equals("}")) {
				stack.pop();
				while (!stack.isEmpty() && !stack.peek().equals("}")) {
					String operand = stack.pop();
					if (operand.contains(",")) {
						unionOperands = Arrays.asList(operand.split(","));
					} else {
						firstOperand.insert(0,operand);
					}
				}
			}
			
			while(!stack.isEmpty() && !stack.peek().equals("}")) {
				String operand = stack.pop();
				firstOperand.insert(0,operand);
			}

			if (unionOperands.size() > 0) {
				for (String unionOprnd : unionOperands) {
					tempResult.add(firstOperand + unionOprnd);
				}
			} else {
				tempResult.add(firstOperand.toString());
			}

			if (prevresult.isEmpty()) {
				resultSet = tempResult;
			} else {
				for (String tempStr : tempResult) {
					for (String str : prevresult) {
						resultSet.add(tempStr + str);
					}
				}
			}
		}
		
		return resultSet.toArray(new String[resultSet.size()]);
	}
	
	public static void main(String[] args) {
		System.out.println(Arrays.toString(expand("{a,b}{c,{d,e}}")));
	}
	
	
}
