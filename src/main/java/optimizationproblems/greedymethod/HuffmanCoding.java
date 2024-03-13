package optimizationproblems.greedymethod;

import utility.HuffmanNode;
import utility.Utilities;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Queue;

public class HuffmanCoding {
    public static void main(String[] args) {
        HuffmanCoding huffmanCoding = new HuffmanCoding();
        String string = "ABBCCCDDEECBEBACBABEBEBCABABEB";
        Map<String, Queue<HuffmanNode>> encode = huffmanCoding.huffmanEncode(string);
        String encodedString = encode.keySet().stream().findFirst().orElse("");
        Queue<HuffmanNode> huffmanCode = encode.get(encodedString);
        String decodedString = huffmanCoding.huffmanDecode(encodedString, huffmanCode);
        System.out.println("Initial string is:\n" + string);
        System.out.println("Encoded string is:\n" + encodedString);
        System.out.println("Decoded string is:\n" + decodedString);
    }

    public Map<String, Queue<HuffmanNode>> huffmanEncode(String str) {
        Map<String, Queue<HuffmanNode>> result = new HashMap<>();
        if (str == null || str.isEmpty()) {
            return result;
        }

        Map<Character, String> huffmanCode = new HashMap<>();
        Map<Character, Integer> freqMap = Utilities.countCharsInString(str);
        Queue<HuffmanNode> queue = new PriorityQueue<>(Comparator.comparingInt(HuffmanNode::getCount));

        for (Map.Entry<Character, Integer> entry : freqMap.entrySet()) {
            queue.add(new HuffmanNode(entry.getKey(), entry.getValue()));
        }

        while (queue.size() > 1) {
            HuffmanNode left = queue.poll();
            HuffmanNode right = queue.poll();

            int sum = left.getCount() + right.getCount();
            queue.add(new HuffmanNode(null, sum, left, right));
        }

        HuffmanNode root = queue.peek();

        encodeData(root, "", huffmanCode);
        System.out.println("Huffman Codes of the characters are: " + huffmanCode);

        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            sb.append(huffmanCode.get(c));
        }

        result.put(sb.toString(), queue);
        return result;
    }

    private String huffmanDecode(String encodedString, Queue<HuffmanNode> huffmanCode) {
        StringBuilder sb = new StringBuilder();
        int index = 0;
        HuffmanNode root = huffmanCode.peek();
        while (index < encodedString.length() - 1) {
            index = decodeData(root, index, encodedString, sb);
        }
        return sb.toString();
    }

    private int decodeData(HuffmanNode root, Integer index, String encodedString, StringBuilder sb) {
        if (root == null) {
            return index;
        }

        if (isLeaf(root)) {
            sb.append(root.getSymbol());
            return index;
        }
        HuffmanNode nextNode = encodedString.charAt(index++) == '0' ? root.getLeftChild() : root.getRightChild();
        return decodeData(nextNode, index, encodedString, sb);
    }

    private void encodeData(HuffmanNode root, String str, Map<Character, String> huffmanCode) {
        if (root == null) {
            return;
        }

        if (isLeaf(root)) {
            huffmanCode.put(root.getSymbol(), !str.isEmpty() ? str : "1");
        }
        encodeData(root.getLeftChild(), str + "0", huffmanCode);
        encodeData(root.getRightChild(), str + "1", huffmanCode);
    }

    private boolean isLeaf(HuffmanNode node) {
        return node.getLeftChild() == null && node.getRightChild() == null;
    }
}
