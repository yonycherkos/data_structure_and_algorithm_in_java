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

    public void deleteNodeAtPosition(int position) {
        if (position == 1) {
            head = head.next;
        } else {
            int count = 1;
            ListNode currNode = head;
            while (count < position - 1) {
                currNode = currNode.next;
                count++;
            }
            currNode.next = currNode.next.next;
        }
    }

    public ListNode searchData(int data) {
        ListNode currNode = head;
        while (currNode != null) {
            if (currNode.data == data) {
                return currNode;
            }
            currNode = currNode.next;
        }
        return null;
    }

    public void printLinkedList() {
        ListNode currNode = head;
        while (currNode != null) {
            System.out.print(currNode.data + "-->");
            currNode = currNode.next;
        }
        System.out.println();
    }

    public void printNode(ListNode node) {
        if (node == null)
            return;
        System.out.println("data: " + node.data);
        System.out.println("next: " + node.next.data);
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
        // singleLinkedList.deleteFirstNode();
        // singleLinkedList.deleteLastNode();
        // singleLinkedList.deleteNodeAtPosition(2);
        System.out.println("Length: " + singleLinkedList.getLength());
        singleLinkedList.printLinkedList();
        singleLinkedList.printNode(singleLinkedList.searchData(3));
    }
}
