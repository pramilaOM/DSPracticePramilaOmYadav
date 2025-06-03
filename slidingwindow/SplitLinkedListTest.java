public class SplitLinkedListTest {

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

    // Your Solution class
    static class Solution {
        public ListNode[] splitListToParts(ListNode head, int k) {
            // Your logic should go here (not shown as per request)
            // find the length

            ListNode curr = head;
            int count = 0;
            while (curr != null) {
                count++;
                curr = curr.next;
            }

            int eachBucket = count / k;
            int remainder = count % k;

            ListNode[] result = new ListNode[k];

            curr = head;
            ListNode prev = null;

            for (int i = 0; curr != null && i < k; i++) {
                result[i] = curr;
                for (int ctr = 1; ctr <= eachBucket + (remainder > 0 ? 1 : 0); ctr++) {
                    prev = curr;
                    curr = curr.next;
                }
                if (prev != null) {
                    prev.next = null;
                }
                remainder--;
            }

            return result; // placeholder
        }
    }

    // Helper method to build linked list from array
    public static ListNode buildList(int[] values) {
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        for (int val : values) {
            current.next = new ListNode(val);
            current = current.next;
        }
        return dummy.next;
    }

    // Helper method to print array of linked lists
    public static void printParts(ListNode[] parts) {
        for (int i = 0; i < parts.length; i++) {
            System.out.print("Part " + (i + 1) + ": ");
            ListNode current = parts[i];
            while (current != null) {

                System.out.print(current.val);
                if (current.next != null)
                    System.out.print(" -> ");
                current = current.next;
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test 1
        ListNode head1 = buildList(new int[] { 1, 2, 3 });
        int k1 = 5;
        ListNode[] parts1 = solution.splitListToParts(head1, k1);
        System.out.println("Test Case 1:");
        printParts(parts1);

        // Test 2
        ListNode head2 = buildList(new int[] { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 });
        int k2 = 3;
        ListNode[] parts2 = solution.splitListToParts(head2, k2);
        System.out.println("Test Case 2:");
        printParts(parts2);
    }
}
