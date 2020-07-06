package Graph;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class BFSGraphs {
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

    static int bfs(Vertex start,Vertex end) {
        Queue<Vertex> queue = new LinkedList<>();
        Map<Vertex, Integer> seen = new HashMap<>();
        queue.add(start);
        seen.put(start, 0);
        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            if(curr.label == end.label) {
                return seen.get(curr);
            }
            for (Vertex nei : curr.neighbours) {
                if (!seen.containsKey(nei)) {
                    seen.put(nei,seen.get(curr)+1);
                    queue.add(nei);
                }
            }
        }
        return -1;
    }

    static int bfsArray(Vertex start,Vertex end) {
        Queue<Vertex> queue = new LinkedList<>();
        int[] seen = new int[adjList.size()+1];
        Arrays.fill(seen,-1);
        queue.add(start);
        seen[start.label] = 0;
        while (!queue.isEmpty()) {
            Vertex curr = queue.poll();
            if(curr.label == end.label) {
                return seen[curr.label];
            }
            for (Vertex nei : curr.neighbours) {
                if (seen[nei.label]== -1) {
                    seen[nei.label] = seen[curr.label] + 1;
                    queue.add(nei);
                }
            }

        }
        return -1;
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
        //addEdge(10, 11, true);
        // addEdge(8, 11, true);
        for (int i = 1; i < 12; i++) {
            System.out.println(adjList.get(i));
        }
        System.out.println("\n\n"+bfsArray(adjList.get(1), adjList.get(10)));
    }
}
