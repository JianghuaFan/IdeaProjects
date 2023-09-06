package Graph;
import java.util.ArrayList;
import java.util.List;
public class Graph {
	// A utility function to add an edge in an undirected graph
	static void addEdge(List<List<GraphNode>> adj, GraphNode N1, GraphNode N2) {
		
		adj.get(N1.key).add(N2);
		adj.get(N2.key).add(N1);		
	}
	static void createGraph() {
		
		
	}
	// A utility function to print the adjacency list represent of graph
	static void printGraph(List<List<GraphNode>> adj) {
		for (int i = 0; i < adj.size(); i++) {
            System.out.println("\nAdjacency list of Node"
                               + adj.get(i));
            System.out.print("head");
            for (int j = 0; j < adj.get(i).size(); j++) {
                System.out.print(" -> "
                                 + adj.get(i).get(j));
            }
            System.out.println();
        }
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int V = 4;// create a graph with 5 vertices
		List<List<GraphNode>> graph = new ArrayList<>(V);
		for(int i = 0; i < V; i++) {
			graph.add(new ArrayList<GraphNode>());			
		}
		// Adding edge one by one
		GraphNode N1 = new GraphNode(1);
		GraphNode N2 = new GraphNode(2);
		GraphNode N3 = new GraphNode(3);
		GraphNode N4 = new GraphNode(4);
//		graph.add(N1);
//		graph.add(N2);
//		graph.add(N3);
//		graph.add(N4);
//		addEdge(graph,N1,N2);
//		addEdge(graph,1,3);
//		addEdge(graph,2,3);	
//		printGraph(graph);		
	}
}
