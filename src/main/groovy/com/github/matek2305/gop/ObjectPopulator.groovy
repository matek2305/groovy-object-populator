package com.github.matek2305.gop
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
            println "?searching for provider of type ${prop.type}"
            if (configuration.hasProviderForType(prop.type)) {
                println "+setting property ${prop.name} of type ${prop.type}"
                prop.setProperty(obj, configuration.getValueProvider(prop.type).getValue())
            } else {
                println "!provider for ${prop.type} not found"
            }
        })

        return obj
    }
}
