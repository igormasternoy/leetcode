package linked.lists;

/**
 * Recursive approach
 */
public class ReverseLinkedListRecursive {

    public static void main(String[] args) {
//        ListNode input = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        ListNode input = new ListNode();
//        if(input == null) return null;

        ListNode tail = input.next;
        input.next = null;
        System.out.println(putToTail(input, tail));
    }

    public static ListNode putToTail(ListNode node, ListNode tail) {
        if(tail==null){
            return node;
        }

        if (tail.next == null) {
            tail.next = node;
            return tail;
        }

        ListNode newTail = tail.next;
        tail.next = node;
        return putToTail(tail, newTail);
    }
}
