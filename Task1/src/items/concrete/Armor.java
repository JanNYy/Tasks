package courses.task1.items.concrete;

import courses.task1.items.Clothes;
import courses.task1.items.ItemException;
import courses.task1.items.types.Usage;
import courses.task1.items.types.ArmorTypes;

public class Armor extends Clothes {

    protected ArmorTypes armorType;

    public Armor(ArmorTypes type, String armorName, int armorPrice, int armorWeight, int armorPhysProtection) throws ItemException {
        super(armorName, armorPrice, armorWeight, armorPhysProtection, Usage.BODY);
        armorType = type;
    }

    public ArmorTypes getArmorType() {
        return armorType;
    }

    public String toString() {
        return armorType+" \""+name+"\" (price: "+price+", weight: "+weight+", physical damage protection: "+protectionPhysicalDamage+")";
    }

}
