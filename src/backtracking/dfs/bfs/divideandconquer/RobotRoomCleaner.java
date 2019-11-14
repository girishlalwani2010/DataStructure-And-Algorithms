package backtracking.dfs.bfs.divideandconquer;
//package datastructure.recursion.backtracking.dfs;
//
//import java.awt.Robot;
//import java.util.Currency;
//import java.util.HashSet;
//import java.util.Set;
//
///**
// * @author girish_lalwani
// *
// *Good Explanation - https://leetcode.com/problems/robot-room-cleaner/discuss/151942/Java-DFS-Solution-with-Detailed-Explanation-and-6ms-(99)-Solution
// *
// *But Below Solution is more intutive
// */
//public class RobotRoomCleaner {
//	
// int[][] directions = {{1,0}, {0,-1}, {-1,0}, {0,1}};
//	 
//	 public void cleanRoom(Robot robot) {
//	        Set<String> visited = new HashSet<>();
//	        visited.add("0-0");
//	        dfs(robot, 0, 0, 0, visited);
//	 }
//	 
//	 private void dfs(Robot robot, int x, int y, int currDirection, Set<String> visited) {
//		 robot.clean();
//		 for(int i=0; i<4; i++) {
//			 int nextDir = (currDirection+i)%4;
//           Tricky Part as we have to see all four direction corresponding to current direction not in incremnetal fashion like x= x+directions[nextDir][0];
// 			 Hence created new variable; newX, newY
//			 int newX = x + directions[nextDir][0];
//			 int newY = y + directions[nextDir][1];
//			 if(!visited.contains(newX+"-"+newY) && robot.move()) {
//				 visited.add(newX+"-"+newY);
//				 dfs(robot,newX,newY,nextDir,visited);
//			 }
//			 robot.turnRight();
//		 }
//		 robot.turnLeft();
//		 robot.turnLeft();
//		 robot.move();
//		 robot.turnLeft();
//		 robot.turnLeft();
//    }
//	
//	public static void main(String[] args) {
//		
//	}
//
//}
