package Design;

/**
 * Created by Dolare on 2017/9/3.
 */

import java.util.*;

public class LC146LRUCache {
    class Node{
        Node prev;
        Node next;
        int key;
        int value;


        public Node(int key,int value)   {
            this.key = key;
            this.value = value;
            prev = null;
            next = null;
        }
    }

    private final int CAPACITY;
    private HashMap<Integer,Node> map;
    private Node head;
    private Node tail;

    public LC146LRUCache(int capacty) {
        this.CAPACITY = capacty;
        this.head = new Node(-1,-1);
        this.tail = new Node(-1,-1);
        head.next = tail;
        tail.prev = head;
        map = new HashMap<Integer,Node>();
    }

    public int get(int key){
        //see if there is a key
        Node node = map.get(key);
        if(node == null){
            return -1;
        }

        //step1: remove the node from list
        remove(node);

        //step2: insert the node into the head
        insert(node);

        return node.value;
    }

    public void put(int key, int value){
        //see if it exists in the list
        Node node = map.get(key);

        if(node == null){
            node = new Node(key,value);
            map.put(key,node);
            insert(node);
        }else{
            node.value = value;
            remove(node);
            insert(node);
        }

        if(map.size() > CAPACITY){
            map.remove(tail.key);
            remove(tail);
        }

    }

    public void remove(Node node){
        Node before = node.prev;
        Node after = node.next;
        before.next = after;
        after.prev = before;
    }

    public void insert(Node node){
        Node curr = head;
        head = node;
        head.next = curr;
    }


/*    //use the build-in clss LinkedHashMap
    private LinkedHashMap<Integer,Integer> map;
        private final int CAPACITY;

    public LC146LRUCache(int capacity){
            this.CAPACITY = capacity;
            this.map = new LinkedHashMap<Integer,Integer>(capacity,0.75f,true){
                protected boolean removeEldestEntry(Map.Entry eldest){
                    return size() > CAPACITY;
                }
            };
        }

    public int get(int key){
        map.getOrDefault(key,-1);
    }

    public void set(int key, int value){
        map.put(key,value);
    }*/


    public static void main(String[] args){
        LC146LRUCache cache = new LC146LRUCache( 2 /* capacity */ );

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4


    }
}
