package linked_list_07;

public class MergeLinkedList {
    public Node mergeTwoLists(Node l1, Node l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }

        if (l1.getData() < l2.getData()) {
            l1.next = mergeTwoLists(l1.next, l2);
            return l1;
        } else {
            l2.next = mergeTwoLists(l1, l2.next);
            return l2;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node3 = new Node(3, null);
        Node node5 = new Node(5, null);
        Node node7 = new Node(7, null);
        Node node9 = new Node(9, null);
        node1.next = node3;
        node3.next = node5;
        node5.next = node7;
        node7.next = node9;

        Node node2 = new Node(2, null);
        Node node4 = new Node(4, null);
        Node node6 = new Node(6, null);
        Node node8 = new Node(8, null);
        Node node10 = new Node(10, null);
        node2.next = node4;
        node4.next = node6;
        node6.next = node8;
        node8.next = node10;

        MergeLinkedList linkedList = new MergeLinkedList();
        Node node = linkedList.mergeTwoLists(node1, node2);

        while (node != null) {
            System.out.println(node.getData());
            node = node.next;
        }
    }
}
