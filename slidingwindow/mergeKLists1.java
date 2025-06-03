public class mergeKLists1 {

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

    public static class Solution {
        public static ListNode mergeKLists(ListNode[] lists) {
            int size = lists.length;
            if (size == 0) {
                return null;
            }
            return partitionAndMerge(0, size - 1, lists);

        }

        public static ListNode partitionAndMerge(int start, int end, ListNode[] lists) {

            if (start > end) {
                return null;
            }
            if (start == end) {
                return lists[start];
            }

            int mid = start + (end - start) / 2;

            ListNode L1 = partitionAndMerge(start, mid, lists);
            ListNode L2 = partitionAndMerge(mid + 1, end, lists);

            return MergeTWoLists(L1, L2);

        }

        public static ListNode MergeTWoLists(ListNode l1, ListNode l2) {

            if (l1 == null) {
                return l2;
            }
            if (l2 == null) {
                return l1;
            }
            if (l1.val <= l2.val) {
                l1.next = MergeTWoLists(l1.next, l2);
                return l1;
            } else {
                l2.next = MergeTWoLists(l1, l2.next);
                return l2;
            }

        }

    }

    public static void main(String[] args) {
        // Build the input: lists = [[1,4,5],[1,3,4],[2,6]]
        ListNode[] lists = new ListNode[3];

        lists[0] = new ListNode(1, new ListNode(4, new ListNode(5)));
        lists[1] = new ListNode(1, new ListNode(3, new ListNode(4)));
        lists[2] = new ListNode(2, new ListNode(6));

        // Call the solution
        Solution solution = new Solution();
        ListNode result = solution.mergeKLists(lists);

        // Print the output list
        printList(result);
    }

    // Helper method to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print("->");
            head = head.next;
        }
        System.out.println();
    }
}
