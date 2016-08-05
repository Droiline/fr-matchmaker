package flightrising.core;

import java.util.*;

public class Lair {
    private TreeMap<Integer, Dragon> dragons;

    public Lair() {
        dragons = new TreeMap<Integer, Dragon>();
    }

    public TreeMap<Integer, Dragon> getDragons() {
        return dragons;
    }

    public Dragon getDragon(int id) {
        return dragons.get(id);
    }

    public void addDragon(Dragon derg) {
        dragons.put(derg.getId(), derg);
    }

    public void findRelations() {
        Boolean isRelated;
        TreeSet<Integer> intersection;
        Boolean altered = true;

        while (altered) {
            altered = false;

            for (Map.Entry<Integer, Dragon> x : dragons.entrySet()) {
                for (Map.Entry<Integer, Dragon> y : dragons.entrySet()) {
                    //if y is younger than x (avoids repeated comparisons)
                    //and if they're not already named relatives
                    if (x.getKey() < y.getKey() && !x.getValue().getRelatives().contains(y.getKey())) {
                        intersection = new TreeSet<Integer>(x.getValue().getRelatives());
                        intersection.retainAll(y.getValue().getRelatives());

                        if (!intersection.isEmpty()) {
                            for (Integer i : intersection) {
                                if (i < x.getKey() || i < y.getKey()) {
                                    y.getValue().addRelative(x.getKey());
                                    altered = true;
                                }
                            }
                        }

                        if (y.getValue().getRelatives().contains(x.getKey())) {
                            x.getValue().addRelative(y.getKey());
                            altered = true;
                        }
                    }
                }
            }
        }
    }

    public String getNamedRelationString(Dragon dragon) {
        String nameString = "";

        for (Integer x : dragon.getRelatives()) {
            if (dragons.containsKey(x)) {
                nameString = nameString.concat(dragons.get(x).getName() + " ");
            }
        }

        return nameString;
    }

    public String toString() {
        String newline = System.getProperty("line.separator");
        String outString = "";
        String relationString;

        for (Map.Entry<Integer, Dragon> entry : dragons.entrySet()) {
            outString = outString.concat(entry.getValue().toString() + newline);
            relationString = getNamedRelationString(entry.getValue());
            if (!relationString.isEmpty()) {
                outString = outString.concat("Lair relatives: " + relationString + newline);
            }
        }

        return outString;
    }
}
