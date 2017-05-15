package Tree;

public class LC144BinaryTreePreorderTraversal {
	public void preorder(TreeNode root){
		if(root == null){
			return;
		}
		System.out.println(root.val);
		preorder(root.left);
		preorder(root.right);
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.assignData();
		
		new LC144BinaryTreePreorderTraversal().preorder(root);
	}
}
