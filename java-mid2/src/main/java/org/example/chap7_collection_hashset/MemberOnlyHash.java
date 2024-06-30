package org.example.chap7_collection_hashset;

import java.util.Objects;

public class MemberOnlyHash {

    private final String id;

    public MemberOnlyHash(final String id) {
        this.id = id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "MemberOnlyHash{" +
                "id='" + id + '\'' +
                '}';
    }

}
