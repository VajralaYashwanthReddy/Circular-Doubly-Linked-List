class Node {
    int data;
    Node next;
    Node prev;

    public Node(int data) {
        this.data = data;
        this.next = null;
        this.prev = null;
    }
}

class CircularDoublyLinkedList {
    private Node head;

    public CircularDoublyLinkedList() {
        head = null;
    }

    // Insert a new node at the end
    public void insert(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
            head.next = head;
            head.prev = head;
        } else {
            Node tail = head.prev;
            tail.next = newNode;
            newNode.prev = tail;
            newNode.next = head;
            head.prev = newNode;
        }
    }

    // Delete a node by value
    public void delete(int data) {
        if (head == null) return;

        Node current = head;
        do {
            if (current.data == data) {
                if (current == head && current.next == head) {
                    head = null; // List is now empty
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                    if (current == head) {
                        head = current.next; // Update head if necessary
                    }
                }
                return;
            }
            current = current.next;
        } while (current != head);
    }

    // Display the list
    public void display() {
        if (head == null) return;

        Node current = head;
        do {
            System.out.print(current.data + " ");
            current = current.next;
        } while (current != head);
        System.out.println();
    }

    // Display the list in reverse
    public void displayReverse() {
        if (head == null) return;

        Node tail = head.prev;
        Node current = tail;
        do {
            System.out.print(current.data + " ");
            current = current.prev;
        } while (current != tail);
        System.out.println();
    }

    public static void main(String[] args) {
        CircularDoublyLinkedList list = new CircularDoublyLinkedList();

        // Inserting elements
        list.insert(10);
        list.insert(20);
        list.insert(30);
        list.insert(40);

        System.out.println("Circular Doubly Linked List:");
        list.display();

        System.out.println("Reverse Circular Doubly Linked List:");
        list.displayReverse();

        // Deleting an element
        list.delete(20);
        System.out.println("After deleting 20:");
        list.display();
    }
}