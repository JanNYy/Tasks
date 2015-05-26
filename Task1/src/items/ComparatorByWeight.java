package courses.task1.items;

import java.util.Comparator;

public class ComparatorByWeight implements Comparator {

    private boolean asc;

    public ComparatorByWeight(boolean isAsc) {
        asc = isAsc;
    }

    public int compare(Object o1, Object o2) {
        if (asc) return ((Item)o1).getWeight()-((Item)o2).getWeight();
        else return ((Item)o2).getWeight()-((Item)o1).getWeight();
    }
}
