package org.leanpoker.player;

public enum Suit {
    HEARTS("hearts"),
    DIAMONDS("diamonds"),
    SPADES("spades"),
    CLUBS("clubs");

    String value;

    Suit(String value) {
        this.value = value;
    }

    static Suit valueOfName( String name ) {
        values().find { it.value == name }
    }

    boolean higher(Suit other) {
        this.compareTo(other) < 0;
    }
}
