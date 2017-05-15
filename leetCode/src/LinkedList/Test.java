package LinkedList;

public class Test {
	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode a1 = new ListNode(2);
		ListNode a2 = new ListNode(3);
		ListNode a3 = new ListNode(4);
		ListNode a4 = new ListNode(3);
		ListNode a5 = new ListNode(2);
		ListNode a6 = new ListNode(1);
		
		headA.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		
		ListNode headB = headA;
		headB = headB.next;
		
		System.out.println(headA.val);
		System.out.println(headA.next.val);
		System.out.println(headB.val);
		
	}
}
