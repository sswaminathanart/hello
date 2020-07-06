package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSCloneAGraphs {
    static class Vertex {
        int label;
        List<Vertex> neighbours;
        Vertex(int lable) {
            this.label = lable;
            neighbours = new ArrayList<>();
        }
        @Override
        public String toString() {
            String output = label + "--> [";
            for (Vertex v : neighbours) {
                output = output + v.label + " , ";
            }
            output = output.substring(0,output.length()-3) + "]";
            return output;
        }
    }

    static void addEdge(int u, int v, boolean biDirectoin) {
        Vertex uVertex = adjList.get(u);
        Vertex vVertex = adjList.get(v);
        uVertex.neighbours.add(vVertex);
        if(biDirectoin) {
            vVertex.neighbours.add(uVertex);
        }
    }
    static Map<Integer,Vertex> cloneAVertex(Vertex source) {
        Queue<Vertex> q = new LinkedList<>();
        Vertex sourceClone = new Vertex(source.label);
        Map<Integer,Vertex> cloneMap = new HashMap<>();
        q.add(source);
        cloneMap.put(source.label,sourceClone);
        while (!q.isEmpty()) {
            Vertex curr = q.poll();
            for (Vertex nei : curr.neighbours) {
                Vertex neiClone = new Vertex(nei.label);
                cloneMap.get(curr.label).neighbours.add(neiClone);
                if (!cloneMap.containsKey(nei.label)) {
                    cloneMap.put(nei.label,neiClone);
                    q.add(nei);
                }

            }
        }
        return cloneMap;
    }
    static Map<Integer, Vertex> adjList = new HashMap<>();
    public static void main(String args[]) {

        for (int i = 1; i <= 11; i++) {
            adjList.put(i, new Vertex(i));
        }
        addEdge(1, 2, true);
        addEdge(1, 3, true);
        addEdge(2, 3, true);
        addEdge(2, 4, true);
        addEdge(2, 8, true);
        addEdge(3, 4, true);
        addEdge(3, 5, true);
        addEdge(5, 6, true);
        addEdge(5, 7, true);
        addEdge(5, 8, true);
        addEdge(6, 9, true);
        addEdge(7, 9, true);
        addEdge(7, 10, true);
        addEdge(8, 9, true);
        addEdge(10, 11, true);
        addEdge(8, 11, true);
        for (int i = 1; i < 12; i++) {
            System.out.println(adjList.get(i));
        }
        System.out.println("\n\n");
        Map<Integer,Vertex>  cloneAdjList = cloneAVertex(adjList.get(1));
        for (int i = 1; i < 12; i++) {
            System.out.println(cloneAdjList.get(i));
        }
    }
}
