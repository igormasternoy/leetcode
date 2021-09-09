package linked.lists;

import utils.Printer;

public class AddTwoNumbers {

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(2, new ListNode(4, new ListNode(3)));
//        ListNode l2 = new ListNode(5, new ListNode(6, new ListNode(4)));

        ListNode l1 = new ListNode(9, new ListNode(9, new ListNode(9)));
        ListNode l2 = new ListNode(9, new ListNode(9));

        int leftover = 0;

        ListNode resultHead = null;
        ListNode result = null;

        ListNode zeroNode = new ListNode(0);

        while(true){

            int currSum =  (l1.val + l2.val + leftover);

            if(result == null){
                resultHead = new ListNode(currSum % 10);
                result = resultHead;
            }else{
                result.next = new ListNode(currSum % 10);
                result = result.next;
            }

            leftover = currSum / 10;

            if(l1.next == null && l2.next == null && leftover ==0) break;

            l1 = l1.next == null  ? zeroNode : l1.next;
            l2 = l2.next == null  ? zeroNode : l2.next;


        }


        Printer.printListNodes(resultHead);


    }
}
