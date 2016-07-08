package flightrising.core;

public enum Rarity {
    PLENTIFUL, COMMON, UNCOMMON, LIMITED, RARE;

    public double calcProbability(Rarity x, Rarity y) {
        double probability = 0;
        //Shortcut
        if (x == y) {
            probability = 0.5;
        } else {
            Rarity a, b;
            Boolean swapped;

            if (x.ordinal() < y.ordinal()) {
                a = x;
                b = y;
                swapped = false;
            } else {
                a = y;
                b = x;
                swapped = true;
            }

            if (a == PLENTIFUL) {
                switch (b) {
                    case COMMON:    probability = 0.3;
                                    break;
                    case UNCOMMON:  probability = 0.15;
                                    break;
                    case LIMITED:   probability = 0.03;
                                    break;
                    case RARE:      probability = 0.01;
                                    break;
                }
            } else if (a == COMMON) {
                switch (b) {
                    case UNCOMMON:  probability = 0.25;
                                    break;
                    case LIMITED:   probability = 0.1;
                                    break;
                    case RARE:      probability = 0.01;
                                    break;
                }
            } else if (a == UNCOMMON) {
                switch (b) {
                    case LIMITED:   probability = 0.15;
                                    break;
                    case RARE:      probability = 0.02;
                }
            } else {
                //The final possibility is LIMITED vs RARE
                probability = 0.03;
            }

            if (swapped) {
                probability--;
            }
        }

        return probability;
    }
}
