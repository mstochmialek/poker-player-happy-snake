package org.leanpoker.player;

public enum Rank {
    ACE("A"),
    KING("K"),
    QUEEN("Q"),
    JACK("J"),
    C10("10"),
    C09("9"),
    C08("8"),
    C07("7"),
    C06("6"),
    C05("5"),
    C04("4"),
    C03("3"),
    C02("2");

    String value;

    Rank(String value) {
        this.value = value;
    }

    static Rank valueOfName( String name ) {
        values().find { it.value == name }
    }


    boolean higher(Rank other) {
        this.compareTo(other) < 0;
    }
}
