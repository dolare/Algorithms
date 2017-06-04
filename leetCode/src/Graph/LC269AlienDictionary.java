package Graph;

import java.io.*;
import java.util.*;


class LC269AlienDictionary{
    public static void main(String[] args){
        //build graph
        //topsort,BFS

        //t<f, w < e, e < r.r < t
        //==> w e r t f

        //letter ===> vertex
        String[] words = {"wrt","wrf","er","ett","rftt"};
        System.out.print(alienOrder(words));
    }

    private static String alienOrder(String[] words){
        StringBuilder sb = new StringBuilder(0);

        if(words == null || words.length == 0){
            return sb.toString();
        }

        if(words.length == 1){
            return words[0];
        }

        Map<Character,Set<Character>> graph = new HashMap<>();

        buildGraph(words,graph);

        //topo sort
        topSort(sb,graph);



        return sb.toString();


    }

    private static void topSort(StringBuilder sb,Map<Character,Set<Character>> graph){
        Queue<Character> queue = new LinkedList<>();

        int totalVertex = 0;

        for(Map.Entry<Character,Set<Character>> entry : graph.entrySet()){
            if(entry.getValue().size() == 0){
                queue.offer(entry.getKey());
                totalVertex++;
            }
        }

        while(!queue.isEmpty()){
            char c = queue.poll();
            sb.append(c);

            for(Map.Entry<Character,Set<Character>> entry : graph.entrySet()){
                if(entry.getValue().contains(c)){
                    entry.getValue().remove(c);
                    if(entry.getValue().size() == 0){
                        queue.offer(entry.getKey());
                        totalVertex++;
                    }
                }
            }

        }

        if(totalVertex != graph.size()){
            sb.setLength(0);
        }

    }

    private static void buildGraph(String[] words,Map<Character,Set<Character>> graph){
        for(int i = 0;i < words.length - 1;i++){
            String s1 = words[i];
            String s2 = words[i+1];

            addWords(s1,s2,graph);
        }
    }

    private static void addWords(String s1,String s2,Map<Character,Set<Character>> graph){
        int i = 0;
        int j = 0;

        while(i < s1.length() && j < s2.length()){
            char c1 = s1.charAt(i);
            char c2 = s2.charAt(j);

            if(!graph.containsKey(c1)){
                graph.put(c1,new HashSet<Character>());
            }

            if(!graph.containsKey(c2)){
                graph.put(c2,new HashSet<Character>());
            }

            if(c1 == c2){
                i++;
                j++;
            }else{
                graph.get(c2).add(c1);
                break;
            }
        }

        while(i < s1.length()){
            char c = s1.charAt(i);
            if(!graph.containsKey(c)){
                graph.put(c,new HashSet<Character>());
            }
            i++;
        }

        while(j < s2.length()){
            char c = s2.charAt(j);
            if(!graph.containsKey(c)){
                graph.put(c,new HashSet<Character>());
            }
            j++;
        }
    }
}


