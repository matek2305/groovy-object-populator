package com.github.matek2305.gop

import java.time.LocalDateTime

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
class ObjectPopulator {

    private static final Map<Class<?>, ValueProvider<?>> valueProviderMap = [
            (String.class): { return "string" },
            (LocalDateTime.class): { return LocalDateTime.now() },
            (Integer.class): { return Integer.valueOf(1) },
            (BigInteger.class): { return new BigInteger('2') },
            (long): { return 23L }
    ]

    static main(args) {
        def obj = new SimplePojo()
        println obj

        obj = populate(obj)

        println obj
    }

    public static <T> T populate(T obj) {
        obj.metaClass.properties.forEach({ MetaProperty prop ->
            println "?searching for provider of type ${prop.type}"
            valueProviderMap.computeIfAbsent(prop.type, { println "!provider for ${prop.type} not found" })
            valueProviderMap.computeIfPresent(prop.type, { Class<?> _, ValueProvider<?> valueProvider ->
                println "+setting property ${prop.name} of type ${prop.type}"
                prop.setProperty(obj, valueProvider.getValue())
            })

        })

        return obj
    }

    @FunctionalInterface
    interface ValueProvider<T> {
        T getValue()
    }
}
