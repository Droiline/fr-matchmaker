import flightrising.core.*;
import flightrising.pairing.*;

public class Main{
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Enter two colours.");
        } else {
            String colour1 = args[0];
            String colour2 = args[1];
            try {
                ColourRange primary = new ColourRange(Colour.valueOf(colour1.toUpperCase()), Colour.valueOf(colour2.toUpperCase()));

                primary.setRangeSet();

                System.out.println("Range: " + primary.getRangeSet());
            } catch (IllegalArgumentException e) {
                System.out.println(e);
                System.out.println("Colour not found.");
            }
        }
    }
}
