package flightrising.core;

import static flightrising.core.Rarity.*;

public enum SecondaryGene implements Gene {
    BASIC(PLENTIFUL), BUTTERFLY(RARE), CURRENT(COMMON), DAUB(COMMON),
    EYESPOTS(COMMON), FACET(RARE), FRECKLE(COMMON), HEX(UNCOMMON),
    HYPNOTIC(UNCOMMON), PAINT(COMMON), PEREGRINE(COMMON), SATURN(UNCOMMON),
    SERAPH(UNCOMMON), SHIMMER(RARE), STRIPES(COMMON), TOXIN(LIMITED);

    private Rarity rarity;

    private SecondaryGene(Rarity r) {
        rarity = r;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
