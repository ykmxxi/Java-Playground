package org.example.chap4_collection_linkedlist;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NodeTest {

    @Test
    @DisplayName("노드와 연결: 노드를 만들고 각 노드를 서로 연결")
    void 노드_연결() {
        Node first = new Node("A");
        first.next = new Node("B"); // 두 번째 노드

        Node second = first.next;
        second.next = new Node("C");

        Node third = second.next;

        assertThat(first.next).isEqualTo(second);
        assertThat(first.next.next).isEqualTo(third);
        assertThat(first.next.next.next).isNull();
    }

    @Test
    void 연결된_노드_순회() {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");
        first.next.next.next = new Node("D");

        Node iter = first;
        while (iter != null) {
            System.out.println(iter.item);
            iter = iter.next;
        }
    }

    @Test
    void toStringTest() {
        Node first = new Node("A");
        first.next = new Node("B");
        first.next.next = new Node("C");

        assertThat(first.toString()).isEqualTo("[A->B->C]");
        assertThat(first.next.toString()).isEqualTo("[B->C]");
        assertThat(first.next.next.toString()).isEqualTo("[C]");
    }

}
