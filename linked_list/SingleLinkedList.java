package linked_list;

public class SingleLinkedList {
    private ListNode head;

    private static class ListNode {
        private int data;
        private ListNode next;

        public ListNode(int data) {
            this.data = data;
        }
    }

    public static void main(String[] args) {
        ListNode head = new ListNode(10);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(6);
        head.next = second;
        second.next = third;
    }
}
