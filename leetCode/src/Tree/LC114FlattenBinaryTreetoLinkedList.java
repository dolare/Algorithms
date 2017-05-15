package Tree;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.SystemMenuBar;

public class LC114FlattenBinaryTreetoLinkedList {
	private TreeNode prev = null;

	public void flatten(TreeNode root) {
	    if (root == null)
	        return;
	    //System.out.println(root.val);
	    flatten(root.right);
	    flatten(root.left);
	    System.out.println(root.val);
	    root.right = prev;
	    root.left = null;
	    prev = root;
	}
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.assignData();
		
		new LC114FlattenBinaryTreetoLinkedList().flatten(root);
		/*
		while(root != null){
			System.out.println(root.val);
			root = root.right;
		}*/
	}
	
}
