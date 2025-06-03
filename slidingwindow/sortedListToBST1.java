import java.util.*;

public class sortedListToBST1 {

    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public static class Solution {
        public TreeNode sortedListToBST(ListNode head) {

            if (head == null) {
                return null;
            }
            if (head.next == null) {
                return new TreeNode(head.val);
            }

            ListNode slow = head;
            ListNode fast = head;
            ListNode prevSlow = null;

            while (fast != null && fast.next != null) {
                prevSlow = slow;
                slow = slow.next;
                fast = fast.next.next;

            }

            TreeNode root = new TreeNode(slow.val);
            if (prevSlow != null) {
                prevSlow.next = null;
                if (slow != head) {
                    root.left = sortedListToBST(head);
                }

            }

            root.right = sortedListToBST(slow.next);
            return root;

        }
    }

    public static void main(String[] args) {
        // Build the input linked list: [-10, -3, 0, 5, 9]
        ListNode head = new ListNode(-10);
        head.next = new ListNode(-3);
        head.next.next = new ListNode(0);
        head.next.next.next = new ListNode(5);
        head.next.next.next.next = new ListNode(9);

        // Call your solution
        Solution solution = new Solution();
        TreeNode root = solution.sortedListToBST(head);

        // Print the output tree (level-order for readability)
        printLevelOrder(root);
    }

    // Helper method to print a binary tree in level-order
    public static void printLevelOrder(TreeNode root) {
        if (root == null) {
            System.out.println("[]");
            return;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        List<String> result = new ArrayList<>();

        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node != null) {
                result.add(String.valueOf(node.val));
                queue.add(node.left);
                queue.add(node.right);
            } else {
                result.add("null");
            }
        }

        // Trim trailing "null" values
        int i = result.size() - 1;
        while (i >= 0 && result.get(i).equals("null")) {
            i--;
        }

        System.out.println(result.subList(0, i + 1));
    }
}
