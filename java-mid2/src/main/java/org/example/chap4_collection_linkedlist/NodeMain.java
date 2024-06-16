package org.example.chap4_collection_linkedlist;

public class NodeMain {

    public static void main(String[] args) {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        System.out.println(first);

        // 모든 노드 탐색
        System.out.println("모든 노드 탐색하기");
        printAll(first);

        // 마지막 노드 조회
        System.out.println("마지막 노드 조회하기");
        Node lastNode = getLastNode(first);
        System.out.println("lastNode = " + lastNode);

        // 특정 index 노드 조회하기
        System.out.println("특정 index 노드 조회하기");
        Node index2Node = getNode(first, 2);
        System.out.println("index2Node = " + index2Node);

        // 노드 추가하기
        System.out.println("노드 추가하기");
        add(first, "D");
        System.out.println(first);
        add(first, "E");
        System.out.println(first);
        add(first, "F");
        System.out.println(first);
    }

    private static void printAll(final Node node) {
        Node iter = node;

        while (iter != null) {
            System.out.println(iter.item);
            iter = iter.next;
        }
    }

    private static Node getLastNode(final Node node) {
        Node iter = node;

        while (iter.next != null) {
            iter = iter.next;
        }
        return iter;
    }

    private static Node getNode(final Node node, final int index) {
        Node x = node;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private static void add(final Node node, final String param) {
        Node lastNode = getLastNode(node);
        lastNode.next = new Node(param);
    }

}
