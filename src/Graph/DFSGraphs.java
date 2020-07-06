package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class DFSGraphs {
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

    static Map<Integer, Vertex> adjList = new HashMap<>();
    static void addEdge(int u, int v, boolean biDirectoin) {
        Vertex uVertex = adjList.get(u);
        Vertex vVertex = adjList.get(v);
        uVertex.neighbours.add(vVertex);
        if(biDirectoin) {
            vVertex.neighbours.add(uVertex);
        }
    }

    static void exploreWithConnectedComp(Vertex v,int[] seen,int connectedComp) {
        seen[v.label] = connectedComp;
        for (Vertex nei : v.neighbours) {
            if(seen[nei.label] == 0) {
                exploreWithConnectedComp(nei, seen, connectedComp);
            }
        }
    }

    static void dfs(Map<Integer, Vertex> adjList) {
        final Set<Vertex> seen = new HashSet<>();
        for(Map.Entry<Integer, Vertex> curr : adjList.entrySet()) {
            final List<Integer> comp = new ArrayList<>();
            if(!seen.contains(curr.getValue())) {
                explore(curr.getValue(), seen, comp);
                for (Integer i : comp) {
                    System.out.println(i);
                }
            }
        }
    }

    static void explore(Vertex v,Set<Vertex> seen,List<Integer> comp) {
        seen.add(v);
        comp.add(v.label);
        for (Vertex nei : v.neighbours) {
            if(!seen.contains(nei)) {
                explore(nei, seen, comp);
            }
        }
    }

    static void explore(Vertex v,int[] seen) {
        seen[v.label] = 1;
        for (Vertex nei : v.neighbours) {
            if(seen[nei.label] == 0) {
               explore(nei, seen);
            }
        }
    }
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
        //addEdge(10, 11, true);
       // addEdge(8, 11, true);
        for (int i = 1; i < 12; i++) {
            System.out.println(adjList.get(i));
        }
        dfs(adjList);
        System.out.println("\n\n\n");
        int[] seen = new int[adjList.size()+1];
        for (int i=0;i<seen.length;i++) {
            seen[i] = 0;
        }
        int connectedComp = 0;
        for(int i=1;i<seen.length;i++) {
            Vertex curr = adjList.get(i);
            if (seen[curr.label] == 0) {
                connectedComp = connectedComp +1;
                exploreWithConnectedComp(curr, seen, connectedComp);
            }
        }
        for (int i=1;i<seen.length;i++) {
            System.out.println(seen[i]);
        }
        for (int i=0;i<seen.length;i++) {
            seen[i] = 0;
        }
        System.out.println("\n\n\n");
        explore(adjList.get(1), seen);
        for (int i=1;i<seen.length;i++) {
            System.out.println(seen[i]);
        }
    }
}
