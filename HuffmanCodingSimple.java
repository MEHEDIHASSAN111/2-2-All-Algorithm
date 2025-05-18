import java.util.*;

public class HuffmanCodingSimple {

    static class Node {
        int freq;
        String ch;
        Node left, right;

        Node(String ch, int freq) {
            this.ch = ch;
            this.freq = freq;
            left = right = null;
        }
    }

    static class MyComparator implements Comparator<Node> {
        public int compare(Node o1, Node o2) {
            return o1.freq - o2.freq;  // ascending order
        }
    }

    static int totalBits = 0;

    public static void printCodes(Node root, String code) {
        if (root == null) return;

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + code);
            totalBits += root.freq * code.length();
            return;
        }

        printCodes(root.left, code + "0");
        printCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("How many characters? ");
        int n = sc.nextInt();

        PriorityQueue<Node> pq = new PriorityQueue<>(n, new MyComparator());
        int originalBits = 0;

        System.out.println("Enter character and frequency:");
        for (int i = 0; i < n; i++) {
            String ch = sc.next();
            int freq = sc.nextInt();
            pq.add(new Node(ch, freq));
            originalBits += freq * 8; // Assuming 8 bits per character (ASCII)
        }

        // Build Huffman tree
        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();

            Node merged = new Node("-", left.freq + right.freq);
            merged.left = left;
            merged.right = right;

            pq.add(merged);
        }

        Node root = pq.poll(); // Get the final root node

        System.out.println("\nHuffman Codes:");
        printCodes(root, "");

        System.out.println("\nBefore Huffman Coding, bits required: " + originalBits);
        System.out.println("After Huffman Coding, bits required: " + totalBits);
        double saved = ((double)(originalBits - totalBits) / originalBits) * 100;
        System.out.printf("Bits saved: %.2f%%\n", saved);
    }
}