package org.leanpoker.player

import spock.lang.Specification
/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class SuitTestSpock extends Specification {

	def "higher"() {

		expect:
		Suit.HEARTS.higher(Suit.DIAMONDS);
		Suit.HEARTS.higher(Suit.CLUBS);
		!Suit.DIAMONDS.higher(Suit.HEARTS);
		!Suit.CLUBS.higher(Suit.SPADES);
		!Suit.CLUBS.higher(Suit.CLUBS);
	}

}
