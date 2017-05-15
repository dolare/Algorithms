package LinkedList;

public class LC234PalindromLinkedList {
	public boolean isPalindrome(ListNode head) {
        if(head == null){
            return true;
        }
        
        ListNode mid = findMiddle(head);
        
        ListNode tail = reverseList(mid.next);
        System.out.println(head.val);
        System.out.println(tail.val);
        
        while(head != null && tail != null && head.val == tail.val){
        	System.out.println(head.val + " " + tail.val);
            tail = tail.next;
            head = head.next;
        }
        
        return (tail == null);
        
    }
    
    public ListNode findMiddle(ListNode head){
        if(head == null){
            return null;
        }
        
        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;
        }
        
        System.out.println(slow.val);
        
        return slow;
    }
    
    public ListNode reverseList(ListNode head){
        if(head == null){
            return null;
        }
        
        ListNode prev = null;
        
        while(head != null){
            ListNode temp = head.next;
            head.next = prev;
            prev = head;
            head = temp;
        }
        
        return prev;
    }
    
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
		
		
		LC234PalindromLinkedList test = new LC234PalindromLinkedList();
		
		System.out.println(test.isPalindrome(headA));
		
	}
}
