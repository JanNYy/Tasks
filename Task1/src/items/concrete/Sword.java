package courses.task1.items.concrete;

import courses.task1.items.ItemException;
import courses.task1.items.Weapon;
import courses.task1.items.types.Appointment;
import courses.task1.items.types.DamageTypes;
import courses.task1.items.types.SwordTypes;

public class Sword extends Weapon {

    protected SwordTypes swordType;

    public Sword(SwordTypes type, String swordName, int swordPrice, int swordWeight, int swordDamage) throws ItemException {
        super(swordName, swordPrice, swordWeight, swordDamage, Appointment.ATTACK);
        swordType = type;
        damageType = DamageTypes.SLASHING;
    }

    public SwordTypes getSwordType() {
        return swordType;
    }

    public String toString() {
        return swordType+" \""+name+"\" (price: "+price+", weight: "+weight+", damage type: "+damageType+" "+damage+")";
    }
}
