// Definition for singly-linked list.
class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class oddEvenList1 {
    public ListNode oddEvenList(ListNode head) {
         if(head == null || head.next == null){
            return head;
        }
        
        ListNode odd = head;
        ListNode even = head.next;
        ListNode evenStart = even;
        while (even != null && even.next != null) {

            odd.next = even.next;
            even.next = even.next.next;
            odd = odd.next;
            even = even.next;
        }
        odd.next = evenStart;

        return head;

    }

    public static void main(String[] args) {
        // Build the linked list [1,3,4,7,1,2,6]
        ListNode head = new ListNode(1);
        // head.next = new ListNode(2);
        // head.next.next = new ListNode(3);
        // head.next.next.next = new ListNode(4);
        // head.next.next.next.next = new ListNode(5);
        // head.next.next.next.next.next = new ListNode(6);

        // Create object and delete middle
        oddEvenList1 obj = new oddEvenList1();
        ListNode middle = obj.oddEvenList(head);
        while (middle != null) {
            System.out.print(middle.val + " ");
            middle = middle.next;
        }

    }

}
