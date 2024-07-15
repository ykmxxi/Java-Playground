package org.example.problem;

public enum Suit {
    SPADE("♠"),
    HEART("♥"),
    DIAMOND("♦"),
    CLUB("♣");

    private final String icon;

    Suit(final String icon) {
        this.icon = icon;
    }

    public String getIcon() {
        return icon;
    }

}
