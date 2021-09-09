package linked.lists;

import java.util.HashSet;
import java.util.Set;

public class LinkedListCycleRabbitTurtle {


    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        ListNode tail = new ListNode(4);
        head.next = new ListNode(2, new ListNode(3, tail));
        ListNode input = head;
//        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        tail.next = head;

        boolean result;

        ListNode turtle = input;
        ListNode rabbit = getRabbitNode(input);

        result = hasCycle(input);

        System.out.printf("Result: %s", result);

    }

    public static boolean hasCycle(ListNode input) {
        ListNode turtle = input;
        ListNode rabbit = getRabbitNode(input);

        while (turtle != null || rabbit != null) {

            if (turtle.equals(rabbit)) {
                return true;
            }

            turtle = turtle.next;
            rabbit = getRabbitNode(rabbit);
        }
        return false;
    }


    public static ListNode getRabbitNode(ListNode starPoint) {
        ListNode rabbit = starPoint.next;
        if (rabbit != null) {
            return rabbit.next;
        }
        return rabbit;
    }
}
