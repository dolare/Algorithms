package Heap;


import LinkedList.ListNode;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by RuiY on 2017/5/16.
 */

//k lists, N element, using heap(KN * lgk)
    /*There are in gerneral three ways to solve the problem
    the most common way is to use to solve the problem is by keeping a minimum heap
    assuming you are sorting a ascending order, so when we have the minimal heap, all we need
to do is keep the minimul heap size of k and then you keep poppint out the smallest item and
they will turn it to the final list and then because this is a linked list, you know the next
pointers you just add another next pointer to the heap that requires a lg(k) complexity to do the
insert operation.   Assuming there are k lists and each list contains n elements, so with the heap
 the time complexity will be O(KN * lgk)  */

public class LC23MergeKSortedALists {
    public ListNode mergeKLists(ListNode[] lists){
        //let's check the code to super quick
        //do some validation checks
        if(lists == null || lists.length == 0){
            return null;
        }

        int size = lists.length;
        Queue<ListNode> heap = new PriorityQueue<>(size,new ListNodeComparator());

        for(int i = 0;i < size;i++){
            if(lists[i] != null){
                heap.offer(lists[i]);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;

        while(!heap.isEmpty()){
            ListNode node = heap.poll();
            curr.next = node;
            curr = curr.next;
            if(node.next != null){
                heap.offer(node.next);
            }
        }
        return dummy.next;
    }

     class ListNodeComparator implements Comparator<ListNode> {
        public int compare(ListNode o1,ListNode o2){
            assert o1 != null && o2 != null;
            return (o1.val - o2.val);

        }
    }
}

/*
the other two ways , first way is basically to keep merge 2, the time complesity
should be n + 2n + ... kn = O(nk^2)
the second way is to use merge sort, the complexity should be O(NJlgK) without extra space
*/
