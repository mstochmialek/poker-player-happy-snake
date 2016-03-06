package org.leanpoker.player

interface StateAnalyser {
    enum Decision {
        PASS, IN, STRONG
    }
    Decision wdyt(def gameState)
}
