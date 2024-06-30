package org.example.chap7_collection_hashset;

public class MemberNoHashNoEq {

    private final String id;

    public MemberNoHashNoEq(final String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "MemberNoHashNoEq{" +
                "id='" + id + '\'' +
                '}';
    }

}
