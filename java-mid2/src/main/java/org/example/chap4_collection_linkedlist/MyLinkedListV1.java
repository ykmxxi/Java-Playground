package org.example.chap4_collection_linkedlist;

public class MyLinkedListV1 {

    private Node first;
    private int size;

    public void add(final Object e) {
        Node newNode = new Node(e);
        if (first == null) {
            first = newNode;
        } else {
            Node lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    private Node getLastNode() {
        Node iter = first;
        while (iter.next != null) {
            iter = iter.next;
        }
        return iter;
    }

    public Object set(final int index, final Object element) {
        Node node = getNode(index);
        Object oldValue = node.item;
        node.item = element;
        return oldValue;
    }

    public Object get(final int index) {
        return getNode(index).item;
    }

    private Node getNode(final int index) {
        Node x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    public int indexOf(final Object e) {
        int index = 0;
        for (Node x = first; x != null; x = x.next) {
            if (e.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV1{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

}
