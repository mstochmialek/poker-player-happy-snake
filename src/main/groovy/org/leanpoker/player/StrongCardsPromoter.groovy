package org.leanpoker.player

class StrongCardsPromoter implements StateAnalyser {

    StateAnalyser.Decision wdyt(def gameState) {
        String myHand = hand(gameState);
        if (myHand.contains('A') || myHand.contains('K')) {
            return StateAnalyser.Decision.STRONG
        }

        StateAnalyser.Decision.PASS
    }

    String hand(def gameState) {
        List myCarts = gameState.players[gameState.in_action].hole_cards;

        myCarts[0].rank + myCarts[1].rank;
    }
}