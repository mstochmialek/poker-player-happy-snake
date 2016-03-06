package org.leanpoker.player

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = "rank")
class Card {
    Rank rank;
    String suit;

    def Card(def json) {
        rank = Rank.valueOfName(json.rank);
        suit = json.suit;
    }

    def Card(Rank rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
    def Card(String rank, String suit) {
        this.rank = Rank.valueOfName(rank);
        this.suit = suit;
    }


}
