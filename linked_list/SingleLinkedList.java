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

    public void addNode(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            ListNode currNode = head;
            while (currNode.next != null) {
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }
    }

    public void insertNodeAtBegining(int data) {
        ListNode newNode = new ListNode(data);
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    public void insertNodeAtPosition(int data, int position) {
        ListNode newNode = new ListNode(data);
        if (position == 1) {
            newNode.next = head;
            head = newNode;
        } else {
            int count = 1;
            ListNode currNode = head;
            while (count < position - 1) {
                currNode = currNode.next;
                count++;
            }
            newNode.next = currNode.next;
            currNode.next = newNode;
        }
    }

    public void deleteFirstNode() {
        head = head.next;
    }

    public void deleteLastNode() {
        ListNode currNode = head;
        while (currNode.next.next != null) {
            currNode = currNode.next;
        }
        currNode.next = null;
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
        singleLinkedList.head = new ListNode(2);
        singleLinkedList.addNode(3);
        singleLinkedList.addNode(4);
        singleLinkedList.insertNodeAtBegining(1);
        singleLinkedList.insertNodeAtPosition(5, 3);
        singleLinkedList.deleteFirstNode();
        singleLinkedList.deleteLastNode();
        System.out.println("Length: " + singleLinkedList.getLength());
        singleLinkedList.print();
    }
}
