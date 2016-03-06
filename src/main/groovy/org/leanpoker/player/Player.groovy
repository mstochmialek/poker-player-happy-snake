package org.leanpoker.player

class Player {

    static final String VERSION = 'Default Groovy folding player 1.2';


    static int betRequest(def gameState) {

        String myHand = hand(gameState);
        if (myHand.contains('A') || myHand.contains('K')) {
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

    static List<Card> hand2(def gameState) {
        List myCarts = currentPlayer(gameState).hole_cards;

        return myCarts.collect( { new Card(it)});
    }


    static void showdown(def gameState) {
    }
}