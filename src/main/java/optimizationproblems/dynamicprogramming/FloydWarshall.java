package optimizationproblems.dynamicprogramming;

import utility.GraphVertex;
import utility.Utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FloydWarshall {
    //value representing absence of edge between two vertices
    static final int INF = 999999;

    public static void main(String[] args) {
        FloydWarshall floydWarshall = new FloydWarshall();
        List<GraphVertex> vertices = floydWarshall.generateListOfVertices();
        int[][] result = floydWarshall.allPairsShortestPath(vertices);

        Utilities.printMatrixSkipZeroRowAndColumn(result);
    }

    public int[][] allPairsShortestPath(List<GraphVertex> vertices) {
        int size = vertices.size();
        int[][] matrix = initFloydWarshallMatrix(vertices);

        //selecting intermediate vertex
        for (int k = 1; k <= size; k++) {
            //selecting vertex 'from'
            for (int i = 1; i <= size; i++) {
                //selecting vertex 'to'
                for (int j = 1; j <= size; j++) {
                    int sum = matrix[i][k] + matrix[k][j];
                    if (sum < matrix[i][j]) {
                        matrix[i][j] = sum;
                    }
                }
            }
        }
        return matrix;
    }

    private int[][] initFloydWarshallMatrix(List<GraphVertex> vertices) {
        int size = vertices.size() + 1;
        //[vertex 'from'][vertex 'to'] = weight
        int[][] result = new int[size][size];

        //initially fill matrix with INF
        for (int i = 1; i < size; i++) {
            for (int j = 1; j < size; j++) {
                if (i == j) {
                    result[i][j] = 0;
                } else {
                    result[i][j] = INF;
                }
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


    List<GraphVertex> generateListOfVertices() {
        List<GraphVertex> vertices = new ArrayList<>();

        GraphVertex one = new GraphVertex(1);
        GraphVertex two = new GraphVertex(2);
        GraphVertex three = new GraphVertex(3);
        GraphVertex four = new GraphVertex(4);

        one.addNextVertex(two, 3);
        one.addNextVertex(four, 7);

        two.addNextVertex(one, 8);
        two.addNextVertex(three, 2);

        three.addNextVertex(one, 5);
        three.addNextVertex(four, 1);

        four.addNextVertex(one, 2);

        vertices.add(one);
        vertices.add(two);
        vertices.add(three);
        vertices.add(four);

        return vertices;
    }
}
