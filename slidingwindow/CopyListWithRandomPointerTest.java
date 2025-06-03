import java.util.*;

public class CopyListWithRandomPointerTest {

    // Definition for a Node.
    static class Node {
        int val;
        Node next;
        Node random;

        public Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }

    static class Solution {
        public Node copyRandomList(Node head) {
            if (head == null) {
                return head;
            }
            Node current = head;

            while (current != null) {
                Node currNext = current.next;
                current.next = new Node(current.val);
                current.next.next = currNext;
                current = currNext;
            }
            current = head;
            while (current != null && current.next != null) {
                if (current.random == null) {
                    current.next.random = null;
                } else {
                    current.next.random = current.random.next;
                }
                current = current.next.next;
            }

            Node newHead = head.next;
            Node newCurr = newHead;

            current = head;

            while (current != null && newCurr != null) {
                current.next = (current.next != null) ? current.next.next : null;
                newCurr.next = (newCurr.next != null) ? newCurr.next.next : null;

                current = current.next;
                newCurr = newCurr.next;

            }
            return newHead;

        }
    }

    // Test harness main
    public static void main(String[] args) {
        // Input format: [val, random_index]
        int[][] input = { { 7, -1 }, { 13, 0 }, { 11, 4 }, { 10, 2 }, { 1, 0 } };
        Node head = buildList(input);

        // Call your implemented logic
        Solution solution = new Solution();
        Node copiedHead = solution.copyRandomList(head);

        // Print original and copied list
        System.out.println("Original list:");
        printList(head);
        System.out.println("\nCopied list:");
        printList(copiedHead);
    }

    // Helper to build a list from [val, random_index] format
    private static Node buildList(int[][] nodes) {
        if (nodes.length == 0)
            return null;

        List<Node> nodeList = new ArrayList<>();
        for (int[] n : nodes) {
            nodeList.add(new Node(n[0]));
        }
        for (int i = 0; i < nodes.length; i++) {
            if (i < nodes.length - 1) {
                nodeList.get(i).next = nodeList.get(i + 1);
            }
            int randomIndex = nodes[i][1];
            nodeList.get(i).random = (randomIndex == -1) ? null : nodeList.get(randomIndex);
        }
        return nodeList.get(0);
    }

    // Helper to print the list showing val and random.val
    private static void printList(Node head) {
        Node temp = head;
        while (temp != null) {
            int randomVal = (temp.random != null) ? temp.random.val : -1;
            System.out
                    .println("Node val: " + temp.val + ", Random points to: " + (randomVal == -1 ? "null" : randomVal));
            temp = temp.next;
        }
    }
}
