package courses.task1.items.concrete;

import courses.task1.items.Clothes;
import courses.task1.items.ItemException;
import courses.task1.items.types.Usage;
import courses.task1.items.types.HelmetTypes;

public class Helmet extends Clothes {

    protected HelmetTypes helmetType;

    public Helmet(HelmetTypes type, String helmetName, int helmetPrice, int helmetWeight, int helmetPhysProtection) throws ItemException {
        super(helmetName, helmetPrice, helmetWeight, helmetPhysProtection, Usage.HEAD);
        helmetType = type;
    }

    public HelmetTypes getHelmetType() {
        return helmetType;
    }

    public String toString() {
        return helmetType+" \""+name+"\" (price: "+price+", weight: "+weight+", physical damage protection: "+protectionPhysicalDamage+")";
    }

}
