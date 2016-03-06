package org.leanpoker.player

import spock.lang.Specification
/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class FigureTestSpock extends Specification {

	def "full"() {
		given:

		def cards = [
				new Card(Rank.KING, "hearts"),
				new Card(Rank.KING, "spades"),
				new Card(Rank.KING, "diamonds"),
				new Card(Rank.KING, "clubs"),
				new Card(Rank.C04, "clubs")
		];

		expect:
		Figure.basingOn(cards) == Figure.FULL
	}

	def "three"() {
		given:

		def cards = [
				new Card(Rank.KING, "hearts"),
				new Card(Rank.C04, "hearts"),
				new Card(Rank.KING, "spades"),
				new Card(Rank.C03, "diamonds"),
				new Card(Rank.KING, "clubs")
		];

		expect:
		Figure.basingOn(cards) == Figure.THREE
	}

	def "pair"() {
		given:

		def cards = [
				new Card(Rank.C04, "hearts"),
				new Card(Rank.KING, "spades"),
				new Card(Rank.C03, "diamonds"),
				new Card(Rank.C10, "diamonds"),
				new Card(Rank.KING, "clubs")
		];

		expect:
		Figure.basingOn(cards) == Figure.PAIR
	}

}
