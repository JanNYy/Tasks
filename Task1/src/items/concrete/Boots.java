package courses.task1.items.concrete;

import courses.task1.items.Clothes;
import courses.task1.items.ItemException;
import courses.task1.items.types.Usage;
import courses.task1.items.types.BootsTypes;

public class Boots extends Clothes {

    protected BootsTypes bootsType;

    public Boots(BootsTypes type, String bootsName, int bootsPrice, int bootsWeight, int bootsPhysProtection) throws ItemException {
        super(bootsName, bootsPrice, bootsWeight, bootsPhysProtection, Usage.LEGS);
        bootsType = type;
    }

    public BootsTypes getBootsType() {
        return bootsType;
    }

    public String toString() {
        return bootsType+" \""+name+"\" (price: "+price+", weight: "+weight+", physical damage protection: "+protectionPhysicalDamage+")";
    }

}
