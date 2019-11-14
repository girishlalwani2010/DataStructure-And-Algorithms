package string;
import java.util.HashMap;
import java.util.Map;

public class MatchSpecificPatternInDictionary {
	private static int encode(String str){
		int count = 0;
		int hash = 0;
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(char ch:str.toCharArray()){
			if(!map.containsKey(ch))
				map.put(ch, count++);
			hash = hash + map.get(ch);
		}
		return hash;
	}
	public static void main(String[] args) {
		String dict[] = {"abab", "abb", "xyz", "xyy"};
		String pattern = "bba";
		int hash = encode(pattern);
		for(String str:dict){
			if(str.length() == pattern.length() && hash == encode(str)){
				System.out.println(str);
			}
		}
	}

}