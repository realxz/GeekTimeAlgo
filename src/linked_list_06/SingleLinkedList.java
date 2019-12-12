package linked_list_06;

public class SingleLinkedList {
    private Node head;

    public static class Node {
        private String nStr;
        private Node next;

        public Node(String nStr, Node next) {
            this.nStr = nStr;
            this.next = next;
        }
    }

    public void linkLast(String nStr) {
        Node node = new Node(nStr, null);
        if (head == null) {
            head = node;
        } else {
            Node q = head;
            while (q.next != null) {
                q = q.next;
            }
            q.next = node;
        }
    }

    public boolean isPalindrome() {
        if (head == null) {
            return false;
        }
        if (head.next == null) {
            return true;
        }
        Node p = head;
        Node q = head;
        while (q.next != null && q.next.next != null) {
            p = p.next;
            q = q.next.next;
        }
        boolean flag = true;
        //P 为中点（abcba） p = c,(abddba) p = d
        //奇数 abcba
        // p 的左边 ab
        // p 的右边 ba 翻转？
        Node right = reverseLinkedList(p.next);
        Node left = head;
        while (left != null && right != null) {
            if (left.nStr.equals(right.nStr)) {
                left = left.next;
                right = right.next;
            } else {
                flag = false;
                break;
            }
        }
        return flag;
    }

    private Node reverseLinkedList(Node node) {
        Node preNode = null;
        Node nextNode;
        Node head = node;
        while (head != null) {
            nextNode = head.next;
            head.next = preNode;
            preNode = head;
            head = nextNode;
        }
        return preNode;
    }

    @Override
    public String toString() {
        if (head == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(head.nStr);
        Node q = head.next;
        while (q != null) {
            sb.append(q.nStr);
            q = q.next;
        }
//        System.out.println(sb.toString());
        return sb.toString();
    }

    public static void main(String[] args) {
        SingleLinkedList linkedList = new SingleLinkedList();
//        String[] dataArray = null;
//        String[] dataArray = new String[]{"a"};
//        String[] dataArray = new String[]{"a", "b"};
//        String[] dataArray = new String[]{"a", "b", "a"};
//        String[] dataArray = new String[]{"a", "b", "b", "a"};
        String[] dataArray = new String[]{"a", "b", "c", "b", "a"};
        if (dataArray != null) {
            for (String data : dataArray) {
                linkedList.linkLast(data);
            }
        }

//        linkedList.toString();
//        Node node = linkedList.reverseLinkedList(linkedList.head);
//        if (node == null) {
//            System.out.println("");
//        } else {
//            System.out.println(node.nStr);
//        }
        String dataStr = linkedList.toString();
        boolean isPalindrome = linkedList.isPalindrome();
        System.out.println(dataStr + " is palindrome " + isPalindrome);
    }

}
