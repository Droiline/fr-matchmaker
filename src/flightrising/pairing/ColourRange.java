package flightrising.pairing;

import java.util.*;
import flightrising.core.Colour;

public class ColourRange{
    Colour start;
    Colour end;
    EnumSet<Colour> rangeSet;

    public ColourRange(Colour x, Colour y) {
        if (x.ordinal() <= y.ordinal()) {
            start = x;
            end = y;
        } else {
            start = y;
            end = x;
        }

        this.setRangeSet();
    }

    public Colour getStartColour() {
        return start;
    }

    public Colour getEndColour() {
        return end;
    }

    private void setRangeSet() {
        //If the difference between the two colours is half the colour wheel or less, return the range between those two colours. Otherwise take the other way around.
        if ((end.ordinal() - start.ordinal()) <= Colour.size / 2) {
            rangeSet = EnumSet.range(start, end);
        } else {
            rangeSet = EnumSet.range(end, Colour.PEARL);
            rangeSet.addAll(EnumSet.range(Colour.MAIZE, start));
        }
    }

    public EnumSet getRangeSet() {
        return rangeSet;
    }
}
