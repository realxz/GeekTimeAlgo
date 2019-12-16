package linked_list_07;

public class CycleLinkedList {
    public boolean hasCycle(Node list) {
        if (list == null || list.next == null) {
            return false;
        }
        Node slow = list;
        Node quick = list.next;
        while (slow != quick) {
            if (quick == null || quick.next == null) {
                return false;
            }
            slow = slow.next;
            quick = quick.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        Node node1 = new Node(1, null);
        Node node2 = new Node(2, null);
        Node node3 = new Node(3, null);
        Node node4 = new Node(4, null);

        node1.next = node2;
        node2.next = node3;
        node3.next = node4;
        node4.next = node2;


        CycleLinkedList linkedList = new CycleLinkedList();
        boolean hasCycle = linkedList.hasCycle(node4);
        System.out.println("has cycle = " + hasCycle);
    }
}
