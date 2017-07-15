package Graph;

import java.util.*;

import static javafx.scene.input.KeyCode.H;

/**
 * Created by RuiY on 2017/6/3.
 */
public class LC444SequenceReconstruction {
    public static void main(String[] args){

    }


    public boolean sequenceReconstruction(int[] org, List<List<Integer>> seqs) {
        Map<Integer,Set<Integer>> graph = new HashMap<>();
        Map<Integer,Integer> indegree = new HashMap<>();

        for(List<Integer> seq:seqs){
            for(int i : seq){
                graph.putIfAbsent(i,new HashSet<>());
                indegree.putIfAbsent(i,0);
            }
        }

        for(List<Integer> seq:seqs){
            if(seq.size() == 1)continue;;
            for(int i = 1;i < seq.size();i++){
                if(graph.get(seq.get(i - 1)).add(seq.get(i))){
                    indegree.put(seq.get(i),indegree.get(seq.get(i)) + 1);
                    System.out.print(indegree.get(seq.get(i)));
                }
            }
        }


        // not all the numbers in the org are in the seqs
        if(org.length != indegree.size()){
            return false;
        }

        Queue<Integer> queue = new LinkedList<>();

        //put the root which level is 0 to the queue
        for(int key: indegree.keySet()){
            if(indegree.get(key) != null && indegree.get(key) == 0){
                queue.add(key);
            }
        }

        int count = 0;
        while(queue.size() == 1){
            for(int next: graph.get(queue.poll())){
                //find the next level which number stored in indegree
                indegree.put(next,indegree.get(next) - 1);
                if(indegree.get(next) == 0){
                    queue.add(next);
                }
            }
            count++;
        }

        return count == indegree.size();
    }
}
