package courses.task1.items.concrete;

import courses.task1.items.Clothes;
import courses.task1.items.ItemException;
import courses.task1.items.types.Usage;
import courses.task1.items.types.ShieldTypes;

public class Shield extends Clothes {

    protected ShieldTypes shieldType;

    public Shield(ShieldTypes type, String shieldName, int shieldPrice, int shieldWeight, int shieldPhysProtection) throws ItemException {
        super(shieldName, shieldPrice, shieldWeight, shieldPhysProtection, Usage.BLOCKING);
        shieldType = type;
    }

    public ShieldTypes getShieldType() {
        return shieldType;
    }

    public String toString() {
        return shieldType+" \""+name+"\" (price: "+price+", weight: "+weight+", physical damage protection: "+protectionPhysicalDamage+")";
    }

}
