package shortestdistance_hackerrank;

public abstract class graph_class {

	private int numVertices = 0;

	public int getNumVertices() {
		return numVertices;
	}

	public void setNumVertices(int numVertices) {
		this.numVertices = numVertices;
	}

	public void addVertex() {
		numVertices++;
		implementAddVertex();
	}

	public void addEdge(int v, int w, int r) {
		if (v <= numVertices && w <= numVertices) {
			implementAddEdge(v, w, r);
		}
	}

	public abstract void implementAddEdge(int v, int w, int r);

	protected abstract void implementAddVertex();
}
