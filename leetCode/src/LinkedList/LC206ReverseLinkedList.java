package LinkedList;

import javax.swing.table.TableModel;

public class LC206ReverseLinkedList {
	public ListNode reverseList(ListNode head){
		ListNode prev = null;
		ListNode curr = head;
		
		while(curr != null){
			
			ListNode nextTemp = curr.next;
			curr.next = prev;
			prev = curr;
			curr = nextTemp;
			
			System.out.print("prev:" + prev + " ");
			System.out.print("curr:" + curr + " ");
			System.out.println();
		}
		
		return prev;
	}
	
	public static void main(String[] args) {
		ListNode headA = new ListNode(0);
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);
		ListNode a4 = new ListNode(4);
		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		
		headA.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
		
		
		LC206ReverseLinkedList testOj = new LC206ReverseLinkedList();
		
		ListNode node = testOj.reverseList(headA);
		
		ListNode temp = node;
		
		while(temp != null){
			System.out.println(temp.val);
			temp = temp.next;
		}
		
		
	}
}



