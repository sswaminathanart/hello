package LinkedList;

public class DetectLoopInLinkedList {
    static class Node {
        int val;
        Node next;
        Node(int v) {
            this.val = v;
            next = null;
        }
    }
    public static boolean isCycle(Node n) {
        Node slow = n;
        Node fast = n;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return true;
            }
        }
        return false;
    }
    public static Node cycleMeetNode(Node n) {
        Node slow = n;
        Node fast = n;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(slow == fast) {
                return slow;
            }
        }
        return null;
    }
    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node head = n1;
        for (int i = 2; i <= 10; i++) {
            n1.next = new Node(i);
            n1 = n1.next;
        }
        n1.next = head.next.next.next;
        Node n = head;
        if (isCycle(head)) {
            System.out.println("Cycle in Linked List");
            Node meet = cycleMeetNode(head);
            System.out.println("Cycle meet node " + meet.val);
            while (head.val != meet.val) {
                head = head.next;
                meet = meet.next;
            }
            if (head.val== meet.val){
                System.out.println("Cycle Start value " + head.val);
            }
        }

        else {
            while (n != null) {
                System.out.println(n.val);
                n = n.next;
            }
        }
    }
}
