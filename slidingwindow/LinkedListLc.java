
// Definition for singly-linked list.

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class LinkedListLc {

    List<Integer> values = new ArrayList<>();
    Random ram = new Random();
    public LinkedListLc(ListNode head) {

        while (head != null) {
            values.add(head.val);
            head = head.next;
        }

    }

    public int getRandom() {
        int len = values.size();
        int index = ram.nextInt(len);
        return values.get(index);


    }

    public static void main(String[] args) {
        // Creating the linked list [1, 2, 3]
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);

        // Initializing the solution with the linked list head
        LinkedListLc obj = new LinkedListLc(head);

        // Get 5 random values from the list
        for (int i = 0; i < 5; i++) {
            System.out.print(obj.getRandom() + " ");
        }
    }
}
