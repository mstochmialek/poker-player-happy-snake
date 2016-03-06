package org.leanpoker.player;

public enum Suit {
    HEARTS("hearts"),
    SPADES("spades"),
    DIAMONDS("diamonds"),
    CLUBS("clubs");

    String value;

    Suit(String value) {
        this.value = value;
    }

    static Suit valueOfName( String name ) {
        values().find { it.value == name }
    }
}
