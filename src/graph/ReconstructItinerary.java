package graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class ReconstructItinerary {

	List<String> iternary;
	public List<String> findItinerary(List<List<String>> tickets) {
		Map<String, PriorityQueue<String>> adj= new HashMap<>();
        for(List<String> connections: tickets){
            adj.putIfAbsent(connections.get(0), new PriorityQueue<>());
            adj.get(connections.get(0)).add(connections.get(1));
        }
        String start = "JFK";
        iternary = new LinkedList<String>();
        dfs(adj, start);
        return iternary;
    }
	
	
	/**
	 * @param adj
	 * @param airline
	 * Head Recursion 
	 * JFK -> KUL, NRT
	 * NRT -> JFK.
	 * 
	 * recursion calling will be
	 * dfs("JFK") -> dfs("KUL") -> add KUL to iternary {KUL} return;
	 * dfs("JFK") -> dfs("NRT") -> 
	 * 			dfs("JFK") -> add JFK to iternary {JFK, KUL} 
	 * 				return to dfs("NRT") add NRT to iternary {NRT, JFK, KUL}
	 * 					return to dfs("JFK") add "JFK" to iternary {NRT, JFK, KUL, JFK} done.
	 * 
	 * Basic idea is to store last one first , that is ending airline and then backtrack
	 * 
	 * Priority Queue is must over there as we have to not be continued in the cycle but just process cycle once,
	 * So to process cycle once there is one data-structure that can do this is Queue as it works on poll, and priority-Q
	 * here as we need itinerary that has the smallest lexical order.
	 * 
	 *  Hierholzer's Algorithm
	 * 
	 */
	public void dfs(Map<String, PriorityQueue<String>> adj, String airline) {
		PriorityQueue<String> connections = adj.get(airline);
		while(connections!=null && !connections.isEmpty()) {
			dfs(adj, connections.poll());
		}
		iternary.add(0,airline);
	}
	
	
	public static void main(String[] args) {
		List<List<String>> input = new ArrayList<>();
		input.add(Arrays.asList("JFK","KUL"));
		input.add(Arrays.asList("JFK","NRT"));
		input.add(Arrays.asList("NRT","JFK"));
		
		ReconstructItinerary reconstructItinerary = new ReconstructItinerary();
		System.out.println(reconstructItinerary.findItinerary(input));
	}
	
}
