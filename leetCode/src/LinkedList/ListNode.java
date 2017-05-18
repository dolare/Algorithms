package LinkedList;

public class ListNode {
	public int val;
	public ListNode next;
	public ListNode(){

	}
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
