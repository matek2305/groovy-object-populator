package com.github.matek2305.gop.configuration;

import com.github.matek2305.gop.ValueProvider;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
public class PopulatorConfigurationBuilder {

    private Map<Class<?>, ValueProvider<?>> valueProviderMap = new HashMap<>();
    private boolean skipNotNullProperties = false;

    public <T> PopulatorConfigurationBuilder withValueProvider(Class<T> type, ValueProvider<T> valueProvider) {
        valueProviderMap.put(type, valueProvider);
        return this;
    }

    public PopulatorConfigurationBuilder skipNotNullProperties() {
        skipNotNullProperties = true;
        return this;
    }

    public PopulatorConfiguration build() {
        PopulatorConfiguration configuration = new PopulatorConfiguration(valueProviderMap);
        configuration.setSkipNotNullProperties(skipNotNullProperties);
        return configuration;
    }
}
