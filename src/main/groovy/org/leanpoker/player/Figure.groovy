package org.leanpoker.player;

public enum Figure {
    FULL({ List<Card> cards -> hasMany(cards, 4) }),
    THREE({ List<Card> cards -> hasMany(cards, 3) }),
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

}
