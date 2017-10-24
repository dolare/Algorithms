package Design;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

/**
 * Created by Dolare on 2017/9/9.
 */
public class LC380InsertDeleteGetRandomO1 {
    ArrayList<Integer> nums;
    Map<Integer,Integer> map;
    Random random = new Random();

    //initialize the data structure
    public LC380InsertDeleteGetRandomO1(){
        nums = new ArrayList<>();
        map = new HashMap<>();
    }

    //inserts a value to the set, return true if the set did not already contain the specified element
    public boolean insert(int val){
        if(map.containsKey(val)){
           return false;
        }else{
            map.put(val,nums.size());
            nums.add(val);
        }
        return true;
    }

    //remove the value from set ,return true if set contained the specified element
    public boolean remove(int val){
        if(!map.containsKey(val)){
            return false;
        }else{
            int lastElement = nums.get(nums.size() - 1);
            int index = map.get(val);
            //swap the temp with last element
            nums.set(lastElement,index);
            map.put(index,lastElement);
            map.remove(val);
            nums.remove(nums.size() - 1);
        }
        return true;
    }

    public int getRandom(){
        return nums.get(random.nextInt(nums.size()));
    }
}
