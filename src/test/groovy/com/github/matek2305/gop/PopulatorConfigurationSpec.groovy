package com.github.matek2305.gop

import com.github.matek2305.gop.configuration.PopulatorConfiguration
import spock.lang.Specification

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
class PopulatorConfigurationSpec extends Specification {

    def "should have provider for given type"() {
        given:
            ValueProvider<String> stringValueProvider = { return 'string' }
        when:
            PopulatorConfiguration configuration = new PopulatorConfiguration([(String.class): stringValueProvider])
        then:
            configuration.hasProviderForType(String)
            configuration.getValueProvider(String) == stringValueProvider
            'string'.equals(configuration.getValueProvider(String).getValue(null))
    }

    def "should not have any providers when empty map"() {
        when:
            PopulatorConfiguration configuration = new PopulatorConfiguration([:])
        then:
            !configuration.hasProviderForType(String)
            configuration.getValueProvider(String) == null
    }

    def "skip not null properties should be set to false by default"() {
        expect:
            !new PopulatorConfiguration([:]).skipNotNullProperties
    }
}
