package chat.common;

public enum Network {

    PORT(12345);

    private final int value;

    Network(final int value) {
        this.value = value;
    }

    public int value() {
        return value;
    }

}
