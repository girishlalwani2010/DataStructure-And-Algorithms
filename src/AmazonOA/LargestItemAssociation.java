package AmazonOA;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LargestItemAssociation {

	public static void main(String[] args) {
		List<String> list1 = Arrays.asList("item1", "item2", "item3");
		List<String> list2 = Arrays.asList("item2", "item3", "item4");
		List<String> list3 = Arrays.asList("item0", "item3", "item4");
		
		List<List<String>> largestItemsAssociation = new ArrayList<>();
		largestItemsAssociation.add(list2);
		largestItemsAssociation.add(list1);
		largestItemsAssociation.add(list3);
		
		Collections.sort(largestItemsAssociation, (o1, o2) -> {
			int i=0, j=0;
			while(i<o1.size() && j<o2.size()) {
				int compareTo = o1.get(i).compareTo(o2.get(j));
				if(compareTo!=0) {
					return compareTo;
				}
				i++; j++;
			}
			return 0;
		});
		
		System.out.println(largestItemsAssociation);
	}
	
	
	
}
