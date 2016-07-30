package flightrising.core;

import static flightrising.core.Rarity.*;

public enum TertiaryGene implements Gene {
    BASIC(PLENTIFUL), CIRCUIT(RARE), CONTOUR(COMMON), CRACKLE(UNCOMMON),
    GEMBOND(LIMITED), GLIMMER(RARE), OKAPI(UNCOMMON), SMOKE(UNCOMMON),
    SPINES(LIMITED), STAINED(RARE), THYLACINE(COMMON), UNDERBELLY(COMMON);

    private Rarity rarity;

    private TertiaryGene(Rarity r) {
        rarity = r;
    }
    
    public Rarity getRarity() {
        return rarity;
    }
}
