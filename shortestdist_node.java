package shortestdistance_hackerrank;

public class shortestdist_node implements Comparable<shortestdist_node> {

	int label;	//variable that maps to each vertex

	int dist = Integer.MAX_VALUE;	//variable storing the shortest distance for each vertex

	public shortestdist_node(int label) {	//constructor to initialize the the label
		this.label = label;
	}

	public int getdist() {
		return dist;
	}

	@Override
	public int compareTo(shortestdist_node a) {		//overriding compareTo to compare objects in priority queue
		if (getdist() > a.getdist())
			return 1;
		else if (getdist() < a.getdist())
			return -1;
		else
			return 0;
	}

}
