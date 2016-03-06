package org.leanpoker.player

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = "rank")
class Card {
    Rank rank;
    Suit suit;

    def Card(def json) {
        rank = Rank.valueOfName(json.rank);
        suit = Suit.valueOfName(json.suit);
    }

    def Card(Rank rank, Suit suit) {
        this.rank = rank;
        this.suit = suit;
    }
    def Card(String rank, String suit) {
        this.rank = Rank.valueOfName(rank);
        this.suit = Suit.valueOfName(suit);
    }


}
