package org.leanpoker.player

import groovy.json.JsonSlurper
import spock.lang.Specification

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
		card.suit == "spades"
		card.rank == "4"
	}

	def "Equals"() {
		given:

		def card1 = new Card("4", "spades")
		def card2 = new Card("4", "hearts")

		expect:
		card1 == card2
	}
}
