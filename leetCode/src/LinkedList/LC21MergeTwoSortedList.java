package LinkedList;

import java.awt.Label;

public class LC21MergeTwoSortedList {
	 public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
	        if(l1 == null) return l2;
	        if(l2 == null) return l1;
	    
	        if(l1.val < l2.val) {
	        	System.out.println(l1.val + " " + l2.val);
	            l1.next = mergeTwoLists(l1.next, l2);
	            return l1;
	        } else {
	        	System.out.println(l1.val + " " + l2.val);
	            l2.next = mergeTwoLists(l2.next, l1);
	            return l2;
	        }
	  }
	 
	 public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode a1 = new ListNode(3);
		ListNode a2 = new ListNode(5);
		ListNode a3 = new ListNode(7);
		ListNode a4 = new ListNode(9);
		ListNode a5 = new ListNode(11);
		ListNode a6 = new ListNode(13);
		
		headA.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = a4;
		a4.next = a5;
		a5.next = a6;
			
		ListNode headB = new ListNode(0);
		ListNode b1 = new ListNode(2);
		ListNode b2 = new ListNode(4);
		ListNode b3 = new ListNode(6);
		ListNode b4 = new ListNode(7);
		ListNode b5 = new ListNode(9);
		ListNode b6 = new ListNode(10);
		
		headB.next = b1;
		b1.next = b2;
		b2.next = b3;
		a3.next = b4;
		b4.next = b5;
		b5.next = b6;
		
		LC21MergeTwoSortedList test = new LC21MergeTwoSortedList();
		ListNode mergeAB = test.mergeTwoLists(headA, headB);
		
		/*while(mergeAB != null){
			System.out.println(mergeAB);
			mergeAB = mergeAB.next;
		}*/
		
		
		
	}
}
