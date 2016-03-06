package org.leanpoker.player

import groovy.json.JsonSlurper

class Probability {

    public static final def BASE_TABLE = new JsonSlurper().parseText(Player.class.getResource("/baseTable.json").text);

    static int hand(GameState gameState) {
        def card1Rank = gameState.hand.get(0).rank;
        def card2Rank = gameState.hand.get(1).rank;

        return BASE_TABLE[card1Rank.value][card2Rank.value];
    }
}
