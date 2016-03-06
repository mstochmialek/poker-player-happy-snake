package org.leanpoker.player

import spock.lang.Specification

import static org.leanpoker.player.Rank.*
import static org.leanpoker.player.Suit.CLUBS
import static org.leanpoker.player.Suit.DIAMONDS
import static org.leanpoker.player.Suit.HEARTS
import static org.leanpoker.player.Suit.SPADES
/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class GameStateTestSpock extends Specification {

	def "figure: full on both"() {
		given:
		def state = new GameState(
				hand: [
						new Card(ACE, SPADES),
						new Card(KING, HEARTS)
				],
				table: [
						new Card(KING, SPADES),
						new Card(ACE, DIAMONDS),
						new Card(ACE, CLUBS)
				]
		)

		expect:
		state.figure() == Figure.FULL
	}

	def "figure: pair on hand, pair on table"() {
		given:
		def state = new GameState(
				hand: [
						new Card(ACE, SPADES),
						new Card(ACE, HEARTS)
				],
				table: [
						new Card(KING, SPADES),
						new Card(KING, HEARTS),
						new Card(QUEEN, HEARTS)
				]
		)

		expect:
		state.figure() == Figure.TWO_PAIR
	}

	def "figure: pair on hand, three on table"() {
		given:
		def state = new GameState(
				hand: [
						new Card(ACE, SPADES),
						new Card(ACE, HEARTS)
				],
				table: [
						new Card(KING, SPADES),
						new Card(KING, HEARTS),
						new Card(KING, DIAMONDS)
				]
		)

		expect:
		state.figure() == Figure.FULL
	}

	def "figure: nothing on hand, three on table"() {
		given:
		def state = new GameState(
				hand: [
						new Card(C04, SPADES),
						new Card(C03, HEARTS)
				],
				table: [
						new Card(KING, SPADES),
						new Card(KING, HEARTS),
						new Card(KING, DIAMONDS)
				]
		)

		expect:
		state.figure() == Figure.HIGHCARD
	}

	def "Equals"() {
		given:

		def card1 = new Card("4", "spades")
		def card2 = new Card("4", "hearts")

		expect:
		card1 == card2
	}

	def "Equals based on enums"() {
		given:

		def card1 = new Card(C04, SPADES)
		def card2 = new Card(C04, HEARTS)

		expect:
		card1 == card2
	}

	def "higher"() {
		expect:
		new Card(ACE, HEARTS).higher(new Card(KING, HEARTS))
		new Card(ACE, HEARTS).higher(new Card(ACE, SPADES))
		!new Card(KING, HEARTS).higher(new Card(ACE, HEARTS))
	}

}
