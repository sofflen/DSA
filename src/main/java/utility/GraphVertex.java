package utility;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class GraphVertex {
    private final int id;
    private int weight;
    private final Map<GraphVertex, Integer> directionMap = new HashMap<>();

    public GraphVertex(int id) {
        this.id = id;
    }

    public GraphVertex(int id, int weight) {
        this.id = id;
        this.weight = weight;
    }

    public int getId() {
        return id;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Map<GraphVertex, Integer> getDirectionMap() {
        return directionMap;
    }

    public void addNextVertex(GraphVertex next, int weight) {
        directionMap.put(next, weight);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        GraphVertex vertex = (GraphVertex) o;
        return id == vertex.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "GraphVertex{" +
                "id=" + id +
                ", directionMap=" + directionMap +
                '}';
    }
}
