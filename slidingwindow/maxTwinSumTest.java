import java.util.Stack;

public class maxTwinSumTest {

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

    // Solution class where you will define your logic
    public static class Solution {
        public int pairSum(ListNode head) {
            // Your logic goes here

            ListNode slow = head;
            ListNode fast = head;

            while(fast != null && fast.next != null){
                slow = slow.next;
                fast = fast.next.next;
            }

            ListNode mid = slow;
            ListNode prev = null;
            ListNode nextNode  = null;
            while(mid != null){
                nextNode = mid.next;
                mid.next = prev;
                prev = mid;
                mid = nextNode;
            }

            int result = 0;
            ListNode curr = head;

            while(prev != null){
                result = Math.max(result, curr.val+prev.val);
                curr = curr.next;
                prev = prev.next;
            }

            return result; // placeholder
        }
    }

    public static void main(String[] args) {
        // Example input: [4, 2, 2, 3]
        ListNode head = new ListNode(4,
                new ListNode(2,
                        new ListNode(2,
                                new ListNode(3))));

        Solution sol = new Solution();
        int result = sol.pairSum(head);
        System.out.println("Maximum twin sum: " + result); // Expected: 7
    }
}
