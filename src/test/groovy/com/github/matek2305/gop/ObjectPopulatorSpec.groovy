package com.github.matek2305.gop

import com.github.matek2305.gop.configuration.PopulatorConfiguration
import com.github.matek2305.gop.configuration.PopulatorConfigurationBuilder
import com.github.matek2305.gop.test.SimplePojo
import spock.lang.Shared
import spock.lang.Specification
import spock.lang.Unroll

import java.time.LocalDate
import java.time.Month

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
class ObjectPopulatorSpec extends Specification {

    @Shared
    private PopulatorConfiguration configuration = new PopulatorConfigurationBuilder()
            .withValueProvider(String, { return 'string' })
            .withValueProvider(LocalDate, { return LocalDate.of(1990, Month.MAY, 23) })
            .withValueProvider(BigInteger, { return new BigInteger('123') })
            .build()

    @Shared
    private ObjectPopulator populator = new ObjectPopulator(configuration)

    @Unroll
    def "should populate all fields from #obj.class.simpleName"(Object obj, Object expected) {
        expect:
            populator.populate(obj) == expected
        where:
            obj << [ new SimplePojo() ]
            expected << [ new SimplePojo(string: 'string', localDate: LocalDate.of(1990, Month.MAY, 23), bigInteger: new BigInteger('123')) ]
    }
}
