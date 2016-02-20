package com.github.matek2305.gop;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
@FunctionalInterface
public interface ValueProvider<T> {

    T getValue();
}
