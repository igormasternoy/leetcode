package linked.lists;

import utils.MatrixPrinter;

public class AddTwoNumbersII {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(9, new ListNode(8, new ListNode(4, new ListNode(3))));
        ListNode l2 = new ListNode(1, new ListNode(6, new ListNode(4)));

//        ListNode l1 = new ListNode(9, new ListNode(1, new ListNode(6)));
//        ListNode l2 = new ListNode(0);

//        ListNode l1 = new ListNode(7, new ListNode(2, new ListNode(4, new ListNode(3))));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        int l1Length = listNodeLength(l1);
        int l2Length = listNodeLength(l2);

        if (l1Length > l2Length) {
            l2 = padListNode(l1Length - l2Length, l2);
        } else if (l2Length > l1Length) {
            l1 = padListNode(l2Length - l1Length, l1);
        }


        MatrixPrinter.printListNodes(l1);
        MatrixPrinter.printListNodes(l2);

        Result res = sumElements(l1,l2);

        ListNode result = null;

        if (res.leftOver > 0){
            result = new ListNode(res.leftOver, res.node);
        }else{
            result = res.node;
        }

        MatrixPrinter.printListNodes(result);



    }

    static class Result {
        int leftOver;
        ListNode node;

        public Result(int leftOver, ListNode node) {
            this.leftOver = leftOver;
            this.node = node;
        }
    }

    public static Result sumElements(ListNode l1, ListNode l2) {
        if (l1.next != null && l2.next != null) {
            Result res = sumElements(l1.next, l2.next);
            int sum = l1.val + l2.val + res.leftOver;
            return new Result(sum / 10, new ListNode(sum % 10, res.node));
        } else {
            int sum = l1.val + l2.val;
            int leftOver = sum / 10;
            return new Result(leftOver, new ListNode(sum % 10));
        }
    }


    public static ListNode padListNode(int padding, ListNode node) {
        ListNode newList = node;
        while (padding != 0) {
            ListNode padNode = new ListNode(0);
            padNode.next = newList;
            newList = padNode;
            padding--;
        }
        return newList;
    }

    public static int listNodeLength(ListNode node) {
        int length = 0;
        while (node != null) {
            length++;
            node = node.next;
        }
        return length;
    }
}
