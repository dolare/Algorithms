package Tree;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class LC222CountCompleteTreeNode {
	  public int countNodes(TreeNode root) {  
		  if(root == null){
	            return 0;
	        }
	        
	        int leftHeight = 1;
	        int rightHeight = 1;
	        
	        TreeNode left = root;
	        TreeNode right = root;
	        
	        while(left.left != null){
	            leftHeight++;
	            left = left.left;
	        }
	        
	        while(right.right != null){
	            rightHeight++;
	            right = right.right;
	        }
	        
	        if(rightHeight == leftHeight){
	        	System.out.println(1 << rightHeight - 1);
	            return 1 << rightHeight - 1;
	        }
	        
	        return countNodes(root.left) + countNodes(root.right) + 1;
	    }  
	  
	  
	  public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
			
		root.assignData();
		
		System.out.print(new LC222CountCompleteTreeNode().countNodes(root));
			
	}
}
