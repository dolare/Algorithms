
 
import java.util.ArrayList;
import java.util.NoSuchElementException;
import java.util.Scanner;
 
public class MaxHeap<T extends Comparable<T>> {
     
    private ArrayList<T> items;
     
    public MaxHeap() {
        items = new ArrayList<T>();
    }
    
    public static void main(String[] args){
    	
    	MaxHeap<Integer> hp1 = new MaxHeap<Integer>();
    	
    	
    	for(int i = 0;i <= 10;i++){
    		hp1.insert(i);
    	}
    	hp1.removeMax();
    	System.out.println(hp1);
    	
    	
    	Scanner sc = new Scanner(System.in);
    	System.out.print("Enter next int,'done' to stop :");;
    	String line = sc.next();
    	
    	
    	while(!line.equals("done")){
    		hp1.insert(Integer.parseInt(line));
    		System.out.println(hp1);
    		System.out.print("enter next int,'done' to stop");
	    		line = sc.next();
	    	}
    	
    	while(!hp1.isEmpty()){
    		int max = hp1.removeMax();
    		System.out.println(max + " " + hp1);
    	}
    	sc.close();
    }
    	
    
    private void softUp() {
        int k = items.size() - 1;
        while (k > 0) {
            int p = (k-1)/2;
            T item = items.get(k);
            T parent = items.get(p);
            if (item.compareTo(parent) > 0) {
                // swap
                items.set(k, parent);
                items.set(p, item);
                 
                // move up one level
                k = p;
            } else {
                break;
            }
        }
    }
     
    public void insert(T item) {
        items.add(item);
        softUp();
    }
     
    private void softDown() {
        int k = 0;
        int l = 2*k+1;
        while (l < items.size()) {
            int max=l, r=l+1;
            if (r < items.size()) {
                if (items.get(r).compareTo(items.get(l)) > 0) {
                    max++;
                }
            }
            if (items.get(k).compareTo(items.get(max)) < 0) {
                    // switch
                    T temp = items.get(k);
                    items.set(k, items.get(max));
                    items.set(max, temp);
                    k = max;
                    l = 2*k+1;
            } else {
                break;
            }
        }
    }
     
    public T removeMax() 
    throws NoSuchElementException {
        if (items.size() == 0) {
            throw new NoSuchElementException();
        }
        if (items.size() == 1) {
            return items.remove(0);
        }
        T hold = items.get(0);
        items.set(0, items.remove(items.size()-1));
        softDown();
        return hold;
    }
 
    public int size() {
        return items.size();
    }
     
    public boolean isEmpty() {
        return items.isEmpty();
         
    }
     
    public String toString() {
        return items.toString();
    }
}