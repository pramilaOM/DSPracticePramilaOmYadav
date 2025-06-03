import java.util.HashMap;
import java.util.Map;

public class  removeZeroSumSublists11 {

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

    public static class removeZeroSumSublists1 {
        public ListNode removeZeroSumSublists(ListNode head) {
            int prefixSum = 0;
            ListNode dummy = new ListNode(0);
            dummy.next = head;
            Map<Integer, ListNode> map = new HashMap<>();
            map.put(0, dummy);
            while (head != null) {
                prefixSum += head.val;

                if (map.containsKey(prefixSum)) {
                    ListNode start = map.get(prefixSum);
                    ListNode temp = start;
                    int pSum = prefixSum;

                    while (temp != head) {
                        temp = temp.next;
                        pSum += temp.val;
                        map.remove(pSum);

                    }
                    start.next = temp.next;
                } else {
                    map.put(prefixSum, head);
                }
                head = head.next;
            }

            return dummy.next;

        }
    }

    public static void main(String[] args) {
        // Build the input: [1,2,-3,3,1]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(-3);
        head.next.next.next = new ListNode(3);
        head.next.next.next.next = new ListNode(1);

        // Call your solution
        removeZeroSumSublists1 sol = new removeZeroSumSublists1();
        ListNode result = sol.removeZeroSumSublists(head);

        // Print the output
        printList(result);
    }

    // Utility method to print the list
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
