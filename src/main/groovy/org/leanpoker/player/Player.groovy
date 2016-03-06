package org.leanpoker.player

class Player {

    static final String VERSION = 'Leanforge 1.8';


    static int betRequest(def gameState) {
        try {
            def myHand = hand2(gameState);
            return doBetRequest(myHand, [], gameState.minimum_raise)
        } catch (def e) {
            return 0
        }
    }


    static int doBetRequest(List<Card> myHand, List<Card> table, int minimum) {
        if (myHand[0] == myHand[1]) {
            return Integer.MAX_VALUE
        }

        if (myHand.collect {it.rank}.any { it == Rank.ACE || it == Rank.KING || it == Rank.QUEEN || it == Rank.JACK}) {
            return minimum
        }

        0
    }

    static def currentPlayer(def gameState) {
        gameState.players[gameState.in_action]
    }

    static List<Card> hand2(def gameState) {
        List myCarts = currentPlayer(gameState).hole_cards;

        return myCarts.collect( { new Card(it)});
    }


    static void showdown(def gameState) {
    }
}
