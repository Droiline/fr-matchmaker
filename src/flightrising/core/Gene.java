package flightrising.core;

import static flightrising.core.Rarity.*;

public class Gene {
    public enum Primary {
        BASIC(PLENTIFUL), BAR(UNCOMMON), CHERUB(UNCOMMON), CLOWN(COMMON), CRYSTAL(RARE), GIRAFFE(UNCOMMON), IRIDESCENT(RARE), JUPITER(UNCOMMON), PETAL(RARE), PIEBALD(COMMON), POISON(LIMITED), RIPPLE(UNCOMMON), SPECKLE(COMMON), TIGER(COMMON), VIPERA(UNCOMMON);

        private final Rarity rarity;

        private Primary(Rarity r) {
            rarity = r;
        }

        public Rarity getRarity() {
            return rarity;
        }
    }

    public enum Secondary {
        BASIC(PLENTIFUL), BUTTERFLY(RARE), CURRENT(COMMON), DAUB(COMMON), EYESPOTS(COMMON), FACET(RARE), FRECKLE(COMMON), HEX(UNCOMMON), HYPNOTIC(UNCOMMON), PAINT(COMMON), PEREGRINE(COMMON), SATURN(UNCOMMON), SERAPH(UNCOMMON), SHIMMER(RARE), STRIPES(COMMON), TOXIN(LIMITED);

        private final Rarity rarity;

        private Secondary(Rarity r) {
            rarity = r;
        }

        public Rarity getRarity() {
            return rarity;
        }
    }

    public enum Tertiary {
        BASIC(PLENTIFUL), CIRCUIT(RARE), CONTOUR(COMMON), CRACKLE(UNCOMMON), GEMBOND(LIMITED), GLIMMER(RARE), OKAPI(UNCOMMON), SMOKE(UNCOMMON), SPINES(LIMITED), STAINED(RARE), THYLACINE(COMMON), UNDERBELLY(COMMON);

        private final Rarity rarity;

        private Tertiary(Rarity r) {
            rarity = r;
        }

        public Rarity getRarity() {
            return rarity;
        }
    }
}
