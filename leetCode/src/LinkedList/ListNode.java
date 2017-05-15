package LinkedList;

public class ListNode {
	int val;
	ListNode next;
	public ListNode(int val){
		this.val = val;
		next = null;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return Integer.toString(val);
	}
}
