package courses.task1.items;

public abstract class Clothes extends Item{

    protected int protectionPhysicalDamage;

    public Clothes(String clothesName, int clothesPrice, int clothesWeight, int clothesPhysProtection) throws ItemException {
        super(clothesName, clothesPrice, clothesWeight);
        checkProtection(clothesPhysProtection);
        protectionPhysicalDamage = clothesPhysProtection;
    }

    private void checkProtection(int p) throws ItemException {
        if (p < 0) throw new ItemException("Protection is less than 0");
    }

    public int getProtectionPhysicalDamage() {
        return protectionPhysicalDamage;
    }

}
