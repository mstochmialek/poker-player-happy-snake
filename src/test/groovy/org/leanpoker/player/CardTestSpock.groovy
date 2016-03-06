package org.leanpoker.player

import groovy.json.JsonSlurper
import spock.lang.Specification

import static org.leanpoker.player.Rank.*
import static org.leanpoker.player.Suit.*

/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class CardTestSpock extends Specification {

	def "Parsing"() {
		given:

		def cardJson = new JsonSlurper().parseText('{\n' +
				'            "rank": "4",\n' +
				'            "suit": "spades"\n' +
				'        }')
		def card = new Card(cardJson);

		expect:
		card.suit == SPADES
		card.rank == C04
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
