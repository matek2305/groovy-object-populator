package com.github.matek2305.gop;

/**
 * @author Mateusz Urbański <matek2305@gmail.com>.
 */
public class Main {

    public static void main(String[] args) {
        PopulatorConfiguration configuration = new PopulatorConfigurationBuilder()
                .withValueProvider(String.class, () -> "string")
                .withValueProvider(long.class, () -> 23L)
                .build();

        ObjectPopulator populator = new ObjectPopulator(configuration);

        SimplePojo simplePojo = populator.populate(new SimplePojo());
        System.out.println(simplePojo);
    }
}
