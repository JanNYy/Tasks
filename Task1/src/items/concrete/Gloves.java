package courses.task1.items.concrete;

import courses.task1.items.Clothes;
import courses.task1.items.ItemException;
import courses.task1.items.types.GlovesTypes;

public class Gloves extends Clothes {

    protected GlovesTypes glovesType;

    public Gloves(GlovesTypes type, String glovesName, int glovesPrice, int glovesWeight, int glovesPhysProtection) throws ItemException {
        super(glovesName, glovesPrice, glovesWeight, glovesPhysProtection);
        glovesType = type;
    }

    public GlovesTypes getGlovesType() {
        return glovesType;
    }

    public String toString() {
        return glovesType+" \""+name+"\" (price: "+price+", weight: "+weight+", physical damage protection: "+protectionPhysicalDamage+")";
    }

}
