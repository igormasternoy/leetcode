package linked.lists;

import utils.Printer;

import java.util.Arrays;

public class MergeKSortedLinkedLists {

    public static void main(String[] args) {

//        ListNode l1 = new ListNode(1, new ListNode(4, new ListNode(5)));
//        ListNode l2 = new ListNode(1, new ListNode(3, new ListNode(4)));
//        ListNode l3 = new ListNode(2, new ListNode(6));

        ListNode l1 = null;
        ListNode l2 =  new ListNode(1);
        ListNode l3 = null;
        // 1,1,2,3,4,4,6

        ListNode[] lists = new ListNode[]{l1, l2, l3};

        ListNode prehead = new ListNode(-1);

        ListNode prev = prehead;



        int id = findMin(lists);

        while (id != -1) {
            prev.next = lists[id];
            prev = prev.next;

            lists[id] = lists[id].next;
            id = findMin(lists);

        }
        Printer.printListNodes(prehead.next);

    }

    public static int findMin(ListNode[] lists) {
        int currMin = Integer.MAX_VALUE;
        int listId = -1;

        for (int i = 0; i < lists.length; i++) {
            ListNode list = lists[i];
            if (list == null) continue;

            if (list.val < currMin) {
                currMin = list.val;
                listId = i;
            }
        }
        return listId;


    }
}
