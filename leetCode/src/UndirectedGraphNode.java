import java.util.ArrayList;
import java.util.List;

/**
 * Created by RuiY on 2017/5/12.
 */
class UndirectedGraphNode{
    int label;
    List<UndirectedGraphNode> neighbors;
    UndirectedGraphNode(int x){
        label = x;
        neighbors = new ArrayList<UndirectedGraphNode>();
    }
}
