package shortestdistance_hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Dijkastras_graph extends graph_class {
	private Map<Integer, ArrayList<Dijkastras_node>> dijkgraph;	//mapping of the vertex to it's neighbours
	private Map<Integer, Integer> shortest_distances_map;	//mapping vertex to shortest distances
	private PriorityQueue<shortestdist_node> pQueue = new PriorityQueue<shortestdist_node>();	//priority queue used in dijkastra's function in Dijkastras_shortest_reach2 class

	public Dijkastras_graph(int numVertices) {
		dijkgraph = new HashMap<Integer, ArrayList<Dijkastras_node>>(
				numVertices);
		shortest_distances_map = new HashMap<>(numVertices);
		for (int i = 0; i < numVertices; i++) {
			addVertex();
		}
	}

	@Override
	public void implementAddEdge(int v, int w, int r) {		//function to make connections between vertices
		Dijkastras_node d1 = new Dijkastras_node(w);
		Dijkastras_node d2 = new Dijkastras_node(v);
		d1.edgeWeight = r;
		d2.edgeWeight = r;
		dijkgraph.get(v).add(d1);
		dijkgraph.get(w).add(d2);
	}

	@Override
	protected void implementAddVertex() {	//function for adding verticess
		int v = getNumVertices();
		ArrayList<Dijkastras_node> neighbors = new ArrayList<>();
		shortest_distances_map.put(v, Integer.MAX_VALUE);
		dijkgraph.put(v, neighbors);
	}

	public Map<Integer, ArrayList<Dijkastras_node>> getDijkgraph() {
		return dijkgraph;
	}

	public Map<Integer, Integer> getShortestDistancesMap() {
		return shortest_distances_map;
	}

	public PriorityQueue<shortestdist_node> getpQueue() {
		return pQueue;
	}

	public ArrayList<Dijkastras_node> getNeighbours(int v) {
		return dijkgraph.get(v);
	}

}
