package linked.lists;

import utils.Printer;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CopyListWithRandomPointer {


    public static void main(String[] args) {
        Node head = new Node(7);
        Node node1 = new Node(8);
        Node node2 = new Node(9);
        Node node3 = new Node(10);

        head.random = node3;
        node1.random = null;
        node2.random = node1;
        node3.random = head;

        head.next = node1;
        node1.next = node2;
        node2.next = node3;

        Map<Node, Node> memory = new HashMap<>();

        Node deepCopyHead = new Node(-1);
        Node deepCopy = deepCopyHead;

        Printer.printNodesHashes(head);

        while (head != null) {

            Node copy = null;

            if (memory.containsKey(head)) {
                copy = memory.get(head);
            } else {
                copy = new Node(head.val);
                memory.put(head, copy);
            }


            Node random = null;

            if (head.random == null) {
                random = null;
            } else if (memory.containsKey(head.random)) {
                random = memory.get(head.random);
            } else {
                random = new Node(head.random.val);
                memory.put(head.random, random);
            }

            copy.random = random;

            deepCopy.next = copy;
            deepCopy = deepCopy.next;
            head = head.next;

        }

        Printer.printNodesHashes(deepCopyHead.next);





    }

}
