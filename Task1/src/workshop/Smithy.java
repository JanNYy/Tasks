package courses.task1.workshop;

import courses.task1.items.*;
import courses.task1.items.concrete.*;
import courses.task1.items.types.*;

public class Smithy {

    public Item createItem(HelmetTypes type, String itemName, int itemPrice, int itemWeight, int physProtection) throws ItemException {
        return new Helmet(type, itemName, itemPrice, itemWeight, physProtection);
    }

    public Item createItem(ArmorTypes type, String itemName, int itemPrice, int itemWeight, int physProtection) throws ItemException {
        return new Armor(type, itemName, itemPrice, itemWeight, physProtection);
    }

    public Item createItem(GlovesTypes type, String itemName, int itemPrice, int itemWeight, int physProtection) throws ItemException {
        return new Gloves(type, itemName, itemPrice, itemWeight, physProtection);
    }

    public Item createItem(BootsTypes type, String itemName, int itemPrice, int itemWeight, int physProtection) throws ItemException {
        return new Boots(type, itemName, itemPrice, itemWeight, physProtection);
    }

    public Item createItem(ShieldTypes type, String itemName, int itemPrice, int itemWeight, int physProtection) throws ItemException {
        return new Shield(type, itemName, itemPrice, itemWeight, physProtection);
    }

    public Item createItem(SwordTypes type, String itemName, int itemPrice, int itemWeight, int physProtection) throws ItemException {
        return new Sword(type, itemName, itemPrice, itemWeight, physProtection);
    }

}
