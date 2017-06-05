package flightrising.core;

import static flightrising.core.Rarity.*;

public enum PrimaryGene implements Gene {
    BASIC(PLENTIFUL), BAR(UNCOMMON), CHERUB(UNCOMMON), CLOWN(COMMON),
    CRYSTAL(RARE), FALCON(COMMON), GIRAFFE(UNCOMMON), IRIDESCENT(RARE),
    JUPITER(UNCOMMON), METALLIC(RARE), PETAL(RARE), PIEBALD(COMMON),
    POISON(LIMITED), RIPPLE(UNCOMMON), SAVANNA(COMMON), SKINK(LIMITED),
    SPECKLE(COMMON), TIGER(COMMON), VIPERA(UNCOMMON);

    private Rarity rarity;

    private PrimaryGene(Rarity r) {
        rarity = r;
    }

    public Rarity getRarity() {
        return rarity;
    }
}
