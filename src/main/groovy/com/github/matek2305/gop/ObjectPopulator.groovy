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
        obj.metaClass.properties.forEach({ MetaProperty prop ->
            if (configuration.hasProviderForType(prop.type)) {
                prop.setProperty(obj, configuration.getValueProvider(prop.type).getValue())
            }
        })

        return obj
    }
}
