package flightrising.core;

import java.util.*;

public class Lair {
    private LinkedHashMap<Integer, Dragon> dragons;

    public Lair() {
        dragons = new LinkedHashMap<Integer, Dragon>();
    }

    public LinkedHashMap<Integer, Dragon> getDragons() {
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
        HashSet<Integer> intersection;
        Boolean altered = true;

        while (altered) {
            altered = false;

            for (Map.Entry<Integer, Dragon> x : dragons.entrySet()) {
                for (Map.Entry<Integer, Dragon> y : dragons.entrySet()) {
                    if (x.getKey() != y.getKey()) {
                        if (!y.getValue().getRelatives().contains(x.getKey())) {
                            intersection = new HashSet<Integer>(x.getValue().getRelatives());
                            intersection.retainAll(y.getValue().getRelatives());
                            // System.out.println("Intersection between " + x.getValue().getName() + " and " + y.getValue().getName() + ": " + intersection);

                            if (!intersection.isEmpty() && y.getKey() < x.getKey()) {
                                for (Integer i : intersection) {
                                    if (i < y.getKey()) {
                                        y.getValue().addRelative(x.getKey());
                                        altered = true;
                                    }
                                }
                            }
                        }

                        if (!x.getValue().getRelatives().contains(y.getKey())) {
                            if (y.getValue().getRelatives().contains(x.getKey())) {
                                x.getValue().addRelative(y.getKey());
                                altered = true;
                            }
                        }
                    }
                }
            }
            System.out.println(altered);
        }
    }
}
