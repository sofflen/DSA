package optimizationproblems.dynamicprogramming;

import utility.GraphVertex;
import utility.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class MultiStageGraph {
    public static void main(String[] args) {
        MultiStageGraph msg = new MultiStageGraph();
        List<GraphVertex> vertices = msg.generateListOfVertices();
//        int[][] matrix = msg.calculateEdges(vertices);
//        Utilities.printMatrix(matrix);

        int[] optimalPath = msg.findPath(vertices, 4);
        Utilities.printIntArray(optimalPath);
    }

    public int[] findPath(List<GraphVertex> vertices, int stages) {
        int min;
        int verticesNumber = vertices.size();
        int[] cost = new int[verticesNumber + 1];
        int[] dest = new int[verticesNumber + 1];
        int[] path = new int[stages];
        int[][] edges = calculateEdges(vertices);

        cost[verticesNumber] = 0;
        //iterate over all vertices backwards
        for (int i = verticesNumber - 1; i >= 1; i--) {
            min = Integer.MAX_VALUE;
            //check vertices located after the current one
            for (int k = i + 1; k <= verticesNumber; k++) {
                /* if there's an edge from one vertex to another and
                sum of the edge and cost of the next vertex - do relaxation and update destination
                 */
                if (edges[i][k] != 0 && edges[i][k] + cost[k] < min) {
                    min = edges[i][k] + cost[k];
                    dest[i] = k;
                }
            }
            //update cost of a vertex after relaxation
            cost[i] = min;
        }

        //start of the path is always first (source) vertex
        path[0] = 1;
        //end of the path is always last (sink) vertex
        path[stages-1] = verticesNumber;

        //based on destination array for vertices, calculate the optimal path
        for (int i = 1; i < stages - 1; i++) {
            path[i] = dest[path[i-1]];
        }

        return path;
    }

    private int[][] calculateEdges(List<GraphVertex> vertices) {
        int size = vertices.size() + 1;
        //[vertex 'from'][vertex 'to'] = weight
        int[][] result = new int[size][size];

        //initially fill matrix with zeroes
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                result[i][j] = 0;
            }
        }

        //Iterate over each vertex of the graph
        for (GraphVertex vertex : vertices) {
            //check for presented edges and update matrix with these edges and its weights
            for (Map.Entry<GraphVertex, Integer> next : vertex.getDirectionMap().entrySet()) {
                result[vertex.getId()][next.getKey().getId()] = next.getValue();
            }
        }
        return result;
    }

    /**
     * This method is used to set up a proper MultiStage Graph with directions and its weights
     * @return List of all vertices of the graph
     */
    List<GraphVertex> generateListOfVertices() {
        List<GraphVertex> vertices = new ArrayList<>();

        GraphVertex one = new GraphVertex(1);
        GraphVertex two = new GraphVertex(2);
        GraphVertex three = new GraphVertex(3);
        GraphVertex four = new GraphVertex(4);
        GraphVertex five = new GraphVertex(5);
        GraphVertex six = new GraphVertex(6);
        GraphVertex seven = new GraphVertex(7);
        GraphVertex eight = new GraphVertex(8);

        one.addNextVertex(two, 2);
        one.addNextVertex(three, 1);
        one.addNextVertex(four, 3);

        two.addNextVertex(five, 2);
        two.addNextVertex(six, 3);

        three.addNextVertex(five, 6);
        three.addNextVertex(six, 7);

        four.addNextVertex(five, 6);
        four.addNextVertex(six, 8);
        four.addNextVertex(seven, 9);

        five.addNextVertex(eight, 6);

        six.addNextVertex(eight, 4);

        seven.addNextVertex(eight, 5);

        vertices.add(one);
        vertices.add(two);
        vertices.add(three);
        vertices.add(four);
        vertices.add(five);
        vertices.add(six);
        vertices.add(seven);
        vertices.add(eight);

        return vertices;
    }
}
