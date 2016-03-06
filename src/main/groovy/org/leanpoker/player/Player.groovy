package org.leanpoker.player

class Player {

    static final String VERSION = 'Default Groovy folding player 1.1';


    static int betRequest(def gameState) {

        String myHand = hand(gameState);
        if (myHand.contains('A') || myHand.contains('K')) {
            return gameState.minimum_raise
        }

        0
    }

    static String hand(def gameState) {
        List myCarts = gameState.players[gameState.in_action].hole_cards;

        myCarts[0].rank + myCarts[1].rank;
    }

    static void showdown(def gameState) {
    }
}