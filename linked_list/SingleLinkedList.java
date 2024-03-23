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

    public void print() {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "-->");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public int getLength() {
        int length = 0;
        ListNode currNode = head;
        while (currNode != null) {
            length++;
            currNode = currNode.next;
        }
        return length;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.head = new ListNode(10);
        ListNode second = new ListNode(3);
        ListNode third = new ListNode(6);
        singleLinkedList.head.next = second;
        second.next = third;
        System.out.println("length: " + singleLinkedList.getLength());
        singleLinkedList.print();
    }
}
