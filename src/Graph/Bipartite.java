package Graph;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class Bipartite {
	 public boolean isBipartite(List<GraphNode> graph) {
		   // write your solution here 	
		// use 0 and 1 to do denote two different groups
		// the map maintains for each node which group it belongs to
		// the graph can be represented by a list of nodes(if it is not guaranteed to be connected). we have to do BFS from every node
//		Map<GraphNode, Integer> visited= new HashMap<>();
//		for(GraphNode node : graph){
//			// 遍历所有节点，如出现不符合bipartite的就返回false， 同时也解决了如果有单独非联通节点的case
//			if(!BFS(visited,node)) {
//				return false;
//			}
//		}
		if(graph.size() <= 2){
		      return true;
		}
		for(GraphNode node : graph) {
			if(!BFS(node)) {
				return false;
			}
		}
		return true;
	}
	public boolean BFS(Map<GraphNode, Integer> visited, GraphNode node){
	// if this node has been traversed, no need to do BFS again.
		if(visited.containsKey(node)){
			return true;
		}
		Queue<GraphNode> queue = new LinkedList<>();
		// start BFS from the node, since the node has not been visited, we can assign it 
		// to any of the groups, for example, group 0
		visited.put(node, 0);
		queue.offer(node);
		while(!queue.isEmpty()){
			GraphNode curNode = queue.poll();
			// the group assigned for curNode
			int curGroup = visited.get(curNode);
			// the group assigned for any neighbor of the curNode
			int neiGroup = curGroup == 0 ? 1 : 0;
		
			for(GraphNode neiNode: curNode.neighbors){
				// if the neighbor has not been visited, just put it in the queue and choose the correct group
				if(!visited.containsKey(neiNode)){
					visited.put(neiNode, neiGroup);
					queue.offer(neiNode);
				}else if(visited.get(neiNode) != neiGroup) {
				// only if the neighbor has been traversed and the group does not match
				//and the group does not match it should be, return false
					return false;					
				}//if the neighbor has been traversed and the group matches the desired one,
				// we do not need to do anything
			}
		}		
		return true;
	}
	//step1: offer the first node into a queue, mark it as visited
	// step2: expand the first node, then generate its neighbors: 
	//case1: for the neighbors have not been visited, mark them as visited.
	//case2: for the neighbors who have been visited, check their color if valid,if not return false; if valid continue. 
//	for valid checking: use two sets to conclude  nodes into two groups
	// step3: all the nodes have been visited without invalid, return true
	public boolean BFS(GraphNode node) {
		
	    Queue<GraphNode> queue = new LinkedList<>();
	    Set<GraphNode> set1 = new HashSet<>();
	    Set<GraphNode> set2 = new HashSet<>();
	    queue.offer(node);
	    set1.add(node);
	    while(!queue.isEmpty()){
	      GraphNode curNode = queue.poll();
	      if(set1.contains(curNode)) {
	    	  for(GraphNode nodeNei: node.neighbors){
			      if(!set1.contains(nodeNei) && !set2.contains(nodeNei)) {
			    	  set2.add(nodeNei);
			    	  queue.offer(nodeNei);
			      }else if(set1.contains(nodeNei)) {
			    	  return false;
			      }
		      }
	      }else if(set2.contains(curNode)) {
	    	  for(GraphNode nodeNei: curNode.neighbors){
			      if(!set1.contains(nodeNei) && !set2.contains(nodeNei)) {
			    	  set1.add(nodeNei);
			    	  queue.offer(nodeNei);
			      }else if(set2.contains(nodeNei)) {
			    	  return false;
			      }
		      }
	      }
	    }
	    return true;
	}
	 
	 public class GraphNode {
		    public int key;
		    public List<GraphNode> neighbors;
		    public GraphNode(int key) {
		      this.key = key;
		      this.neighbors = new ArrayList<GraphNode>();
		    }
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Bipartite bi = new Bipartite();
		
		bi.isBipartite(null);
	}

}
