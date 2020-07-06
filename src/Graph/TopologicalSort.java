package Graph;

import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.Stack;
import java.util.Vector;

public class TopologicalSort {
    static Map<String,Vertex> adjList = new HashMap<>();
    static class Vertex{
        String label;
        Set<Vertex> neighbours;
        Vertex(String l){
            label = l;
            neighbours = new HashSet<>();
        }
        @Override
        public String toString(){
            String str = label+"--> [";
            int i = 1;
            for(Vertex v: neighbours){
                if(i != neighbours.size())str += v.label+",";
                else str += v.label;
                i++;
            }
            str += "]";
            return str;
        }
    }
    public static void addEdge(String u,String v){
        Vertex vertex = adjList.get(u);
        vertex.neighbours.add(adjList.get(v));
    }
    public static void main(String args[]){
        adjList.put("a",new Vertex("a"));
        adjList.put("b",new Vertex("b"));
        adjList.put("c",new Vertex("c"));
        //adjList.put("d",new Vertex("d"));
        adjList.put("e",new Vertex("e"));
        adjList.put("f",new Vertex("f"));
        //adjList.put("g",new Vertex("g"));
        adjList.put("h",new Vertex("h"));
        addEdge("a","b");
        addEdge("b","c");
        addEdge("c","e");
        addEdge("e","h");
        addEdge("b","f");
        addEdge("f","b");
        for(Map.Entry<String,Vertex> m : adjList.entrySet()){
            System.out.println(m.getValue());
        }
        topologicalSort1(adjList);
    }
    static Map<Vertex, Integer> inDegreeCount (Map<String,Vertex> adjList) {
        Map<Vertex, Integer> inDegree = new HashMap<>();
        for (Map.Entry<String,Vertex> m : adjList.entrySet()){
            inDegree.put(m.getValue(),0);
        }
        for (Map.Entry<String,Vertex> m : adjList.entrySet()){
            for (Vertex nei : m.getValue().neighbours) {
                inDegree.put(nei,inDegree.get(nei)+1);
            }
        }
        return inDegree;
    }
    static void topologicalSort(Map<String,Vertex> adjList) {
        Map<Vertex, Integer> inDegree = inDegreeCount(adjList);
        Queue<Vertex> queue = new LinkedList<>();
        for (Map.Entry<Vertex,Integer> m : inDegree.entrySet()) {
            if(m.getValue() ==0) {
                queue.add(m.getKey());
            }
        }
        int countVertex = 0;
        Vector<Vertex> topOrder = new Vector<>();
        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            topOrder.add(curr);
            countVertex++;
            for (Vertex nei : curr.neighbours) {
                inDegree.put(nei,inDegree.get(nei)-1);
                if(inDegree.get(nei)==0) {
                    queue.add(nei);
                }
            }
        }
        if(countVertex == adjList.size()) {
            for (Vertex v : topOrder){
                System.out.println(v.label);
            }
        }
        else {
            System.out.println("Top Sort is not possible");
        }
    }

    static void topologicalSort1(Map<String,Vertex> adjList) {
        Set<Vertex> seen = new HashSet<>();
        Stack<Vertex> top = new Stack<>();
        boolean isCycle = true;
        for (Map.Entry<String, Vertex> m : adjList.entrySet()) {
            if(!seen.contains(m.getValue())) {
                explore(m.getValue(), seen, top);
            }
        }
        if(!top.empty()) {
            while (!top.empty()) {
                System.out.println(top.pop().label);
            }
        }
        else {
            System.out.println("Not Possible");
        }
    }
    static void explore(Vertex curr,Set<Vertex> seen, Stack<Vertex> top) {
        seen.add(curr);
        for (Vertex nei : curr.neighbours) {
            if(!seen.contains(nei)) {
                explore(nei,seen,top);
            }
        }
        top.push(curr);


    }

}
