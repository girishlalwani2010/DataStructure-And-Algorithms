package datastructure.string;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class CharRearrangement {
	
	public static void main(String[] args) {
		
	//	String[] arr = {"a","a","a","b","c"};
	//	String[] arr = {"a","a","a","a","c"};
	//	String[] arr = {"a","b","b","a","c"};
		String[] arr = {"a","b","c","c","d"};
//		String[] arr = {"a","a","a","b","c"};

		PriorityQueue<Node> q = new PriorityQueue<>(100, new FreqComparator());
		
		HashMap<String,Integer> h = new HashMap<>();
		int totalCount = 0;
		 int maxcount = 0;
		for(String c  :arr){
			if(h.containsKey(c)){
				System.out.println("contains");
				int count = h.get(c);
				h.put(c, ++count);
				totalCount++;
			}else{
				h.put(c,1);
				totalCount++;
			}
			
			if(h.get(c) > maxcount){
				maxcount= h.get(c);
			}
		}
		System.out.println(h);
		
		System.out.println("Total char  :  "  + totalCount);
		System.out.println("Max char of one type:  " +  maxcount);
		
		if(maxcount > (totalCount - maxcount +1)){
			System.out.println("Not possible");
			return;
		}else{
			System.out.println("Possible");
		}
		
		for(Map.Entry<String, Integer> entry  : h.entrySet()){
			Node n = new Node(entry.getKey(), entry.getValue());
			q.add(n);
		}
		
		System.out.println(q);
		
		Node pointer = q.remove();
		System.out.println("First pointer : " +  pointer.c);
		System.out.println(q);
		System.out.println("Started Retrieval");
		System.out.println();
		System.out.println();
		while(pointer != null){
			//pointer = q.remove();
			
			System.out.println(pointer.c);
			pointer.count =pointer.count -1;
			Node temp = pointer;
			if(!q.isEmpty()){
				pointer = q.remove();
			}else{
				pointer = null;
			}
			if(temp.count > 0){
				q.add(temp);
			
			}
		}
	}

}

class FreqComparator implements Comparator<Node>{

	@Override
	public int compare(Node n1, Node n2) {
		System.out.println("compare called");
		// TODO Auto-generated method stub
		if(n1.count> n2.count){
			return -1;
		}
		if(n1.count < n2.count){
			return 1;
		}
		
		return 0;
	}
	
	
}

 class Node{
	
	public String c;
	public int count;
	
	public Node(String c, int count){
		this.c =  c;
		this.count = count;
	}

	@Override
	public String toString() {
		return "Node [c=" + c + ", count=" + count + "]";
	}
	
	
}