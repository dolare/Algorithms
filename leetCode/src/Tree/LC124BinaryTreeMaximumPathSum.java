package Tree;

/**
 * Created by RuiY on 2017/5/24.
 */
public class LC124BinaryTreeMaximumPathSum {
    /*
    * for each node there can be four ways that
    * 1. node only
    * 2. max path through right child + node
    * 3. max path through left child + node
    * 4. max path through let child + node  + max path through right child
    *
    *
    * A path from start to end, goes up on the tree for 0 or more steps,then goes down for
    * 0 or more steps, once it goes down, it cant go up. each path has a highest
    * node, which is also the lowest common ancestor of all the other node on the path
    * a recursive method maxpathdown 1. computes the maximum path sum with highest node is
    * the input node, update the maximum if necessary 2. returns the maximum sum of the path that
    * can be extended to input node's parent
    * */
    int maxValue;
    public static void main(String[] args){
        TreeNode node = new TreeNode();
        node.assignData();

        new LC124BinaryTreeMaximumPathSum().maxPathSum(node);

    }

    public int maxPathSum(TreeNode root){
        maxValue = Integer.MIN_VALUE;
        this.maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node){
        if(node == null){
            return 0;
        }

        int left = Math.max(0,maxPathDown(node.left));
        int right = Math.max(0,maxPathDown(node.right));
        maxValue = Math.max(this.maxValue,left + right + node.val);
        return Math.max(left,right) + node.val;
    }
}
