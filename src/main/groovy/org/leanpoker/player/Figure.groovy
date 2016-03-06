package org.leanpoker.player;

public enum Figure {
    FOUR({ List<Card> cards -> hasMany(cards, 4) }),
    FULL({ List<Card> cards ->
        Card three = cards.find {cards.count(it) >= 3}
        three != null && cards.any { three != it && cards.count(it) >= 2}
    }),
    THREE({ List<Card> cards -> hasMany(cards, 3) }),
    TWO_PAIR ({ List<Card> cards ->
        Card firstPair = cards.find {cards.count(it) >= 2}
        cards.any { firstPair != it && cards.count(it) >= 2}
    }),
    PAIR ({ List<Card> cards -> hasMany(cards, 2) }),
    HIGHCARD ({ true });

    Figure(def hasImpl) {
        this.has = hasImpl
    }

    def has;

    def static hasMany(List<Card> cards, def n) {
        cards.any {cards.count(it) >= n}
    }

    static Figure basingOn(List<Card> cards) {
        values().find { it.has(cards)}
    }

    boolean higher(Figure other) {
        this.compareTo(other) < 0;
    }
}
