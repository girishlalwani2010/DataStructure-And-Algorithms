package backtracking;

public class ConstructWordUsingDiceRepeat {
	
	private boolean canMake(char[][] dices, String word) {
		boolean[] visited = new boolean[word.length()];
		return canMake(dices, word, 0, visited);
	}
	
	private boolean canMake(char[][] dices, String word, int start, boolean[] visited) {
		
		if(start > word.length()) {
			return false;
		}
		
		if(start == word.length()) {
			return true;
		}
		for(int i=0; i<dices.length; i++) {
			if(visited[i]) {
				continue;
			}
			for(int j=0; j<dices[i].length; j++) {
				if(dices[i][j] == word.charAt(start)) {
					visited[i] = true;
					if(canMake(dices, word, start+1, visited)) {
						return true;
					}
					visited[i] = false;
				}
			}
		}
		return false;
	}
	
	public static void main(String[] args) {
		char[][] dices = { { 'a', 'l', 'c', 'd', 'e', 'f' }, //v 
				{ 'a', 'b', 'c', 'd', 'e', 'f' },
				{ 'a', 'b', 'c', 'h', 'e', 'f' }, //
				{ 'a', 'b', 'c', 'd', 'o', 'f' }, 
				{ 'a', 'b', 'c', 'l', 'e', 'f' }  //v 
				}; 

		String word = "llohe";
		ConstructWordUsingDiceRepeat cw = new ConstructWordUsingDiceRepeat();
		System.out.println(cw.canMake(dices, word));
	}
	
}
