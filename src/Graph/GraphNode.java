package Graph;
import java.util.List;
import java.util.ArrayList;
public class GraphNode {
	int key;
	List<GraphNode> neighbors;
	public GraphNode(int key) {
		this.key = key;
		neighbors = new ArrayList<>();
	}
}
