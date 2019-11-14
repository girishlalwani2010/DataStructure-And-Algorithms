package stream;

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class FirstNonRepeatingCharacters {

	public static void main(String[] args) {
		
		char stream[] = {'a','b','c','a'};
		Set<Character> seen = new HashSet<Character>();
		List<Character> listOfFirstNonRepeatingChars = new LinkedList<Character>();
		
		for(int i=0; i<stream.length; i++){
			char c;
			if(!seen.contains(stream[i])){
				seen.add(stream[i]);
				listOfFirstNonRepeatingChars.add(stream[i]);
			}
			else{
				listOfFirstNonRepeatingChars.remove(new Character(stream[i]));
			}
			if(listOfFirstNonRepeatingChars.size()>0)
				System.out.println(listOfFirstNonRepeatingChars.get(0));
			else
				System.out.println(-1);	
		}
		
	}
	
}
