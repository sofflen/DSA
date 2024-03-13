package utility;

public class HuffmanNode {

    private Character symbol;
    private Integer count;
    private HuffmanNode leftChild = null;
    private HuffmanNode rightChild = null;

    public HuffmanNode() {
    }

    public HuffmanNode(Character symbol, Integer count) {
        this.symbol = symbol;
        this.count = count;
    }

    public HuffmanNode(Character symbol, Integer count, HuffmanNode leftChild, HuffmanNode rightChild) {
        this.symbol = symbol;
        this.count = count;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    public char getSymbol() {
        return symbol;
    }

    public void setSymbol(char symbol) {
        this.symbol = symbol;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public HuffmanNode getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(HuffmanNode leftChild) {
        this.leftChild = leftChild;
    }

    public HuffmanNode getRightChild() {
        return rightChild;
    }

    public void setRightChild(HuffmanNode rightChild) {
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "HuffmanNode{" +
                "symbol=" + symbol +
                ", count=" + count +
                '}';
    }
}
