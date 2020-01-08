package graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class EvaluateDivisonTopDownDFS {

	Map<String, Map<String, Double>> graph = new HashMap<>();
	double[] result;

	public void buildGraph(List<List<String>> equations, double[] values) {
		int i = 0;
		for (List<String> equation : equations) {
			graph.putIfAbsent(equation.get(0), new HashMap<>());
			graph.get(equation.get(0)).put(equation.get(1), values[i]);
			graph.putIfAbsent(equation.get(1), new HashMap<>());
			graph.get(equation.get(1)).put(equation.get(0), 1 / values[i]);
			i++;
		}
	}

	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		result = new double[queries.size()];
		buildGraph(equations, values);
		int i = 0;
		for (List<String> query : queries) {
			result[i] = dfs(1.0, query.get(0), query.get(1), new HashSet<>());
			i++;
		}

		return result;
	}

	public double dfs(double product, String source, String destination, Set<String> visited) {

		if (!graph.containsKey(source)) {
			return -1.0;
		}

		if (graph.get(source).containsKey(destination)) {
			return product * graph.get(source).get(destination);
		}

		visited.add(source);

		for (Map.Entry<String, Double> sourceNei : graph.get(source).entrySet()) {
			if (!visited.contains(sourceNei.getKey())) {
				double sourceNeiVal = sourceNei.getValue();
				product = product * sourceNeiVal;
				product = dfs(product, sourceNei.getKey(), destination, visited);
				if(product!=-1.0) {
					return product;
				}else {
					product = 1.0;
				}
			}
		}

		return -1.0;
	}

	public static void main(String[] args) {
		List<List<String>> equations = new ArrayList<>();
		List<String> equation = new ArrayList<>();
		equation.add("x1");
		equation.add("x2");
		equations.add(equation);
		equation = new ArrayList<>();
		equation.add("x2");
		equation.add("x3");
		equations.add(equation);
		equation = new ArrayList<>();
		equation.add("x3");
		equation.add("x4");
		equations.add(equation);
		
		double[] values = {3.0,4.0,5.0};
		
		List<List<String>> queries = new ArrayList<>();
		List<String> query = new ArrayList<>();
		query.add("x2");
		query.add("x4");
		queries.add(query);
		
		EvaluateDivisonTopDownDFS evaluateDivisonTopDownDFS = new EvaluateDivisonTopDownDFS();
		evaluateDivisonTopDownDFS.calcEquation(equations, values, queries);
	}

}
