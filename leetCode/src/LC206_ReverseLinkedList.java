
public class LC206_ReverseLinkedList {
	public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }
	
		
	
	public static void main(String[] args) {
		ListNode node1 = new ListNode(1);
		ListNode node2 = new ListNode(2);
		ListNode node3 = new ListNode(3);
		ListNode node4 = new ListNode(4);
		
		
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;
		
		
		ListNode newNode = new LC206_ReverseLinkedList().reverseList(node1);
		ListNode head = newNode;
		while(head != null){
			System.out.print(head.val);
			head = head.next;
		}
	}
}



