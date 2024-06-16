package org.example.chap4_collection_linkedlist;

public class Node {

    Object item;
    Node next;

    public Node(final Object item) {
        this.item = item;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("[");

        Node iter = this;
        while (iter != null) {
            sb.append(iter.item);
            if (iter.next != null) {
                sb.append("->");
            }
            iter = iter.next;
        }
        sb.append("]");
        return sb.toString();
    }

}
