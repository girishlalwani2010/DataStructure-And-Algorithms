package string;

import java.util.Arrays;
import java.util.Comparator;

public class PrintAllAnagramsTogether implements Comparator<String>{
	
	public String sortChars(String str){
		char[] arr = str.toCharArray();
		Arrays.sort(arr);
		return new String(arr);
	}
	
	@Override
	public int compare(String str1, String str2) {
		return sortChars(str1).compareTo(sortChars(str2));
	}
	
	public static void main(String[] args) {
		String[] strArray = {"cat", "dog", "tac", "god", "act"};
		Arrays.sort(strArray, new PrintAllAnagramsTogether());
		for(String str : strArray)
		System.out.println(str);
	}

}
