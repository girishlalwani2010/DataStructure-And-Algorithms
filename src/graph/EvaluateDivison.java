package graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author girish_lalwani
 *https://leetcode.com/problems/evaluate-division/discuss/171649/1ms-DFS-with-Explanations
 */
public class EvaluateDivison {
	
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
    	
    	Map<String,Map<String,Double>> graph = buildGraph(equations, values);
    	double[] result = new double[queries.size()];
    	Set<String> visited = new HashSet<>();
    	 for (int i = 0; i < queries.size(); i++) {
             result[i] = dfs(queries.get(i).get(0), queries.get(i).get(1), graph, new HashSet<>());
         }  
    	return result;
    }
    
    public double dfs(String start, String end, Map<String,Map<String,Double>> graph, Set<String> visited) {
    	
    	 /* Rejection case. */
        if (!graph.containsKey(start)) 
            return -1.0;
        
        /* Accepting case. */
        if (graph.get(start).containsKey(end))
            return graph.get(start).get(end);
        
        visited.add(start);
        for (Map.Entry<String, Double> neighbour : graph.get(start).entrySet()) {
            if (!visited.contains(neighbour.getKey())) {
                double productWeight = dfs(neighbour.getKey(), end, graph, visited);
                if (productWeight != -1.0)
                    return neighbour.getValue() * productWeight;
            }
        }
        
        return -1.0;
    }
	
    /**
     * @param equations
     * @param values
     * @return
     * equations = [ ["a", "b"], ["b", "c"] ],
		values = [2.0, 3.0],
     */
    private Map<String,Map<String,Double>> buildGraph(List<List<String>> equations, double[] values){
    	Map<String,Map<String,Double>> graph = new HashMap<>();
    	int i=0;
    	for(List<String> edge: equations) {
    		String u = edge.get(0);
    		String v = edge.get(1);
    		 graph.putIfAbsent(u, new HashMap<>());
             graph.get(u).put(v, values[i]);
             graph.putIfAbsent(v, new HashMap<>());
             graph.get(v).put(u, 1 / values[i]);
             i++;
    	}
		return graph;
    }
    
	// better intuitive top-down way 10/11 test cases passed 

}
