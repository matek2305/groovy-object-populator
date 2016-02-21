package com.github.matek2305.gop;

import groovy.lang.MetaProperty;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
@FunctionalInterface
public interface ValueProvider<T> {

    T getValue(MetaProperty metaProperty);
}
