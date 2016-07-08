package flightrising.core;

import static flightrising.core.Rarity.*;

public enum Breed {
    COATL(RARE), FAE(PLENTIFUL), GUARDIAN(PLENTIFUL), IMPERIAL(LIMITED), MIRROR(PLENTIFUL), NOCTURNE(LIMITED), PEARLCATCHER(COMMON), RIDGEBACK(COMMON), SKYDANCER(UNCOMMON), SNAPPER(COMMON), SPIRAL(COMMON), TUNDRA(PLENTIFUL), WILDCLAW(RARE);

    private final Rarity rarity;

    private Breed(Rarity r) {
        rarity = r;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
