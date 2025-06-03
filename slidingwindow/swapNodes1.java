public class swapNodes1 {

    // Definition for singly-linked list
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

    // Your solution class
    public static class Solution {
        public ListNode swapNodes(ListNode head, int k) {
            ListNode node1 = null;
            ListNode node2 = null;
            ListNode temp = head;
            while (temp != null) {
                k--;
                if(node2 != null){
                    node2 = node2.next;
                }

                if(k == 0){
                    node1 = temp;
                    node2 = head;
                }
                temp = temp.next;
            }

            int swap = node1.val;
            node1.val = node2.val;
            node2.val = swap;
            return head;

        }

        public static int findSize(ListNode head) {
            int count = 0;
            while (head != null) {
                count++;
                head = head.next;
            }

            return count;

        }
    }

    public static void main(String[] args) {
        // Example input: [1, 2, 3, 4, 5], k = 2
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        int k = 2;

        Solution solution = new Solution();
        ListNode result = solution.swapNodes(head, k);

        printList(result); // Expected Output: 1 -> 4 -> 3 -> 2 -> 5
    }

    // Helper method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }
}
