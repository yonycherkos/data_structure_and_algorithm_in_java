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

    /**
     * Reverses the order of the nodes in the linked list.
     * 
     * Uses a three-pointer algorithm that iterates through the list,
     * reversing the next pointer of each node to point to the previous node.
     * 
     * Time complexity is O(N) to iterate through the list.
     * Space complexity is O(1) since only a constant amount of pointers are used.
     */
    public void reverse() {
        ListNode prev = null;
        ListNode current = head;
        ListNode next = null;
        while (current != null) {
            next = current.next;
            current.next = prev;
            prev = current;
            current = next;
        }
        head = prev;
    }

    public ListNode findMiddleNode() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
        }
        return slowPtr;
    }

    public void removeDuplicates() {
        ListNode currNode = head;
        while (currNode != null && currNode.next != null) {
            if (currNode.data == currNode.next.data) {
                currNode.next = currNode.next.next;
            } else {
                currNode = currNode.next;
            }
        }
    }

    public boolean detectLoop() {
        ListNode slowPtr = head;
        ListNode fastPtr = head;
        while (fastPtr != null && fastPtr.next != null) {
            slowPtr = slowPtr.next;
            fastPtr = fastPtr.next.next;
            if (slowPtr == fastPtr) {
                return true;
            }
        }
        return false;
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
        SingleLinkedList sll = new SingleLinkedList();
        sll.head = new ListNode(2);
        sll.addNode(3);
        sll.addNode(4);
        sll.insertNodeAtBegining(1);
        sll.insertNodeAtPosition(3, 3);
        // sll.deleteFirstNode();
        // sll.deleteLastNode();
        // sll.deleteNodeAtPosition(2);
        System.out.println("Length: " + sll.getLength());
        sll.printLinkedList();
        sll.printNode(sll.searchData(3));
        sll.printNode(sll.findMiddleNode());
        sll.removeDuplicates();
        sll.printLinkedList();
        System.out.println("Detect Loop: " + sll.detectLoop());
    }
}
