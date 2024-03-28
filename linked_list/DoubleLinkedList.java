package linked_list;

public class DoubleLinkedList {
    private ListNode head;
    private ListNode tail;
    private int length;

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
        this.length = 0;
    }

    public void print() {
        ListNode temp = head;
        while (temp != null) {
            System.out.println(temp.data + " -->");
            temp = temp.next;
        }
        System.out.print("null");
    }

    public static void main(String[] args) {
    }
}
