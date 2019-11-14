package datastructure.stack;
import java.util.Arrays;

public class nextGreaterElement {
	private static final int MAX = 100;
	int top = 0;
	int[] arr = new int[MAX];
	
	private boolean push(int d){
		if(top==MAX){
			System.out.println("Stack overflow");
			return false;
		}
		else{
			arr[top++] = d;
			//System.out.println(d+" added to stack at number "+top);
			return true;
		}
	}
	
	private void pop(){
		if(top==0){
			System.out.println("Stack underflow");
		}
		else{
			top--;
			//System.out.println(arr[top]+" popped from the stack");
		}
	}
	
	private boolean isEmpty(){
		if(top>0) return false;
		else return true;
	}
	
	private int peek(){
		if(top>0) return arr[top-1];
		else{
			System.out.println("Empty stack");
			return -1;
		}
	}
	
	
	public static void main(String[] args){
	    int[] arr = {5,9,4,6,10};
		//int[] arr = {11,13,8,3,9};
		//int[] arr = {4,5,2,25};
		//int[] arr = {11,13,21,3};
		//int[] arr = {13,7,6,12};
		int n = arr.length;
		System.out.println("Given array : "+Arrays.toString(arr));
		nextGreaterElement stack = new nextGreaterElement();
		
		int[] nge = new int[n];
		for(int i=0; i<n; i++) nge[i]=-1;
		
		stack.push(0);
		for(int i=1; i<n; i++){
			while((!stack.isEmpty()) && arr[i]>arr[stack.peek()]){
				nge[stack.peek()] = arr[i];
				stack.pop();
			}
			stack.push(i);
		}
		
		System.out.println("NGE Array : "+Arrays.toString(nge));
	}
}