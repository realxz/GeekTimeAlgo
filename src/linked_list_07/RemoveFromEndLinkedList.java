package linked_list_07;

public class RemoveFromEndLinkedList {
    public Node removeNthFromEnd(Node head, int n) {
        Node node = new Node(0, head);

        Node first = node;
        Node second = node;
        for (int i = 1; i <= n + 1; i++) {
            first = first.next;
        }

        while (first != null) {
            first = first.next;
            second = second.next;
        }
        second.next = second.next.next;
        return node.next;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
        Node node5 = new Node(5, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node5;

        RemoveFromEndLinkedList linkedList = new RemoveFromEndLinkedList();
        Node node = linkedList.removeNthFromEnd(node1, 1);
//        Node node = linkedList.removeNthFromEnd(node1, 2);
//        Node node = linkedList.removeNthFromEnd(node1, 3);
//        Node node = linkedList.removeNthFromEnd(node1, 4);
//        Node node = linkedList.removeNthFromEnd(node1, 5);

        while (node != null) {
            System.out.println(node.getData());
            node = node.next;
        }
    }
}
