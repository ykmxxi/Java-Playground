package chap02.item02.hierarchy;

public class Calzone extends Pizza {

    private final boolean sauceInside;

    private Calzone(final Builder builder) {
        super(builder);
        sauceInside = builder.sauceInside;
    }

    public static class Builder extends Pizza.Builder<Builder> {

        private boolean sauceInside = false; // 기본 false

        public Builder sauceInside() {
            this.sauceInside = true;
            return this;
        }

        @Override
        public Pizza build() {
            return new Calzone(this);
        }

        @Override
        protected Builder self() {
            return this;
        }

    }

    @Override
    public String toString() {
        return super.toString() + ", sauceInside=" + sauceInside;
    }

}
