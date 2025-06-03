public class swapPairs11 {

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
        public ListNode swapPairs(ListNode head) {

            if (head == null || head.next == null) {
                return head;
            }
            ListNode temp = head.next;
            head.next = swapPairs(head.next.next);
            temp.next = head;

            return temp;
        }
    }

    public static void main(String[] args) {
        // Example: [1, 2, 3, 4]
        ListNode head = new ListNode(1,
                new ListNode(2,
                        new ListNode(3,
                                new ListNode(4))));

        Solution sol = new Solution();
        ListNode result = sol.swapPairs(head);

        printList(result); // Expected Output: 2 -> 1 -> 4 -> 3
    }

    // Helper method to print the list
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
