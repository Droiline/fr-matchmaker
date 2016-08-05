package flightrising.pairing;

import java.util.*;
import flightrising.core.*;

public class BreedingPair {
    private int[] ids;
    private Breed[] breeds;
    private ColourRange primaryRange;
    private ColourRange secondaryRange;
    private ColourRange tertiaryRange;
    private PrimaryGene[] primaryGenes;
    private SecondaryGene[] secondaryGenes;
    private TertiaryGene[] tertiaryGenes;

    public BreedingPair(Dragon x, Dragon y) {
        ids = new int[2];
        ids[0] = x.getId();
        ids[1] = y.getId();
        breeds = new Breed[2];
        breeds[0] = x.getBreed();
        breeds[1] = y.getBreed();
        primaryGenes = new PrimaryGene[2];
        primaryGenes[0] = x.getPrimaryGene();
        primaryGenes[1] = y.getPrimaryGene();
        secondaryGenes = new SecondaryGene[2];
        secondaryGenes[0] = x.getSecondaryGene();
        secondaryGenes[1] = y.getSecondaryGene();
        tertiaryGenes = new TertiaryGene[2];
        tertiaryGenes[0] = x.getTertiaryGene();
        tertiaryGenes[1] = y.getTertiaryGene();

        primaryRange = new ColourRange(x.getPrimaryColour(), y.getPrimaryColour());
        secondaryRange = new ColourRange(x.getSecondaryColour(), y.getSecondaryColour());
        tertiaryRange = new ColourRange(x.getTertiaryColour(), y.getTertiaryColour());
    }

    public String toString() {
        String newline = System.getProperty("line.separator");

        return "Dragons: " + Arrays.toString(ids) + newline +
                "Breeds: " + breeds[0] + " - " + breeds[1] + newline +
                "Primary: " + primaryGenes[0] + " - " + primaryGenes[1] +
                ", " + primaryRange.getRangeSet() + newline +
                "Secondary: " + secondaryGenes[0] + " - " + secondaryGenes[1] +
                ", " + secondaryRange.getRangeSet() + newline +
                "Tertiary: " + tertiaryGenes[0] + " - " + tertiaryGenes[1] +
                ", " + tertiaryRange.getRangeSet();
    }
}
