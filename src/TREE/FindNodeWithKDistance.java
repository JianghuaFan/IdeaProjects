package TREE;
/*
given a binary tree, a target node, and value K.

Return a list of the values of all nodes that have a distance K from the target node.



Example 1:

Input: root = [3,5,1,6,2,0,8,null,null,7,4], target = 5, K = 2

Output: [7,4,1]



 */
import OOD.OverRide;

import java.util.*;

public class FindNodeWithKDistance {
    // highlevel: convert the tree to an undirected graph(BFS or DFS)
    // start from target node, traverse the graph(BFS), add all the node's key with k levels from target node to the result list

    // step 1: convert tree into graph
    // step 2: BFS traverse the graph, start from target,
    // expansion and generation: check whether the node has been generated before， if yes continue else if k == level, add to result
    public List<Integer> find(TreeNode root, Integer target, int k){
        List<Integer> res = new ArrayList<>();
        if(root == null || target == null){
            return res;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        buildGraphDFS(root, graph, null );
        for(Map.Entry entry : graph.entrySet()){
            System.out.print("key: " + entry.getKey());
            System.out.println("  value:" + entry.getValue());
        }
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(target);
        Set<Integer> visited = new HashSet<>();
        int level = 0;
        // BFS, find all the nodes that have distance of k from target node
        while(!queue.isEmpty()) {
            int size = queue.size();
//            System.out.println("visited" + visited);
//            System.out.println("queue" + queue);
            for (int i = 0; i < size; i++) {
                Integer cur = queue.poll();
                if (!visited.add(cur)) {
                    continue;
                }
                if (level == k) {
                    res.add(cur);
                }
                for (Integer nei : graph.get(cur)) {
                    queue.offer(nei);
                }
            }
            level++;
        }
        return res;
    }

    private Map<Integer, List<Integer>> buildGraphBFS(TreeNode root) {
        // BFS convert the tree into a graph, graph是个map， key是所有节点，value是每个节点的neighbor。
        // 从根开始，做BFS，给neighbor添加左孩子（不空的话），添加右孩子，反过来给左右孩子把自加添加到左右孩子的neighbor里
        Map<Integer, List<Integer>> map = new HashMap<>();
        // initiate the graph
        Queue<TreeNode> queue = new ArrayDeque<>();
        queue.offer(root);
        while(!queue.isEmpty()){
            TreeNode cur = queue.poll();
            map.putIfAbsent(cur.key, new ArrayList<>());
            List<Integer> nei = map.get(cur.key);
            // left child
            if(cur.left != null){
                nei.add(cur.left.key);
                queue.offer(cur.left);
                map.putIfAbsent(cur.left.key, new ArrayList<>());
                map.get(cur.left.key).add(cur.key);
            }
            if(cur.right != null){
                nei.add(cur.right.key);
                queue.offer(cur.right);
                map.putIfAbsent(cur.right.key, new ArrayList<>());
                map.get(cur.right.key).add(cur.key);
            }
        }
        System.out.println("map" + map);
        return map;
    }

    public void buildGraphDFS(TreeNode root, Map<Integer, List<Integer>> map, TreeNode parent){
        // base case:
        if(root == null){
            return;
        }
        //
        map.putIfAbsent(root.key, new ArrayList<>());
        if(parent != null){
            map.get(root.key).add(parent.key);
        }
        if(root.left != null){
            // 以下两步顺序调整对结果没有影响
            map.get(root.key).add(root.left.key);
            buildGraphDFS(root.left, map, root);

        }
        if(root.right != null){
            map.get(root.key).add(root.right.key);
            buildGraphDFS(root.right, map, root);

        }
    }
    private void print(Map<Integer, List<Integer>> graph){
        for(Map.Entry entry : graph.entrySet()){
            System.out.print("key:" + entry.getKey());
            System.out.println("value:" + entry.getValue());
        }
    }

    public Map<Integer, List<Integer>> build(TreeNode root){
        if(root == null){
            return null;
        }
        Map<Integer, List<Integer>> graph = new HashMap<>();
        TreeNode prev = root;
        DFS(root, graph,prev);
        return graph;
    }

    public void DFS(TreeNode node, Map<Integer, List<Integer>> graph, TreeNode prev){
        if(node == null){
            return;
        }
        graph.putIfAbsent(node.key, new ArrayList<>());
// corner case
        if(prev != null){
            graph.get(node.key).add(prev.key);

        }
// step 1: what do you ask from children,
        if(node.left != null){
            DFS(node.left, graph, node);
            graph.get(node.key).add(node.left.key);
        }

        if(node.right != null){
            DFS(node.right, graph, node);
            graph.get(node).add(node.right.key);
        }

// step 2: what do you do? build current node into graph

    }


    public static void main(String[] args) {
//        Integer[] array = {3,5,1,6,2,0,8,null,null,7,4};
        Integer[] array = {5,2,8,3,1,4};
        TreeNode[] nodes = Tree.arrayToTreeNodes(array);
        Tree.createTreeAsLevel(nodes);
        TreeNode root = nodes[0];
        int target = 5;
        int k = 2;
        Tree.PrintLayerByLayer(root);
        FindNodeWithKDistance findNodeWithKDistance = new FindNodeWithKDistance();
        System.out.println(findNodeWithKDistance.find(root, target, k));
    }
}
