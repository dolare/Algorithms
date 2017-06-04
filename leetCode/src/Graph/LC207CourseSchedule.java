import java.util.*;

/**
 * Created by RuiY on 2017/5/14.
 */
public class LC207CourseSchedule {
    public static void main(String[] args){
        LC207CourseSchedule solution = new LC207CourseSchedule();

        int[][] test1 = {{0,1},{2,3},{3,1}};
        System.out.println(solution.canFinish(4,test1));

        //int[][] test2 = {{0,1},{1,2}};
        //System.out.println(solution.canFinish(3,test2));
    }
    public boolean canFinish(int numCourses, int[][] prerequisites){
        if(numCourses <= 1){
            return true;
    }

        if(prerequisites.length == 0 || prerequisites[0].length == 0){
            return true;
        }

        Map<Integer,Set<Integer>> graph = new HashMap<>();

            for(int i = 0;i < numCourses;i++){
                graph.put(i, new HashSet<Integer>());
            }

            for(int i = 0;i < prerequisites.length;i++){
                graph.get(prerequisites[i][0]).add(prerequisites[i][1]);
            }

            Queue<Integer> queue = new LinkedList<>();
            int courseRemaning = numCourses;

            //find the root of the graph which dont require a prerequisite
            for(Map.Entry<Integer,Set<Integer>> entry : graph.entrySet()){
                if(entry.getValue().size() == 0){
                    queue.offer(entry.getKey());
                    courseRemaning--;
                }
            }


            while(!queue.isEmpty()){
            int key = queue.poll();
            for(Map.Entry<Integer,Set<Integer>> entry : graph.entrySet()){
                if(entry.getValue().contains(key)){
                    entry.getValue().remove(key);
                    if(entry.getValue().size() == 0){
                        queue.offer(entry.getKey());
                        courseRemaning--;
                    }
                }
            }
        }

        return courseRemaning == 0;
    }
}
