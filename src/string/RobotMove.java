package string;

import java.awt.Robot;

public class RobotMove {
	private boolean isCircular(char path[])
	{
	  // Initialize starting point for robot as (0, 0) and starting
	  // direction as N North
	  int x = 0, y = 0;
	  int dir = 0;
	 
	  // Traverse the path given for robot
	  for (int i=0; i<path.length; i++)
	  {
	      // Find current move
	      char move = path[i];
	 
	      // If move is left or right, then change direction
	      if (move == 'R')
	        dir = (dir + 1) % 4;
	      else if (move == 'L')
	        dir = (4 + dir - 1) % 4;
	 
	      // If move is Go, then change  x or y according to
	      // current direction
	      else // if (move == 'G')
	      {
	         if (dir == 0)
	            y++;
	         else if (dir == 1)
	            x++;
	         else if (dir == 2)
	            y--;
	         else // dir == W
	            x--;
	      }
	  }
	 
	   // If robot comes back to (0, 0), then path is cyclic
	  return (x == 0 && y == 0);
	}
	
	public static void main(String[] args) {
		RobotMove robotMove = new RobotMove();
		String path = "GLGLGLG";
		System.out.println(robotMove.isCircular(path.toCharArray()));
	}
	
}

