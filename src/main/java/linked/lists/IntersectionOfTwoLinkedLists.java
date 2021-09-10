package linked.lists;

import utils.Printer;

public class IntersectionOfTwoLinkedLists {

    public static void main(String[] args) {


        ListNode intersection = new ListNode(8, new ListNode(4, new ListNode(5)));

//        ListNode l2 = new ListNode(4, new ListNode(1, intersection));
//        ListNode l1 = new ListNode(5, new ListNode(6, new ListNode(1, intersection)));

//        ListNode l2 = new ListNode(2, new ListNode(6, new ListNode(4)));
//        ListNode l1 = new ListNode(1, new ListNode(5));

        ListNode l2 = new ListNode();
        ListNode l1 = new ListNode();

        int l1Length = listNodeLength(l1);
        int l2Length = listNodeLength(l2);

        ListNode result = null;

        if (l1Length > l2Length) {
            //skip l1 - l2 nodes
            ListNode head1 = l1;
            ListNode head2 = l2;

            for(int i = 0; i< l1Length - l2Length; i++){
                head1 = head1.next;
            }

            while(head1 != null || head2 != null){
                if(head1 == head2){
                    result = head1;
                    break;
                }
                head1 = head1.next;
                head2 = head2.next;
            }

        } else if (l2Length >= l1Length) {
            ListNode head1 = l1;
            ListNode head2 = l2;

            for(int i = 0; i< l2Length - l1Length; i++){
                head2 = head2.next;
            }

            while(head1 != null || head2 != null){
                if(head1 == head2){
                    result = head1;
                    break;
                }
                head1 = head1.next;
                head2 = head2.next;
            }

        }

        Printer.printListNodes(l1);
        Printer.printListNodes(l2);
        System.out.println("Intersection:"+result);


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
