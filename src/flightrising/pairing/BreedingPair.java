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
    private double probPerEgg;
    private double probPerNest;

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

        probPerEgg = 0;
        probPerNest = 0;
    }

    public int[] getIds() {
        return ids;
    }

    //the chance of said pair producing a certain offspring.
    //the boolean inputs are switches to declare which aspects are to be taken into account
    public void setBreedingProbability(Dragon target, boolean mBreed,
            boolean mPrimCol, boolean mPrimGen, boolean mSecCol, boolean mSecGen,
            boolean mTerCol, boolean mTerGen) {
        boolean possible = true;
        double prob = 1;

        if (mBreed && possible) {
            if (target.getBreed() == breeds[0] || target.getBreed() == breeds[1]) {
                prob *= breeds[0].getRarity().calcProbability(breeds[1].getRarity());
            } else {
                prob = 0;
                possible = false;
            }
        }

        if (mPrimCol && possible) {
            if (primaryRange.contains(target.getPrimaryColour())) {
                prob *= 1.0 / primaryRange.getRangeSet().size();
            } else {
                prob = 0;
                possible = false;
            }
        }

        if (mPrimGen && possible) {
            if (target.getPrimaryGene() == primaryGenes[0] || target.getPrimaryGene() == primaryGenes[1]) {
                prob *= primaryGenes[0].getRarity().calcProbability(primaryGenes[1].getRarity());
            } else {
                prob = 0;
                possible = false;
            }
        }

        if (mSecCol && possible) {
            if (secondaryRange.contains(target.getSecondaryColour())) {
                prob *= 1.0 / secondaryRange.getRangeSet().size();
            } else {
                prob = 0;
                possible = false;
            }
        }

        if (mSecGen && possible) {
            if (target.getSecondaryGene() == secondaryGenes[0] || target.getSecondaryGene() == secondaryGenes[1]) {
                prob *= secondaryGenes[0].getRarity().calcProbability(secondaryGenes[1].getRarity());
            } else {
                prob = 0;
                possible = false;
            }
        }

        if (mTerCol && possible) {
            if (tertiaryRange.contains(target.getTertiaryColour())) {
                prob *= 1.0 / tertiaryRange.getRangeSet().size();
            } else {
                prob = 0;
                possible = false;
            }
        }

        if (mTerGen && possible) {
            if (target.getTertiaryGene() == tertiaryGenes[0] || target.getTertiaryGene() == tertiaryGenes[1]) {
                prob *= tertiaryGenes[0].getRarity().calcProbability(tertiaryGenes[1].getRarity());
            } else {
                prob = 0;
                possible = false;
            }
        }

        //if the two species are different, you get more eggs. can't remember the amounts so this is placeholder
        if (possible) {
            if (breeds[0] == breeds[1]) {
                //two eggs
                probPerNest = prob * 2;
            } else {
                //three eggs
                probPerNest = prob * 3;
            }
        }

        probPerEgg = prob;
    }

    public double getProbability() {
        return probPerNest;
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
                ", " + tertiaryRange.getRangeSet() + newline +
                "Probability; " + probPerNest;
    }
}
