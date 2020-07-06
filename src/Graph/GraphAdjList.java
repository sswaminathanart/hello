package Graph;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphAdjList {


    static class Vertex {
        int label;
        List<Vertex> neighbors;

        Vertex(int v) {
            this.label = v;
            this.neighbors = new ArrayList<>();
        }

        @Override
        public String toString() {
            String output = label + "--> [";
            for (Vertex v : neighbors) {
                output = output + v.label + " , ";
            }
            output = output.substring(0,output.length()-3) + "]";
            return output;
        }


    }
    public static void addEdge(int u,int v, boolean biDirection) {
        Vertex vertex = adjList.get(u);
        vertex.neighbors.add(adjList.get(v));
        if(biDirection) {
            vertex = adjList.get(v);
            vertex.neighbors.add(adjList.get(u));
        }

    }
    //connected graph
    static boolean isEulerianPaths(Map<Integer, Vertex> adjList) {

        int oddVertaxCount = 0;
        for (int i=1;i<12 && oddVertaxCount <3;i++) {
            if(adjList.get(i).neighbors.size() % 2 == 1) {
                oddVertaxCount++;
            }
        }
        return oddVertaxCount== 0 || oddVertaxCount == 2;
    }

    //connected graph
    static boolean isEulerianCycle(Map<Integer, Vertex> adjList) {

        int oddVertaxCount = 0;
        for (int i=1;i<12 && oddVertaxCount <1;i++) {
            if(adjList.get(i).neighbors.size() % 2 == 1) {
                oddVertaxCount++;
            }
        }
        return oddVertaxCount== 0;
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
        for (int i=1;i<12;i++) {
            System.out.println(adjList.get(i));
        }
        System.out.println("Eulerian Path " +isEulerianPaths(adjList));
        System.out.println("Eulerian Cycle " +isEulerianCycle(adjList));

    }
}

