package linked.lists;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleSet {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = new ListNode(4);
//        ListNode input = head.next = new ListNode(2, new ListNode(3, tail));
        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        tail.next = head;

        Set<ListNode> nodes = new HashSet<>();
        boolean result = false;

        ListNode node = input.next;
        while (node != null) {

            if (nodes.contains(node)) {
                result = true;
                break;
            } else {
                nodes.add(node);
                node = node.next;
            }
        }
        System.out.printf("Result: %s", result);

    }
}
