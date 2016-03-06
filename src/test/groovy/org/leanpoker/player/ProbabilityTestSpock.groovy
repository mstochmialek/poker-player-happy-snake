package org.leanpoker.player

import spock.lang.Specification

class ProbabilityTestSpock extends Specification {

	def "probability table should parse"() {
		given:
		def probTable = Probability.BASE_TABLE;

		expect:
		probTable["2"]["2"] == 51
	}

	def "should return hand probability"() {
		given:
		def state = new GameState();
		state.hand = new ArrayList<>();
		state.hand.add(new Card(Rank.C10, Suit.CLUBS));
		state.hand.add(new Card(Rank.C05, Suit.CLUBS));

		expect:
		Probability.hand(state) == 47
	}
}
