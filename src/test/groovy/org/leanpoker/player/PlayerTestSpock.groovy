package org.leanpoker.player

import groovy.json.JsonSlurper
import spock.lang.Specification

/**
 * Java/Groovy unit test using the Spock framework.
 * https://code.google.com/p/spock/
 */
class PlayerTestSpock extends Specification {

	def "The default folding player should fold"() {
		given:
		def gameState = new JsonSlurper().parseText('{"key1": "value1", "key2": "value2"}')

		expect:
		Player.betRequest(gameState) == 0
	}
}
