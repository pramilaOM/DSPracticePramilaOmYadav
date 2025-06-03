// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class middleNode1 {
    public ListNode middleNode(ListNode head) {

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;

    }

    public static void main(String[] args) {
        // Build the linked list [1,3,4,7,1,2,6]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(6);

        // Create object and delete middle
        middleNode1 obj = new middleNode1();
        ListNode middle = obj.middleNode(head);
        while (middle != null) {
            System.out.print(middle.val + " ");
            middle = middle.next;
        }

    }

}
