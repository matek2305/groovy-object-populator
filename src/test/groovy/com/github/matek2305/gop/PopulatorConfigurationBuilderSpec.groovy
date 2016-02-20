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
            configuration.hasProviderForType(String)
            configuration.hasProviderForType(LocalDate)
            'string'.equals(configuration.getValueProvider(String).getValue())
            configuration.getValueProvider(LocalDate).getValue().isEqual(LocalDate.of(1990, Month.MAY, 23))

    }
}
