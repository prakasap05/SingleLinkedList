/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package linkedlist;

/**
 *
 * @author prakasa putra
 * My Code: https://github.com/prakasap05/SingleLinkedList
 */
public class LinkedList {
    Node head;
    Node tail;
    int length;

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.length = 0;
    }

    public void append(String value) {
        for (int i = 0; i < value.length(); i++) {
            char ch = value.charAt(i);
            Node newNode = new Node(ch);
            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
            length++;
        }
    }

    public void prepend(String value) {
        for (int i = value.length() - 1; i >= 0; i--) {
            char ch = value.charAt(i);
            Node newNode = new Node(ch);
            if (length == 0) {
                head = newNode;
                tail = newNode;
            } else {
                newNode.next = head;
                head = newNode;
            }
            length++;
        }
    }

    public void append(int index, String value) {
        if (index < 0 || index > length) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            prepend(value);
        } else if (index == length) {
            append(value);
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            Node tempTail = current.next;
            for (int i = 0; i < value.length(); i++) {
                char ch = value.charAt(i);
                Node newNode = new Node(ch);
                current.next = newNode;
                current = newNode;
                length++;
            }
            current.next = tempTail;
        }
    }

    public void removeFirst() {
        if (length == 0) {
            System.out.println("Empty list");
            return;
        }
        head = head.next;
        length--;
        if (length == 0) {
            tail = null;
        }
    }

    public void removeLast() {
        if (length == 0) {
            System.out.println("Empty list");
            return;
        }
        if (length == 1) {
            head = null;
            tail = null;
            length = 0;
            return;
        }
        Node current = head;
        while (current.next != tail) {
            current = current.next;
        }
        current.next = null;
        tail = current;
        length--;
    }

    public void remove(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index");
            return;
        }
        if (index == 0) {
            removeFirst();
        } else if (index == length - 1) {
            removeLast();
        } else {
            Node current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
            length--;
        }
    }

    public void remove(char value) {
        if (length == 0) {
            System.out.println("Empty list");
            return;
        }
        Node current = head;
        Node prev = null;
        while (current != null) {
            if (current.value == value) {
                if (current == head) {
                    head = head.next;
                    if (length == 1) {
                        tail = null;
                    }
                    length--;
                    return;
                } else if (current == tail) {
                    tail = prev;
                    prev.next = null;
                } else {
                    prev.next = current.next;
                }
                length--;
                return;
            }
            prev = current;
            current = current.next;
        }
        System.out.println("Value not found");
    }

    public char get(int index) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index");
            return '\0'; // Return null character ('\0') as an indicator of invalid index
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.value;
    }

    public void set(int index, char value) {
        if (index < 0 || index >= length) {
            System.out.println("Invalid index");
            return;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.value = value;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.value).append(" ");
            current = current.next;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        // create a linked list
        LinkedList ll = new LinkedList();
        // add elements to the linked list
        ll.append("F");
        ll.append("B");
        ll.append("D");
        ll.append("E");
        ll.append("C");
        ll.append("Z");
        ll.prepend("A");
        ll.append(1, "A2");

        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("| Original contents of ll: " + ll + "     |");

        // remove elements from the linked list
        ll.remove('F');
        ll.remove(2);

        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("| Contents of ll after deletion: " + ll + "   |");

        // remove first and last elements
        ll.removeFirst();
        ll.removeLast();
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("| ll after deleting first and last: " + ll + "    |");

        // get and set a value
        char val = ll.get(2);
        ll.set(2, (char) (val + 1));
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
        System.out.println("| ll after changed: " + ll + "                    |");
        System.out.println(" _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _ _");
    }
}
