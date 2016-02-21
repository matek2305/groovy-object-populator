package com.github.matek2305.gop

import com.github.matek2305.gop.configuration.PopulatorConfiguration
import com.github.matek2305.gop.configuration.PopulatorConfigurationBuilder
import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
class PopulatorConfigurationBuilderSpec extends Specification {

    def "should build configuration with given providers"() {
        given:
            ValueProvider<String> stringValueProvider = { return 'string' }
            ValueProvider<LocalDate> localDateValueProvider = { return LocalDate.of(1990, Month.MAY, 23) }
        when:
            PopulatorConfiguration configuration = new PopulatorConfigurationBuilder()
                    .withValueProvider(String, stringValueProvider)
                    .withValueProvider(LocalDate, localDateValueProvider)
                    .build()
        then:
            !configuration.skipNotNullProperties
            configuration.hasProviderForType(LocalDate)
            configuration.hasProviderForType(String)
            configuration.getValueProvider(LocalDate).getValue(null).isEqual(LocalDate.of(1990, Month.MAY, 23))
            'string'.equals(configuration.getValueProvider(String).getValue(null))
    }

    def "should set skip not null properties config"() {
        when:
            PopulatorConfiguration configuration = new PopulatorConfigurationBuilder()
                    .skipNotNullProperties()
                    .build()
        then:
            configuration.skipNotNullProperties
    }
}
