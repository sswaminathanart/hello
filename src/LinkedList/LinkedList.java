package LinkedList;

public class LinkedList {
    static class Node {
        int val;
        Node next;
        Node(int v) {
            this.val = v;
            next = null;
        }
    }
    public static Node reverse (Node head) {
        Node curr = head;
        Node next = null;
        Node pre = null;
        while (curr != null) {
            next = curr.next;
            curr.next = pre;
            pre =curr;
            curr = next;
        }
        return pre;
    }

   // 1 ---> 2 ----> 3----> 4--->null
    public static void main(String args[]) {
        Node n1 = new Node(1);
        Node head = n1;
        for (int i =2;i<=10;i++) {
            n1.next = new Node(i);
            n1 = n1.next;
        }
        Node n =head;
        while (n != null) {
            System.out.println(n.val);
            n = n.next;
        }
        System.out.println("\n\n\n");
        Node rev = reverse(head);
        while (rev != null) {
            System.out.println(rev.val);
            rev = rev.next;
        }
    }

}
