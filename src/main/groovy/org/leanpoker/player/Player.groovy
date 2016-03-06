package org.leanpoker.player

class Player {

    static final String VERSION = 'Leanforge 2.7';

    static player = [stack: 100000];

    static int betRequest(def gameState) {
        try {
            def myHand = hand2(gameState);
            def table = table2(gameState);
            def minimum = 0

            player = currentPlayer(gameState)

            if (gameState.bet_index == 0) {
                minimum = gameState.minimum_raise;
            } else if (gameState.bet_index < 4) {
                minimum = gameState.current_buy_in - currentPlayer(gameState).bet + gameState.minimum_raise;
            } else {
                minimum = gameState.current_buy_in - currentPlayer(gameState).bet;
            }

            return doBetRequest(myHand, table, minimum)
        } catch (def e) {
            return 0
        }
    }


    static int doBetRequest(List<Card> myHand, List<Card> table, int minimum) {
        def prob = Probability.hand(myHand);

        if (table.isEmpty()) {
            if (prob > 60) {
                return minimum;
            } else {
                return 0
            }
        } else {
            def state = new GameState(
                    hand: myHand,
                    table: table
            )

            Figure figure = state.figure();
            if (figure == Figure.HIGHCARD) {
                if (table.size() == 3 && prob > 70) {
                    return minimum
                }

                if (table.size() == 4 && prob > 80) {
                    return minimum
                }

                return 0;
            } else {

                if (figure.higher(Figure.THREE)) {
                    return Integer.MAX_VALUE
                }


                if (figure.higher(Figure.TWO_PAIR)) {
                    return minimum + 20
                }

                if (figure == Figure.PAIR) {
                    return 0
                }
                return minimum;
            }
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

    static List<Card> table2(def gameState) {
        List tableCarts = gameState.community_cards;

        return tableCarts.collect({ new Card(it) });
    }

    static void showdown(def gameState) {
    }
}
