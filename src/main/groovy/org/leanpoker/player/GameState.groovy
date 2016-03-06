package org.leanpoker.player

class GameState {
    List<Card> hand
    List<Card> table

    Figure figureOnHand() {
        Figure.basingOn(hand)
    }

    Figure figure() {
        List<Card> allCards = hand + table

        Figure figureOnBoth = Figure.basingOn(allCards)
        Figure figureOnTable = Figure.basingOn(table)

        if (figureOnTable != figureOnBoth) {
            return figureOnBoth
        } else {
            return figureOnHand()
        }
    }

}
