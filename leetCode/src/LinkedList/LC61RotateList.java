package LinkedList;

import java.awt.List;
import java.util.ArrayList;

public class LC61RotateList {
	public ListNode rotateRight(ListNode head, int k){
		if(head == null){
			return null;
		}
		
		int size = getSize(head);
		int index = k;
		
		if(k > size){
			index = size - k%size;
		}
		
		ListNode curr = head;
		
		for(int i = 0; i < k ;i++){
			curr = curr.next;
		}
		
		System.out.println(curr.val);
		
		ListNode temp1 = curr.next;
		ListNode temp2 = curr.next;
		curr.next = null;
		
		while(temp1 != null){
			if(temp1.next == null){
				temp1.next = head;
				System.out.println(1 + " " + temp1.val);
				System.out.println(2 + " " +temp1.next.val);
				return temp2;
			}
			temp1 = temp1.next;
			System.out.println(3 + " " +temp1.val);
		}
		
		return temp2;
		
		
	}
	
	
	public int getSize(ListNode head){
		if(head == null){
			return 0;
		}
		
		int size = 0;
		while(head != null){
			size++;
			head = head.next;
		}
		
		return size;
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
		
		LC61RotateList test = new LC61RotateList();
		ListNode resutl = test.rotateRight(headA, 3);
		//System.out.println(test.getSize(headA));
		while(resutl != null){
			System.out.println(resutl.val);
			resutl = resutl.next;
		}
		/*while(headA != null){
			System.out.println(headA.val);
			headA = headA.next;
		}*/
	}
}
