package org.leanpoker.player

import spock.lang.Specification
/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class RankTestSpock extends Specification {

	def "higher"() {

		expect:
		Rank.ACE.higher(Rank.KING);
		Rank.ACE.higher(Rank.JACK);
		Rank.ACE.higher(Rank.C02);
		Rank.JACK.higher(Rank.C02);
		Rank.JACK.higher(Rank.C10);
		!Rank.JACK.higher(Rank.ACE);
		!Rank.C02.higher(Rank.C03);
		!Rank.C02.higher(Rank.C02);
	}

}
