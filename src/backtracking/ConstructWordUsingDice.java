package backtracking;

import java.util.ArrayList;
import java.util.List;

public class ConstructWordUsingDice {

	private static boolean[] visited;

	private static boolean makeWord(char[][] dices, String word) {
		visited = new boolean[dices.length];
		return canBeConstructed(dices, word, visited);
	}

	private static boolean canBeConstructed(char[][] dices, String word, boolean[] visited) {
		if (word.isEmpty()) {
			return true;
		}
		for (int i = 0; i < dices.length; i++) {
			if (visited[i]) {
				continue;
			}
			for (int j = 0; j < dices[i].length; j++) {
				if (word.charAt(0) == dices[i][j]) {
					visited[i] = true;
					if (canBeConstructed(dices, word.substring(1), visited)) {
						return true;
					} else {
						visited[i] = false;
					}
				}
			}
		}
		return false;
	}

	public static void main(String[] args) {
		char[][] dices = { { 'a', 'l', 'c', 'd', 'e', 'f' }, //v 
				{ 'a', 'b', 'c', 'd', 'e', 'f' },
				{ 'a', 'b', 'c', 'h', 'e', 'f' }, //v
				{ 'a', 'b', 'c', 'd', 'o', 'f' }, 
				{ 'a', 'b', 'c', 'l', 'e', 'f' }  //v 
				}; 

		String word = "hello";

		System.out.println(makeWord(dices, word));
	}

}
