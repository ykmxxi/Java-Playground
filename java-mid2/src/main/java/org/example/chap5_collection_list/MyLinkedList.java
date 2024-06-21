package org.example.chap5_collection_list;

public class MyLinkedList<E> implements MyList<E> {

    private Node<E> first;
    private int size;

    @Override
    public void add(final E e) {
        Node<E> newNode = new Node<>(e);
        if (first == null) {
            first = newNode;
        } else {
            Node<E> lastNode = getLastNode();
            lastNode.next = newNode;
        }
        size++;
    }

    @Override
    public void add(final int index, final E e) {
        Node<E> newNode = new Node<>(e);
        if (index == 0) { // 첫 번쨰 위치에 추가
            newNode.next = first;
            first = newNode;
        } else {
            Node<E> prev = getNode(index - 1);
            newNode.next = prev.next;
            prev.next = newNode;
        }
        size++;
    }

    private Node<E> getLastNode() {
        Node<E> iter = first;
        while (iter.next != null) {
            iter = iter.next;
        }
        return iter;
    }

    @Override
    public E set(final int index, final E element) {
        Node<E> node = getNode(index);
        E oldValue = node.item;
        node.item = element;
        return oldValue;
    }

    @Override
    public E remove(final int index) {
        Node<E> removedNode = getNode(index);
        E removedItem = removedNode.item;
        if (index == 0) {
            first = removedNode.next;
        } else {
            Node<E> prev = getNode(index - 1);
            prev.next = removedNode.next;
        }
        removedNode.item = null; // 참조 제거
        removedNode.next = null; // 참조 제거
        size--;
        return removedItem;
    }

    @Override
    public E get(final int index) {
        return getNode(index).item;
    }

    private Node<E> getNode(final int index) {
        Node<E> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    @Override
    public int indexOf(final E e) {
        int index = 0;
        for (Node<E> x = first; x != null; x = x.next) {
            if (e.equals(x.item)) {
                return index;
            }
            index++;
        }
        return -1;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        return "MyLinkedListV3{" +
                "first=" + first +
                ", size=" + size +
                '}';
    }

    private static class Node<E> { // 제네릭 타입 노드 클래스를 중첩 클래스로 선언

        E item;
        Node<E> next;

        public Node(final E item) {
            this.item = item;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append("[");

            Node<E> iter = this;
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

}
