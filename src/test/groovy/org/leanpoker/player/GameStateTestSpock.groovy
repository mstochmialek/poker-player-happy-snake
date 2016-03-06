package org.leanpoker.player

import spock.lang.Specification

import static org.leanpoker.player.Rank.*
import static org.leanpoker.player.Suit.HEARTS
import static org.leanpoker.player.Suit.SPADES
/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class GameStateTestSpock extends Specification {

	def "figure: "() {
		given:
		def state = new GameState(
				hand: [
						new Card(ACE, SPADES),
						new Card(KING, HEARTS)
				],
				table: [
						new Card(KING, SPADES),
						new Card(ACE, HEARTS),
						new Card(ACE, HEARTS)
				]
		)

		expect:
		state.figure() == Figure.FULL
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
