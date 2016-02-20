package com.github.matek2305.gop;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
public class Main {

    public static void main(String[] args) {
        SimplePojo simplePojo = ObjectPopulator.populate(new SimplePojo());
        System.out.println(simplePojo);
    }
}
