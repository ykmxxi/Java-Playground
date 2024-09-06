package chap02.item02.hierarchy;

import java.util.EnumSet;
import java.util.Objects;
import java.util.Set;

// 빌더 패턴은 계층적으로 설계된 클래스와 함께 쓰기 좋다
public abstract class Pizza {

    public enum Topping {HAM, MUSHROOM, ONION, PEPPER, SAUSAGE}

    private final Set<Topping> toppings;

    abstract static class Builder<T extends Builder<T>> {

        EnumSet<Topping> toppings = EnumSet.noneOf(Topping.class);

        public T addTopping(final Topping topping) {
            toppings.add(Objects.requireNonNull(topping));
            return self();
        }

        abstract Pizza build();

        // 하위 클래스는 self()를 오버라이딩해 this 반환하도록 구현
        // 형변환 없이 Pizza를 반환할 수 있음
        protected abstract T self();

    }

    Pizza(Builder<?> builder) {
        toppings = builder.toppings.clone();
    }

    public void print() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "'s toppings=" + toppings;
    }

}
