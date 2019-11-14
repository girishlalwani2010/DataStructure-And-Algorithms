package stack;

import java.util.LinkedList;
import java.util.Queue;

public class StackImplementationUsingQueue {

	Queue<Integer> qNew = new LinkedList<Integer>();
	Queue<Integer> qOld = new LinkedList<Integer>();
	Queue<Integer> temp;
	
	//making push operation expensive
		// 1). Enqueue x to qNEw.
		// 2). Dequeue everything from qOld to qNew.
		// 3). swap qOld and qNew.
	private void expensivePUSH(int item){
		qNew.add(item);
		while(!qOld.isEmpty()){
			qNew.add(qOld.poll());
		}
		temp = qNew;
		qNew = qOld;
		qOld = temp;
	}
	
	private int inExpensivePOP(){
		return qOld.poll();
		
	}
	
	private void inExpensivePUSH(int item){
		qNew.add(item);
	}
	// Move all the element except last from qNew to qOld, store the last element and then swap qNew and qOld.
	private int expensivePOP(){
		while(qNew.size()>1){
			qOld.add(qNew.poll());
		}
		int item = qNew.poll();
		temp = qOld;
		qOld = qNew;
		qNew = temp;
		return item;
	}
	
	
	public static void main(String[] args) {
		StackImplementationUsingQueue stackImplementationUsingQueue = new StackImplementationUsingQueue();
		
		//Expensive PUSH TEST
		/*stackImplementationUsingQueue.expensivePUSH(10);
		stackImplementationUsingQueue.expensivePUSH(20);
		stackImplementationUsingQueue.expensivePUSH(30);
		stackImplementationUsingQueue.expensivePUSH(40);
		
		System.out.println(stackImplementationUsingQueue.inExpensivePOP());
		System.out.println(stackImplementationUsingQueue.inExpensivePOP());
		System.out.println(stackImplementationUsingQueue.inExpensivePOP());
		System.out.println(stackImplementationUsingQueue.inExpensivePOP());*/
		
		
		//Expensive POP TEST
		
		stackImplementationUsingQueue.inExpensivePUSH(10);
		stackImplementationUsingQueue.inExpensivePUSH(20);
		stackImplementationUsingQueue.inExpensivePUSH(30);
		stackImplementationUsingQueue.inExpensivePUSH(40);
		
		System.out.println(stackImplementationUsingQueue.expensivePOP());
		System.out.println(stackImplementationUsingQueue.expensivePOP());
		System.out.println(stackImplementationUsingQueue.expensivePOP());
		System.out.println(stackImplementationUsingQueue.expensivePOP());
	}
	
	
	
	// making pop operation expensive.
		// 1). 
		
}
