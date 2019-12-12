package linked_list_07;

/**
 * 单链表反转
 */
public class ReverseLinkedList {
    public void reverseLinkedList(Node list) {
        //需要三个指针，分别是 pre，head，next
        if (list == null || list.next == null) {
            return;
        }
        //1->2->3->4->5
        Node preNode = null;
        Node nextNode;
        while (list != null) {
            //先确定当前结点的下一个结点，1 的下一个结点是 2
            nextNode = list.next;
            //将当前结点指向它的前一个结点 1 的前一个结点是 null，2 的前一个结点是 1 ，依次类推
            list.next = preNode;
            //将前置结点后移，初始前置结点是 null，之后是 1，2，依次类推
            preNode = list;
            //最后将当前结点后移
            list = nextNode;

            //一次循环后， nextNode 指向2，结点 1 的后继指针指向 null，preNode 指向 1，当前结点 list 指向 2
            // null <- 1,2 -> 3 -> 4 -> 5
            // null <- 1 <- 2,3 ->4 -> 5
        }
        printAll(preNode);

    }

    public void printAll(Node list) {
        if (list == null) {
            System.out.println("");
            return;
        }

        if (list.next == null) {
            System.out.println(list.getData());
            return;
        }

        Node q = list;
        while (q != null) {
            System.out.println(q.getData());
            q = q.next;
        }

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

        ReverseLinkedList reverseLinkedList = new ReverseLinkedList();
        reverseLinkedList.reverseLinkedList(node1);
    }
}
