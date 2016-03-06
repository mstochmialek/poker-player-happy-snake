package org.leanpoker.player

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = "rank")
class Card {
    String rank;
    String suit;

    def Card(def json) {
        rank = json.rank;
        suit = json.suit;
    }

    def Card(String rank, String suit) {
        this.rank = rank;
        this.suit = suit;
    }
}
