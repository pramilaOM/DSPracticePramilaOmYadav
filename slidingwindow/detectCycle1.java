// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class detectCycle1 {
    public ListNode detectCycle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode check = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                break;
            }
        }

        if (slow != fast) {
            return null;
        }

        while (check != slow) {
            check = check.next;
            slow = slow.next;
        }

        return slow;

    }

    public static void main(String[] args) {
        // Create linked list: 1 → 2 → 3 → 4 → 5 → 6 ↘
        // ↑-------------↗ (cycle to node 3)
        ListNode head = new ListNode(1);
        ListNode node2 = new ListNode(2);
        ListNode node3 = new ListNode(3);
        ListNode node4 = new ListNode(4);
        ListNode node5 = new ListNode(5);
        ListNode node6 = new ListNode(6);

        head.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;
        node5.next = node6;
        node6.next = node3; // create cycle at node with val 3

        detectCycle1 obj = new detectCycle1();
        ListNode cycleStart = obj.detectCycle(head);

        if (cycleStart != null) {
            System.out.println("Cycle starts at node with value: " + cycleStart.val);
        } else {
            System.out.println("No cycle found.");
        }
    }
}
