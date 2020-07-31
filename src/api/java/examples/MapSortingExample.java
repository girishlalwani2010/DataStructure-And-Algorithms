package api.java.examples;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;
import java.util.TreeSet;
import java.util.stream.Collectors;

class Employee {
	private String name;
	private int age;
	
	public Employee(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + "]";
	}
}

public class MapSortingExample {

	public static void main(String[] args) {
//			treesetDuplicateRemovalCheck();
			
			//Sort map by value Java-7
			Map<String,Employee> map = new HashMap<>();
			map.put("girish", new Employee("girish", 30));
			map.put("girish", new Employee("girish", 40));
			map.put("ravi", new Employee("ravi", 33));
			Set<Map.Entry<String, Employee>> hashset  = map.entrySet();
			List<Map.Entry<String, Employee>> list = new ArrayList<>(hashset);
			Collections.sort(list, MapSortingExample::compareEmployeesByAgeJava8);
			Map<String, Employee> sortedMap = new LinkedHashMap<>();
			for(Map.Entry<String, Employee> entry : list) {
				sortedMap.put(entry.getKey(), entry.getValue());
			}
			
			System.out.println(sortedMap);
			
			//Java-8 way
			map.entrySet().stream().sorted(MapSortingExample::compareEmployeesByAgeJava8).forEach(System.out::print);
			
			//Additionally, we can collect the results into a new map:
			map.entrySet().stream().sorted(MapSortingExample::compareEmployeesByAgeJava8).collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (oldValue, newValue) -> newValue, LinkedHashMap::new));
	}
	
	
	private static int compareEmployeesByAgeJava8(Map.Entry<String, Employee> entry1, Map.Entry<String, Employee> entry2) {
		return entry1.getValue().getAge() - entry2.getValue().getAge();
	}

	
	/**
	 * @return
	 * For Java7 implementation
	 */
	/*private static Comparator<? super Entry<String, Employee>> compareEmployeesByAgeJava7() {
		return (o1, o2) -> {
			Employee e1 = o1.getValue();
			Employee e2 = o2.getValue();
			return e1.getAge() - e2.getAge();
		};
	}*/

	private static void treesetDuplicateRemovalCheck() {
		TreeSet<Employee> tset = new TreeSet<>(new Comparator<Employee>() {
			@Override
			public int compare(Employee o1, Employee o2) {
				return o1.getName().compareTo(o2.getName());
			}
		});
		tset.add(new Employee("girish", 30));
		tset.add(new Employee("girish", 30));
		System.out.println(tset);
	}
	
	
	ArrayList<Integer>arrange(ArrayList<Integer> A, ArrayList<Integer> B, int n)
    {
       Map<Integer, Integer> map = new HashMap<>();
       for(int i=0; i<A.size(); i++){
           map.put(A.get(i),B.get(i));
       }
       
       List<Map.Entry<Integer,Integer>> entryList = new ArrayList<>();
       
       Collections.sort(entryList, new Comparator<Map.Entry<Integer,Integer>>() {

		@Override
		public int compare(Entry<Integer, Integer> o1, Entry<Integer, Integer> o2) {
			// TODO Auto-generated method stub
			return 0;
		}
	});
       
       List<Integer> result = new ArrayList<Integer>();
       
       for(Entry<Integer, Integer> entry : entryList){
            result.add(entry.getValue(), entry.getKey());
       }
       
       return (ArrayList<Integer>) result;
    }

}
