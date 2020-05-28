package graph;

import java.util.Comparator;

class NodeWithCost implements Comparator<NodeWithCost> {
		public int node;
		public int cost;

		public NodeWithCost() {
		}

		public NodeWithCost(int node, int cost) {
			this.node = node;
			this.cost = cost;
		}

		@Override
		public int compare(NodeWithCost node1, NodeWithCost node2) {
			if (node1.cost < node2.cost)
				return -1;
			if (node1.cost > node2.cost)
				return 1;
			return 0;
		}
	}