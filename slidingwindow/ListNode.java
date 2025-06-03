// Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

class deleteNode1 {
    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(4);
        head.next = new ListNode(5);
        head.next.next = new ListNode(1);
        head.next.next.next = new ListNode(9);

        deleteNode1 obj = new deleteNode1();
        obj.deleteNode(head.next);

        ListNode current = head;
        while (current != null) {
            System.out.print(current.val + " ");
            current = current.next;
        }
    }
}
