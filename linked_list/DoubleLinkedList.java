package linked_list;

public class DoubleLinkedList {
    private ListNode head;
    private ListNode tail;

    private static class ListNode {
        private int data;
        private ListNode previous;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public DoubleLinkedList() {
        this.head = null;
        this.tail = null;
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data + " -->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public void insertNodeAtBegining(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.next = head;
            head.previous = newNode;
            head = newNode;
        }
    }

    public void addNode(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.previous = tail;
            tail = newNode;
        }
    }

    public void deleteFirstNode() {
        head = head.next;
        head.previous = null;
    }

    public void deleteLastNode() {
        tail = tail.previous;
        tail.next = null;
    }

    public static void main(String[] args) {
    }
}
