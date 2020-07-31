package array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author girish_lalwani
 *Queue Reconstruction by height. 
 */
public class test1geeks {

	static ArrayList<Integer> arrange(ArrayList<Integer> A, ArrayList<Integer> B, int n) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < A.size(); i++) {
			map.put(A.get(i), B.get(i));
		}

		List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());

		Collections.sort(entryList, new Comparator<Map.Entry<Integer, Integer>>() {
			@Override
			public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
				return o2.getKey() - o1.getKey();
			}
		});

		ArrayList<Integer> result = new ArrayList<>();

		for (Map.Entry<Integer, Integer> entry : entryList) {
			result.add(entry.getValue(), entry.getKey());
		}

		return result;
	}
	
	
	public static void main(String[] args) {
		
		ArrayList<Integer> list1 = new ArrayList<>(Arrays.asList(3,2,1));
		ArrayList<Integer> list2 = new ArrayList<>(Arrays.asList(0,1,1));
		
		System.out.println(arrange(list1, list2, 3));
		
		
	}

}
