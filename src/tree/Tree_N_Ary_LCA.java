package tree;

import java.util.Stack;

public class Tree_N_Ary_LCA {

	public static Employee closestCommonManager(Employee ceo, Employee firstEmployee, Employee secondEmployee) {
		Stack<Employee> firstPath = new Stack<Employee>();
		Stack<Employee> secondPath = new Stack<Employee>();
		
		Employee root = ceo;
		
		DFS(root, firstEmployee, firstPath);
		DFS(root, secondEmployee, secondPath);
		
		if(firstPath.peek().getId() == firstEmployee.getId() && secondPath.peek().getId() == secondEmployee.getId()){
			int size1 = firstPath.size();
			int size2 = secondPath.size();
			int diff = Math.abs(size2-size1);
			
			if(size1 > size2){
				moveUp(firstPath, diff); 
			}
			else{
				moveUp(secondPath, diff);
			}
			
			while(firstPath.peek().getId() != secondPath.peek().getId()){
				firstPath.pop();
				secondPath.pop();
			}
			
			if(firstPath.size() > 0){
				return firstPath.pop();
			}
		}
	    return null;
	}

	private static boolean DFS(Employee root, Employee target, Stack<Employee> path){
		path.push(root);
		if(root.getId() == target.getId()){
			return true;
		}
		
		for(Employee r : root.getReports()){
			boolean res = DFS(r, target, path);
			if(res){
				return true;
			}
		}
		
		path.pop();
		
		return false;
	}

	private static void moveUp(Stack<Employee> path, int diff){
		while(diff > 0 && !path.isEmpty()){
			path.pop();
			diff--;
		}
	}
	
	public static void main(String[] args) {
		Employee emp1 = new Employee(1, "Bill");
		Employee emp2 = new Employee(2, "DOM");
		Employee emp3 = new Employee(3, "SAMIR");
		Employee emp4 = new Employee(4, "MICHAEL");
		Employee emp5 = new Employee(5, "PETER");
		Employee emp6 = new Employee(6, "BOB");
		Employee emp7 = new Employee(7, "PORTER");
		Employee emp8 = new Employee(8, "MILTON");
		Employee emp9 = new Employee(9, "NINA");
		
		emp1.addReport(emp2);
		emp1.addReport(emp3);
		emp1.addReport(emp4);
		
		emp2.addReport(emp5);
		emp2.addReport(emp6);
		emp2.addReport(emp7);
		
		emp5.addReport(emp8);
		emp5.addReport(emp9);
		
		System.out.println(closestCommonManager(emp1, emp8,emp9).getName());
		
		
	}
	
}
