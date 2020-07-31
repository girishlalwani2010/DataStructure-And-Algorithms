package backtracking;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Test {

	public static void main(String[] args) {
		Set<List<Integer>> set1 = new HashSet<>();
		set1.add(Arrays.asList(1,2,3,4));
		set1.add(Arrays.asList(1,2,3,4));
		System.out.println(set1);
	}
	
}
