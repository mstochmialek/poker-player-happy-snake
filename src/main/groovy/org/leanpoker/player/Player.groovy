package org.leanpoker.player

class Player {

    static final String VERSION = 'Default Groovy folding player 1.5';


    static int betRequest(def gameState) {

        String myHand = hand(gameState);
        if (myHand.contains('A') || myHand.contains('K') || myHand.contains('Q') || myHand.contains('J')) {
            return gameState.minimum_raise
        }

        if (myHand[0] == myHand[1]) {
            return currentPlayer(gameState).stack
        }

        0
    }

    static def currentPlayer(def gameState) {
        gameState.players[gameState.in_action]
    }

    static String hand(def gameState) {
        List myCarts = currentPlayer(gameState).hole_cards;

        myCarts[0].rank + myCarts[1].rank;
    }

    static void showdown(def gameState) {
    }
}
