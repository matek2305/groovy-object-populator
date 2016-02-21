package com.github.matek2305.gop

import com.github.matek2305.gop.configuration.PopulatorConfiguration

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
class ObjectPopulator {

    private final PopulatorConfiguration configuration

    ObjectPopulator(PopulatorConfiguration configuration) {
        this.configuration = configuration
    }

    public <T> T populate(T obj) {
        if (obj == null) {
            throw new NullPointerException("population target cannot be null")
        }

        obj.metaClass.properties.forEach({ MetaProperty prop ->
            if (configuration.isSkipNotNullProperties() && prop.getProperty(obj) != null) {
                return
            }

            if (configuration.hasProviderForType(prop.type)) {
                prop.setProperty(obj, configuration.getValueProvider(prop.type).getValue(prop))
            }
        })

        return obj
    }
}
