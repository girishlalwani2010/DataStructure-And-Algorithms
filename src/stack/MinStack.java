package stack;
class Elem{
    public int value;
    public int min;
    public Elem next;
 
    public Elem(int value, int min){
        this.value = value;
        this.min = min;
    }
}
 
public class MinStack {
    public Elem top;
 
    /** initialize your data structure here. */
    public MinStack() {
    }
 
    public void push(int x) {
        if(top == null){
            top = new Elem(x, x); 
        }else{
            Elem e = new Elem(x, Math.min(x,top.min));
            e.next = top;
            top = e;
        }
    }
 
    public void pop() {
        if(top == null)
            return;
        top = top.next;
    }
 
    public int top() {
        if(top == null)
            return -1;
        return top.value;
    }
 
    public int getMin() {
        if(top == null)
            return -1;
        return top.min;
    }
    
    public static void main(String[] args) {
    	MinStack minStack = new MinStack();
    	minStack.push(3);
    	minStack.push(5);
    	System.out.println(minStack.getMin());
    	minStack.push(2);
    	minStack.push(1);
    	System.out.println(minStack.getMin());
	}
    
}