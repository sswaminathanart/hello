package Graph;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DFSGraphsClone {
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
    static Map<Integer, Vertex> dfsClone(Vertex source) {
        Vertex sourceClone = new Vertex(source.label);
        Map<Integer, Vertex> adjListClone = new HashMap<>();
        sourceClone.neighbours.add(dfsVertxClone(source, adjListClone));
        return adjListClone;
    }
    static Vertex dfsVertxClone (Vertex v, Map<Integer, Vertex> adjListClone) {
        if (adjListClone.containsKey(v.label)) return adjListClone.get(v.label);
        Vertex vClone = new Vertex(v.label);
        adjListClone.put(v.label, vClone);
        for (Vertex nei : v.neighbours) {
            vClone.neighbours.add(dfsVertxClone(nei, adjListClone));
        }
        return vClone;
    }

    static void dfsClone(Vertex source, Map<Integer, Vertex> adjListClone) {
        Vertex sourceClone = new Vertex(source.label);
        sourceClone.neighbours.add(dfsVertxClone(source, adjListClone));
    }

    static void cloneGraph (Map<Integer, Vertex> adjList, Map<Integer, Vertex> adjListClone) {
        for (Map.Entry<Integer, Vertex> m : adjList.entrySet()) {
            if(!adjListClone.containsKey(m.getKey())) {
               dfsClone(m.getValue(),adjListClone);
            }
        }
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
        //addEdge(8, 11, true);
        for (int i = 1; i < 12; i++) {
            System.out.println(adjList.get(i));
        }
        Map<Integer, Vertex> adjListClone = new HashMap<>();
        cloneGraph(adjList, adjListClone);
        System.out.println("\n\n");
        for (int i = 1; i < 12; i++) {
            System.out.println(adjListClone.get(i));
        }

    }
}
