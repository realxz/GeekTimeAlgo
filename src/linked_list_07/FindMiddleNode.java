package linked_list_07;

public class FindMiddleNode {
    public Node middleNode(Node list) {
        if (list == null) {
            return null;
        }
        if (list.next == null) {
            return list;
        }
        Node p = list;
        Node q = list;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        if (q.next == null) {
            return p;
        } else {
            return p.next;
        }
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);
//        Node node5 = new Node(5, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
//        node4.next = node5;

        FindMiddleNode findMiddleNode = new FindMiddleNode();
        Node node = findMiddleNode.middleNode(node1);

        while (node != null) {
            System.out.println(node.getData());
            node = node.next;
        }
    }
}
