package Tree;

public class CountTreeNodes {
	public static int countTreeNodes(TreeNode root){
		
		
		if(root == null){
			return 0;
		}
		
		//System.out.println(root.val);
		int count = countTreeNodes(root.left) + countTreeNodes(root.right) + 1;
		System.out.println(count);
		return count;
	}
	
	
	
	public static void main(String[] args) {
		TreeNode root = new TreeNode(1);
		
		root.assignData();
		
		System.out.println(countTreeNodes(root));
	}
}
