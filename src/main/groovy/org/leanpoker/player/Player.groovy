package org.leanpoker.player

class Player {

    static final String VERSION = 'Leanforge 1.8';

    static int betRequest(def gameState) {
        try {
            def myHand = hand2(gameState);
            def minimum = 0

            if (gameState.bet_index == 0) {
                minimum = gameState.minimum_raise;
            } else if (gameState.bet_index == 1) {
                minimum = gameState.current_buy_in - currentPlayer(gameState).bet + gameState.minimum_raise;
            } else {
                minimum = gameState.current_buy_in - currentPlayer(gameState).bet + gameState.minimum_raise;
            }

            return doBetRequest(myHand, [], minimum)
        } catch (def e) {
            return 0
        }
    }


    static int doBetRequest(List<Card> myHand, List<Card> table, int minimum) {
        def prob = Probability.hand(myHand);

        if (prob > 45) {
            return minimum;
        }

//        if (myHand[0] == myHand[1]) {
//            return minimum + 5;
//        }
//
//        if (myHand.collect {it.rank}.any { it == Rank.ACE || it == Rank.KING || it == Rank.QUEEN || it == Rank.JACK}) {
//            return minimum
//        }

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
