package courses.task1.items;

import courses.task1.items.concrete.*;

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

    private String isWhat(Item item) {
        if (isHelmet(item)) return ((Helmet)item).getClass().getSimpleName();
        if (isArmor(item)) return ((Armor)item).getClass().getSimpleName();
        if (isGloves(item)) return ((Gloves)item).getClass().getSimpleName();
        if (isBoots(item)) return ((Boots)item).getClass().getSimpleName();
        if (isWeapon(item)) return ((Weapon)item).getClass().getSimpleName();
        if (isShield(item)) return ((Shield)item).getClass().getSimpleName();
        else return "";
    }

    private boolean isHelmet(Item item) {
        return item instanceof Helmet;
    }

    private boolean isArmor(Item item) {
        return item instanceof Armor;
    }

    private boolean isGloves(Item item) {
        return item instanceof Gloves;
    }

    private boolean isBoots(Item item) {
        return item instanceof Boots;
    }

    private boolean isWeapon(Item item) {
        return item instanceof Weapon;
    }

    private boolean isShield(Item item) {
        return item instanceof Shield;
    }

    private int findPosForAdd(Item item) {
        String other = isWhat(item);
        for (int i = 0; i < ammo.size(); i++)
            if (other.equals(isWhat(ammo.get(i))))
                return i;
        return -1;
    }

    public void dressItem(Item item) throws CloneNotSupportedException, ItemException {
        checkItem(item);
        int itemPos = findPosForAdd(item);
        if (itemPos != -1)
            ammo.set(itemPos, item.clone());
        else ammo.add(item);
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

}
