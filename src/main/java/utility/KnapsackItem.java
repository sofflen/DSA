package utility;

import java.util.Objects;

public class KnapsackItem {

    private int value;
    private int weight;

    public KnapsackItem(int value, int weight) {
        this.value = value;
        this.weight = weight;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KnapsackItem that = (KnapsackItem) o;
        return value == that.value && weight == that.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(value, weight);
    }

    @Override
    public String toString() {
        return "KnapsackItem{" +
                "value=" + value +
                ", weight=" + weight +
                '}';
    }
}
