package org.leanpoker.player

import groovy.json.JsonSlurper
import spock.lang.Specification
import spock.lang.Unroll

/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class PlayerTestSpock extends Specification {

	def "The default folding player should fold"() {
		given:
		def gameState = new JsonSlurper().parseText(new File("gameState.json").text)

		expect:
		Player.betRequest(gameState) == 240
	}


	@Unroll
	def "for #a and #b should bet #expectedBet"(Card a, Card b, int expectedBet) {
		given:
		def myHand = [a, b]

		when:
		def betResult = Player.doBetRequest(myHand, [], 10)

		then:
		betResult == expectedBet

		where:
		a | b | expectedBet
		new Card(Rank.ACE, Suit.CLUBS) | new Card(Rank.ACE, Suit.DIAMONDS) | Integer.MAX_VALUE
		new Card(Rank.KING, Suit.CLUBS) | new Card(Rank.KING, Suit.DIAMONDS) | Integer.MAX_VALUE
		new Card(Rank.JACK, Suit.CLUBS) | new Card(Rank.JACK, Suit.DIAMONDS) | Integer.MAX_VALUE
		new Card(Rank.QUEEN, Suit.CLUBS) | new Card(Rank.QUEEN, Suit.DIAMONDS) | Integer.MAX_VALUE
		new Card(Rank.C09, Suit.CLUBS) | new Card(Rank.C09, Suit.DIAMONDS) | Integer.MAX_VALUE
		new Card(Rank.ACE, Suit.CLUBS) | new Card(Rank.C03, Suit.DIAMONDS) | 10
		new Card(Rank.KING, Suit.CLUBS) | new Card(Rank.C03, Suit.DIAMONDS) | 10
		new Card(Rank.QUEEN, Suit.CLUBS) | new Card(Rank.C03, Suit.DIAMONDS) | 10
		new Card(Rank.JACK, Suit.CLUBS) | new Card(Rank.C03, Suit.DIAMONDS) | 10
		new Card(Rank.C02, Suit.CLUBS) | new Card(Rank.C03, Suit.DIAMONDS) | 0
	}


}
