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

	def "four"() {
		given:

		def cards = [
				new Card(KING, HEARTS),
				new Card(KING, SPADES),
				new Card(KING, DIAMONDS),
				new Card(KING, CLUBS),
				new Card(C04, CLUBS)
		];

		expect:
		Figure.basingOn(cards) == Figure.FOUR
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

	def "2 pairs"() {
		given:

		def cards = [
				new Card(C04, HEARTS),
				new Card(KING, SPADES),
				new Card(C04, DIAMONDS),
				new Card(C10, DIAMONDS),
				new Card(KING, CLUBS)
		];

		expect:
		Figure.basingOn(cards) == Figure.TWO_PAIR
	}

	def "house"() {
		given:

		def cards = [
				new Card(ACE, HEARTS),
				new Card(KING, SPADES),
				new Card(ACE, DIAMONDS),
				new Card(ACE, CLUBS),
				new Card(KING, CLUBS)
		];

		expect:
		Figure.basingOn(cards) == Figure.FULL
	}

	def "flush: less than 5 cards"() {
		given:
		def cards = [
				new Card(ACE, HEARTS),
				new Card(KING, HEARTS),
				new Card(QUEEN, HEARTS),
				new Card(JACK, HEARTS)
		];

		expect:
		Figure.basingOn(cards) == Figure.HIGHCARD
	}

	def "flush: 5 cards"() {
		given:
		def cards = [
				new Card(ACE, HEARTS),
				new Card(KING, HEARTS),
				new Card(QUEEN, HEARTS),
				new Card(JACK, HEARTS),
				new Card(C09, HEARTS)
		];

		expect:
		Figure.basingOn(cards) == Figure.FLUSH
	}

	def "flush: more than 5 cards"() {
		given:
		def cards = [
				new Card(ACE, HEARTS),
				new Card(KING, HEARTS),
				new Card(QUEEN, HEARTS),
				new Card(JACK, HEARTS),
				new Card(C09, HEARTS),
				new Card(C09, DIAMONDS),
				new Card(C02, HEARTS)
		];

		expect:
		Figure.basingOn(cards) == Figure.FLUSH
	}

	def "higher"() {
		expect:
		!Figure.PAIR.higher(Figure.FULL)
		Figure.FULL.higher(Figure.PAIR)
	}
}
