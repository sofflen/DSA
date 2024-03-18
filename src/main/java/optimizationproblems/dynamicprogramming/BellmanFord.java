package optimizationproblems.dynamicprogramming;

import utility.GraphVertex;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class BellmanFord {
    public static void main(String[] args) {
        BellmanFord sssp = new BellmanFord();
        List<GraphVertex> verticesList = sssp.generateListOfVertices();
        sssp.findSingeSourceShortestPath(verticesList, 3);
        System.out.println("vertices' distance from source:");
        for (GraphVertex vertex : verticesList) {
            System.out.println("Vertex " + vertex.getId() + " distance: " + vertex.getWeight());
        }
    }

    public void findSingeSourceShortestPath(List<GraphVertex> vertices, int source) {
        for (GraphVertex vertex : vertices) {
            if (source == vertex.getId()) {
                vertex.setWeight(0);
            } else {
                vertex.setWeight(Integer.MAX_VALUE);
            }
        }


        for (int i = 0; i < vertices.size() - 1; i++) {
        boolean isChanged = false;
            for (GraphVertex vertex : vertices) {
                for (Map.Entry<GraphVertex, Integer> next : vertex.getDirectionMap().entrySet()) {
                    if (Integer.MAX_VALUE != vertex.getWeight() && vertex.getWeight() + next.getValue() < next.getKey().getWeight()) {
                        next.getKey().setWeight(vertex.getWeight() + next.getValue());
                        isChanged = true;
                    }
                }
            }
            if (!isChanged) {
                break;
            }
        }
    }

    private List<GraphVertex> generateListOfVertices() {
        List<GraphVertex> vertices = new ArrayList<>();

        GraphVertex one = new GraphVertex(1);
        GraphVertex two = new GraphVertex(2);
        GraphVertex three = new GraphVertex(3);
        GraphVertex four = new GraphVertex(4);
        GraphVertex five = new GraphVertex(5);
        GraphVertex six = new GraphVertex(6);
        GraphVertex seven = new GraphVertex(7);


        one.addNextVertex(two, 6);
        one.addNextVertex(three, 5);
        one.addNextVertex(four, 5);

        two.addNextVertex(five, -1);

        three.addNextVertex(two, -2);
        three.addNextVertex(five, 1);

        four.addNextVertex(three, -2);
        four.addNextVertex(six, -1);

        five.addNextVertex(seven, 3);

        six.addNextVertex(seven, 3);

        vertices.add(one);
        vertices.add(two);
        vertices.add(three);
        vertices.add(four);
        vertices.add(five);
        vertices.add(six);
        vertices.add(seven);

        return vertices;
    }
}
