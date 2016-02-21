package com.github.matek2305.gop

import com.github.matek2305.gop.configuration.PopulatorConfiguration
import spock.lang.Specification
/**
 * @author Mateusz Urbański <matek2305@gmail.com>
 */
class ObjectPopulatorSpec extends Specification {

    def "should throw NPE when trying to populate null object"() {
        given:
            def configuration = new PopulatorConfiguration([:])
        when:
            new ObjectPopulator(configuration).populate(null)
        then:
            thrown(NullPointerException)
    }
}
