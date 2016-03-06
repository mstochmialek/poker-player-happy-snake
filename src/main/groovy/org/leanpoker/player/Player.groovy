package org.leanpoker.player

class Player {

    static final String VERSION = 'Default Groovy folding player 1.5';


    static int betRequest(def gameState) {
        try {
            def myHand = hand2(gameState);
            return doBetRequest(myHand, gameState.minimum_raise)
        } catch (def e) {
            return 0
        }
    }


    static int doBetRequest(List<Card> myHand, int minimum) {
        if (myHand.collect {it.rank}.any { it == 'A' || it == 'K' || it == 'Q' || it == 'J'}) {
            return minimum
        }

        if (myHand[0] == myHand[1]) {
            return Integer.MAX_VALUE
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
