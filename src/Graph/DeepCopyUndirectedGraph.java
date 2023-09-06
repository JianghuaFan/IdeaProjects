package Graph;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeepCopyUndirectedGraph {
	 public List<GraphNode> copyBFS(List<GraphNode> graph) {
		   // Write your solution here.					
		Deque<GraphNode> queue = new ArrayDeque<>();
		Map<GraphNode,GraphNode> map = new HashMap<>();
		
	// BFS: 因为图可以为不连通图，所以需要对于graph里的每个节点都要判断是否已经遍历过，没有遍历过的话调用BFS，
	// 所以才会有主函数的这个for循环。而树里面只有一个根节点，offer一次以后只需要判断queue不为空就能将整棵树BFS
		for(GraphNode node : graph) {
			if(!map.containsKey(node)) {
				map.put(node, new GraphNode(node.key));
				queue.offer(node);
				BFS(map, queue);
			}			 
		}
		return new ArrayList<>(map.values());
	 }
	public void BFS(Map<GraphNode,GraphNode> map, Deque<GraphNode> queue) {
		while(!queue.isEmpty()) {
			// 对于每一个expansion的节点都要判断是否已经处理过了，
			GraphNode cur = queue.poll();
			if(!map.containsKey(cur)) {
				map.put(cur, new GraphNode(cur.key));
				queue.offer(cur);
			}
			for(GraphNode nei : cur.neighbors) {
				// 同样对于每一个generation的节点都要判断是否已经处理过了，
				if(!map.containsKey(nei)) {
					map.put(nei, new GraphNode(nei.key));
					queue.offer(nei);					
				}
				map.get(cur).neighbors.add(map.get(nei));
			}
		}	
	}
		
	public List<GraphNode> copy(List<GraphNode> graph) {
		// DFS: 
		if(graph == null){
			return null;
		}
		Map<GraphNode, GraphNode> map = new HashMap<>();
		for(GraphNode node : graph){
			if(!map.containsKey(node)){
	        map.put(node, new GraphNode(node.key));
	        DFS(map, node);
			}				  
		}
		return new ArrayList<>(map.values());
	}
	public void DFS(Map<GraphNode, GraphNode> map, GraphNode seed){
		// base case: seed is null or seed has already been copied
		if(seed == null ){
				return;
		}
		GraphNode copy = map.get(seed);
		for(GraphNode nei: seed.neighbors){
			if(!map.containsKey(nei)){
				map.put(nei, new GraphNode(nei.key));
				DFS(map, nei);
		}
		copy.neighbors.add(map.get(nei));
		}
	}


	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		List<GraphNode> graph = new ArrayList<>();
		GraphNode N1 = new GraphNode(1);
		GraphNode N2 = new GraphNode(2);
		GraphNode N3 = new GraphNode(3);
		GraphNode N4 = new GraphNode(4);
		graph.add(N1);
		graph.add(N2);
		graph.add(N3);
		graph.add(N4);
		N1.neighbors.add(N2);
		N1.neighbors.add(N3);
		N2.neighbors.add(N4);
		

	}

}
