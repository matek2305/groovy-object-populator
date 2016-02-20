package com.github.matek2305.gop;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
public class PopulatorConfigurationBuilder {

    private Map<Class<?>, ValueProvider<?>> valueProviderMap = new HashMap<>();

    public <T> PopulatorConfigurationBuilder withValueProvider(Class<T> type, ValueProvider<T> valueProvider) {
        valueProviderMap.put(type, valueProvider);
        return this;
    }

    public PopulatorConfiguration build() {
        return new PopulatorConfiguration(valueProviderMap);
    }
}
