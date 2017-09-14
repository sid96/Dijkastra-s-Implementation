package shortestdistance_hackerrank;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;

public class Dijkastras_shortest_reach2 {

	static Scanner in;
	public static void main(String[] args){
		    in = new Scanner(System.in);
	        int t = in.nextInt();	//Number of Test cases
	        for(int a0 = 0; a0 < t; a0++){
	            int n = in.nextInt();	//Number of vertices
	            int m = in.nextInt();	//Number of edges
	            Dijkastras_graph g=new Dijkastras_graph(n);	//graph object
	            for(int a1 = 0; a1 < m; a1++){
	                int x = in.nextInt();	//start vertex for the edge
	                int y = in.nextInt();	//end of the vertex
	                int r = in.nextInt();	//weight associated with the vertex
	                g.addEdge(x, y, r);
	            }
	            int s = in.nextInt();	//source vertex
	            dijkastras(g,s);	
	            printGraph(g);
	            System.out.println();
	        }
		in.close();
	}
	public static void printGraph(Dijkastras_graph g){
		Map<Integer,Integer> map=g.getShortestDistancesMap();
		for(int i=1;i<=g.getNumVertices();i++){
			int dist=map.get(i);
			if(dist==0){ 	//condition so tha the start vertex is not displayed
				continue;
				}
			else if(dist==Integer.MAX_VALUE){	//condition so that the -1 is printed for the inreachable vertices
				System.out.print(-1+" ");
				continue;
			}
			System.out.print(dist+" ");
		}
	}
	public static void dijkastras(Dijkastras_graph g,int s){	//function to apply dijkastra's algorithm
		PriorityQueue<shortestdist_node> pQueue=g.getpQueue();	
		List<Integer> visited=new ArrayList<>();
		Map<Integer, Integer> distances_map=g.getShortestDistancesMap();
		 shortestdist_node start_vertex=new shortestdist_node(s);
		 start_vertex.dist=0;
		 distances_map.put(s,0);
		 pQueue.add(start_vertex);
		 while(!pQueue.isEmpty()){
			 shortestdist_node current_vertex=pQueue.poll();
			 if(visited.contains(current_vertex))
				 continue;
			 ArrayList<Dijkastras_node> currents_neighbours=g.getNeighbours(current_vertex.label);
			 visited.add(current_vertex.label);
			 for(int i=0;i<currents_neighbours.size();i++){
				 
				 Dijkastras_node each_neighbour=currents_neighbours.get(i);
				 if(!visited.contains(each_neighbour.label)){
					 int dist=current_vertex.dist+each_neighbour.edgeWeight;
					 if(dist<distances_map.get(each_neighbour.label)){
						 distances_map.put(each_neighbour.label, dist);
						 shortestdist_node added_node=new shortestdist_node(each_neighbour.label);
						 added_node.dist=dist;
						 pQueue.add(added_node);
					 }
				 }
			 }
		 }
	}
}


