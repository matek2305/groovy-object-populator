package com.github.matek2305.gop

import com.github.matek2305.gop.configuration.PopulatorConfiguration
import com.github.matek2305.gop.configuration.PopulatorConfigurationBuilder
import spock.lang.Specification

import java.time.LocalDate
import java.time.Month

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
class SimplePojoPopulationSpec extends Specification {

    def "should populate all fields from SimplePojo class"() {
        given:
            PopulatorConfiguration configuration = new PopulatorConfigurationBuilder()
                    .withValueProvider(String, { return 'string' })
                    .withValueProvider(LocalDate, { return LocalDate.of(1990, Month.MAY, 23) })
                    .withValueProvider(long.class, { return 23L })
                    .build()
            ObjectPopulator populator = new ObjectPopulator(configuration)
        and:
            def obj = new SimplePojo(string: 'already set')
        when:
            obj = populator.populate(obj)
        then:
            'string'.equals(obj.string)
            'string'.equals(obj.anotherString)
            obj.localDate.isEqual(LocalDate.of(1990, Month.MAY, 23))
            obj.bigInteger == null
            obj.longPrimitive == 23L
            !obj.bool
    }

    def "should skip properties set before population"() {
        given:
            PopulatorConfiguration configuration = new PopulatorConfigurationBuilder()
                    .withValueProvider(String, { return 'string' })
                    .withValueProvider(long.class, { return 23L })
                    .skipNotNullProperties()
                    .build()
            ObjectPopulator populator = new ObjectPopulator(configuration)
        and:
            def obj = new SimplePojo(string: 'already set', longPrimitive: 12L)
        when:
            obj = populator.populate(obj)
        then:
            'already set'.equals(obj.string)
            'string'.equals(obj.anotherString)
            obj.localDate == null
            obj.bigInteger == null
            obj.longPrimitive == 12L
            !obj.bool
    }

    class SimplePojo {
        String string;
        LocalDate localDate;
        boolean bool;
        BigInteger bigInteger;
        long longPrimitive;
        String anotherString;
    }
}
