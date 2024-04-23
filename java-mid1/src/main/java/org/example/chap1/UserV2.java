package org.example.chap1;

import java.util.Objects;

public class UserV2 {

    private final String id;

    public UserV2(final String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) { // 반사성(Reflexivity): 객체는 자기 자신과 동등해야 한다
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        UserV2 userV2 = (UserV2) o;
        return Objects.equals(id, userV2.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

}
