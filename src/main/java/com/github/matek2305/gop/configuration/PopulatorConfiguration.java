package com.github.matek2305.gop.configuration;

import com.github.matek2305.gop.ValueProvider;

import java.util.Map;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
public class PopulatorConfiguration {

    private final Map<Class<?>, ValueProvider<?>> valueProviderMap;

    private boolean skipNotNullProperties = false;

    public PopulatorConfiguration(Map<Class<?>, ValueProvider<?>> valueProviderMap) {
        this.valueProviderMap = valueProviderMap;
    }

    public boolean hasProviderForType(Class<?> type) {
        return valueProviderMap.containsKey(type);
    }

    @SuppressWarnings("unchecked")
    public <T> ValueProvider<T> getValueProvider(Class<T> type) {
        return (ValueProvider<T>) valueProviderMap.get(type);
    }

    public boolean isSkipNotNullProperties() {
        return skipNotNullProperties;
    }

    public void setSkipNotNullProperties(boolean skipNotNullProperties) {
        this.skipNotNullProperties = skipNotNullProperties;
    }
}
