package org.leanpoker.player

import spock.lang.Specification

import static org.leanpoker.player.Rank.*
import static org.leanpoker.player.Suit.*
import static org.leanpoker.player.Suit.CLUBS

/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class FigureTestSpock extends Specification {

	def "full"() {
		given:

		def cards = [
				new Card(KING, HEARTS),
				new Card(KING, SPADES),
				new Card(KING, DIAMONDS),
				new Card(KING, CLUBS),
				new Card(C04, CLUBS)
		];

		expect:
		Figure.basingOn(cards) == Figure.FULL
	}

	def "three"() {
		given:

		def cards = [
				new Card(KING, HEARTS),
				new Card(C04, HEARTS),
				new Card(KING, SPADES),
				new Card(C03, DIAMONDS),
				new Card(KING, CLUBS)
		];

		expect:
		Figure.basingOn(cards) == Figure.THREE
	}

	def "pair"() {
		given:

		def cards = [
				new Card(C04, HEARTS),
				new Card(KING, SPADES),
				new Card(C03, DIAMONDS),
				new Card(C10, DIAMONDS),
				new Card(KING, CLUBS)
		];

		expect:
		Figure.basingOn(cards) == Figure.PAIR
	}

}
