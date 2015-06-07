package courses.task1.items;

import java.util.ArrayList;
import java.util.Collections;

//dressed items
public class Ammunition implements Cloneable {

    private ArrayList<Item> ammo = new ArrayList<Item>();

    private void checkItem(Item item) throws ItemException {
        if (item == null) throw new ItemException("Item is null");
    }

    private void checkIndex(int index) throws ItemException {
        if (index < 0) throw new ItemException("Index is less than 0");
    }

    private int identifyWeight(Item item) {
        return item.getWeight();
    }

    private int identifyPrice(Item item) {
        return item.getPrice();
    }

    public int ammunitionWeight() {
        int weight = 0;
        for (Item i : ammo)
            weight += identifyWeight(i);
        return weight;
    }

    public int ammunitionPrice() {
        int price = 0;
        for (Item i : ammo)
            price += identifyPrice(i);
        return price;
    }

    private int findPosForAdd(Item item) {
        for (int i = 0; i < ammo.size(); i++)
            if (item.getUsedFor() == (ammo.get(i)).getUsedFor())
                return i;
        return -1;
    }

    public void dressItem(Item item) throws CloneNotSupportedException, ItemException {
        checkItem(item);
        int itemPos = findPosForAdd(item);
        if (itemPos != -1)
            ammo.set(itemPos, item.clone());
        else ammo.add(item.clone());
    }

    public void removeItem(Item item) throws ItemException {
        checkItem(item);
        int itemPos = ammo.indexOf(item);
        if (itemPos == -1)
            throw new ItemException("No such item");
        else ammo.remove(itemPos);
    }

    public void sortByWeight(boolean isAsc) {
        Collections.sort(ammo, new ComparatorByWeight(isAsc));
    }

    public void sortByPrice(boolean isAsc) {
        Collections.sort(ammo, new ComparatorByPrice(isAsc));
    }

    public Ammunition getPriceFromTo(int from, int to) throws CloneNotSupportedException, ItemException {
        checkIndex(from);
        checkIndex(to);
        if (from > to)
        {
            int tempInd = from;
            from = to;
            to = tempInd;
        }
        Ammunition newAmmo = new Ammunition();
        for (Item i : ammo)
            if ((identifyPrice(i) >= from) && (identifyPrice(i) <= to))
                newAmmo.ammo.add(i.clone());
        return newAmmo;
    }

    public Ammunition getWeightFromTo(int from, int to) throws CloneNotSupportedException, ItemException {
        checkIndex(from);
        checkIndex(to);
        if (from > to)
        {
            int tempInd = from;
            from = to;
            to = tempInd;
        }
        Ammunition newAmmo = new Ammunition();
        for (Item i : ammo)
            if ((identifyWeight(i) >= from) && (identifyWeight(i) <= to))
                newAmmo.ammo.add(i.clone());
        return newAmmo;
    }

    public int numberOfElements() {
        return ammo.size();
    }

    public String toString() {
        return "Ammunition "+ammo.toString();
    }

    public Ammunition clone() throws CloneNotSupportedException {
        Ammunition cloneAmmo = (Ammunition)super.clone();
        cloneAmmo.ammo = (ArrayList<Item>)ammo.clone();
        return cloneAmmo;
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ammunition)) return false;

        Ammunition that = (Ammunition) o;

        return !(ammo != null ? !ammo.equals(that.ammo) : that.ammo != null);

    }

    public int hashCode() {
        return ammo != null ? ammo.hashCode() : 0;
    }
}
