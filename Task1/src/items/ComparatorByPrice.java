package courses.task1.items;

import java.util.Comparator;

public class ComparatorByPrice implements Comparator {

    private boolean asc;

    public ComparatorByPrice(boolean isAsc) {
        asc = isAsc;
    }

    public int compare(Object o1, Object o2) {
        if (asc) return ((Item)o1).getPrice()-((Item)o2).getPrice();
        else return ((Item)o2).getPrice()-((Item)o1).getPrice();
    }
}
