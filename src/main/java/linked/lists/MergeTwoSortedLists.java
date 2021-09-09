package linked.lists;

import com.sun.tools.javac.util.Pair;

import utils.Printer;

public class MergeTwoSortedLists {

    public static void main(String[] args) {
//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
//        ListNode l2 = new ListNode(1, new ListNode(1, new ListNode(3, new ListNode(5, new ListNode(6)))));

//        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
//        ListNode l2 = new ListNode(4, new ListNode(5, new ListNode(6)));

//        ListNode l1 = new ListNode();
//        ListNode l2 = new ListNode(4, new ListNode(5, new ListNode(6)));

        ListNode l1 = new ListNode(1, new ListNode(2, new ListNode(3)));
        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));

        Pair<ListNode, ListNode> result = null;

        while (l1 != null || l2 != null) {
//            System.out.printf("%s , %s\n", l1.val, l2.val);
            if (l1 == null) {
                result = setResult(result, l2);
                l2 = l2.next;
                continue;
            }

            if (l2 == null) {
                result = setResult(result, l2);
                l1 = l1.next;
                continue;
            }

            if (l2.val > l1.val) {
                result = setResult(result, l1);
                l1 = l1.next;
                continue;

            }

            if (l2 == null || l2.val <= l1.val) {

                result = setResult(result, l2);
                l2 = l2.next;
                continue;
            }
        }

        Printer.printListNodes(result.fst);


    }

    public static Pair<ListNode, ListNode> setResult(Pair<ListNode, ListNode> result, ListNode node) {
        ListNode newNode = new ListNode(node.val);

        if (result == null) {
            return new Pair<>(newNode, newNode);
        } else {
            result.snd.next = newNode;
            return new Pair<>(result.fst, newNode);
        }

    }
}
