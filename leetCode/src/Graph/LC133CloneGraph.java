
import java.util.*;

public class LC133CloneGraph {
    private static Map<Integer,UndirectedGraphNode> map = new HashMap<>();
    public static void main(String[]  args){
        UndirectedGraphNode node0 = new UndirectedGraphNode(0);
        UndirectedGraphNode node1 = new UndirectedGraphNode(1);
        UndirectedGraphNode node2 = new UndirectedGraphNode(2);
    }
    public static UndirectedGraphNode cloneGraph(UndirectedGraphNode node){
        if(node == null){
            return null;
        }

        if(map.containsKey(node.label)){
            return map.get(node.label);
        }

        UndirectedGraphNode clone = new UndirectedGraphNode(node.label);
        map.put(clone.label,clone);
        for(UndirectedGraphNode neighbor: node.neighbors){
            clone.neighbors.add(cloneGraph(neighbor));
        }

        return clone;
    }


    public static UndirectedGraphNode cloneGraphBFS(UndirectedGraphNode root) {
        if (root == null) {
            return null;
        }

        //use a queue to help BFS
        Queue<UndirectedGraphNode> queue = new LinkedList<>();
        queue.add(root);

        //use a map to save visited nodes
        Map<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();

        map.put(root, new UndirectedGraphNode(root.label));

        while (!queue.isEmpty()) {
            UndirectedGraphNode node = queue.poll();

            //handle the neightbors
            for (UndirectedGraphNode neighbor : node.neighbors) {
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));

                    queue.add(neighbor);
                }

                //add a neighbor
                map.get(node).neighbors.add(map.get(neighbor));
            }
        }
        return map.get(root);
    }
}
