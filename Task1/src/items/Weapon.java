package courses.task1.items;

import courses.task1.items.types.DamageTypes;

public abstract class Weapon extends Item {

    protected int damage;
    protected DamageTypes damageType;

    public Weapon(String weaponName, int weaponPrice, int weaponWeight, int weaponDamage) throws ItemException {
        super(weaponName, weaponPrice, weaponWeight);
        checkDamage(weaponDamage);
        damage = weaponDamage;
    }

    private void checkDamage(int d) throws ItemException {
        if (d < 0) throw new ItemException("Damage is less than 0");
    }

    public int getDamage() {
        return damage;
    }

    public DamageTypes getDamageType() {
        return damageType;
    }

}
