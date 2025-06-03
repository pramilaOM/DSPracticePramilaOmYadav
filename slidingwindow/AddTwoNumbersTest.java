import java.util.Stack;

public class AddTwoNumbersTest {

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

    static class Solution {
        public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            Stack<Integer> s1 = new Stack<>();
            Stack<Integer> s2 = new Stack<>();

            while (l1 != null) {
                s1.push(l1.val);
                l1 = l1.next;
            }

            while (l2 != null) {
                s2.push(l2.val);
                l2 = l2.next;
            }

            int carry = 0;
            ListNode ans = null;

            while (!s1.isEmpty() || !s2.isEmpty() || carry > 0) {
                int sum = carry;

                if (!s1.isEmpty())
                    sum += s1.pop();
                if (!s2.isEmpty())
                    sum += s2.pop();

                ListNode newNode = new ListNode(sum % 10);
                newNode.next = ans;
                ans = newNode;

                carry = sum / 10;
            }

            return ans;
        }

    }

    // Method to print a linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Input: l1 = [7,2,4,3], l2 = [5,6,4]
        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        Solution sol = new Solution();
        ListNode result = sol.addTwoNumbers(l1, l2);

        System.out.print("Output: ");
        printList(result); // Expected Output: 7 -> 8 -> 0 -> 7
    }
}
