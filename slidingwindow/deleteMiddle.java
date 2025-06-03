// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class deleteMiddle {
    public ListNode deleteMiddle(ListNode head) {

        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        ListNode prev = null;
        while (fast.next != null) {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;

        }
        prev.next = slow.next;

        return head;

    }

    public static void main(String[] args) {
        // Build the linked list [1,3,4,7,1,2,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(3);
        head.next.next = new ListNode(4);
        head.next.next.next = new ListNode(7);
        head.next.next.next.next = new ListNode(1);
        head.next.next.next.next.next = new ListNode(2);
        head.next.next.next.next.next.next = new ListNode(6);

        // Create object and delete middle
        deleteMiddle obj = new deleteMiddle();
        head = obj.deleteMiddle(head); // Update head in case it changes

        // Print the modified list
        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }

}
