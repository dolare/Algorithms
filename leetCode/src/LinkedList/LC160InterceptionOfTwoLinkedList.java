package LinkedList;
import LinkedList.ListNode;

import java.lang.reflect.Method;

import javax.naming.spi.DirStateFactory.Result;

public class LC160InterceptionOfTwoLinkedList {
	 /*Method 1:  time complexity : O(n +¡¡£í)£¬¡¡space complexity: O(1)
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if (headA == null || headB == null) {
	            return null;
	        }
	        
	        // get the tail of list A.
	        ListNode node = headA;
	        if(node == headA){
	        	System.out.println("True");
	        }
	        while (node.next != null) {
	            node = node.next;
	        }
	        node.next = headB;
	        ListNode result = listCycleII(headA);
	        node.next = null;
	        return result;
	    }
	    
    private ListNode listCycleII(ListNode head) {
        ListNode slow = head, fast = head.next;
        
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return null;
            }
            
            slow = slow.next;
            fast = fast.next.next;
            System.out.print("slow:" + slow.val);
            System.out.println("fast:" + fast.val);
        
        }
        
        System.out.print("------");
        
        slow = head;
        fast = fast.next;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
            System.out.print("slow:" + slow.val);
            System.out.println("fast:" + fast.val);
        }
        
        return slow;
    }*/
    
	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA == null || headB == null){
	            return null;
	        }
	        
	        int lenA = getLengthOfList(headA);
	        int lenB = getLengthOfList(headB);
	        
	        ListNode a = headA;
	        ListNode b = headB;
	        
	        while(lenA > lenB){
	            a = a.next;
	            lenA--;
	        }
	        while(lenA < lenB){
	            b = b.next;
	            lenB--;
	        }
	        
	        while(a != null && b!= null){
	            if(a == b){
	                return a;
	            }
	            a = a.next;
	            b = b.next;
	        }
	        
	       
	        return null;
	    }
	    
	    public int getLengthOfList(ListNode head){
	        if(head == null){
	            return 0;
	        }
	        
	        int len = 1;
	        ListNode node = head;
	        while(node.next != null){
	            len++;
	            node = node.next;
	        }
	        
	        return len;
	    }
	    
    public static void main(String[] args) {
		ListNode headA = new ListNode(0);
		ListNode a1 = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode a3 = new ListNode(3);

		ListNode a5 = new ListNode(5);
		ListNode a6 = new ListNode(6);
		
		ListNode ab = new ListNode(4);
		
		headA.next = a1;
		a1.next = a2;
		a2.next = a3;
		a3.next = ab;
		ab.next = a5;
		a5.next = a6;
		
		ListNode headB = new ListNode(0);
		ListNode b1 = new ListNode(7);
		ListNode b2 = new ListNode(8);
		
		headB.next = b1;
		b1.next = b2;
		b2.next = ab;
		
		LC160InterceptionOfTwoLinkedList solution = new LC160InterceptionOfTwoLinkedList();
		ListNode result = solution.getIntersectionNode(headA, headB);
		
		System.out.println(result.val);
	
	}
}
