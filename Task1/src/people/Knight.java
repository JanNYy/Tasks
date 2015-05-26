package courses.task1.people;

import courses.task1.items.Ammunition;
import courses.task1.items.Item;
import courses.task1.items.ItemException;

public class Knight extends Human {

    //Knight's characteristics

    private final static int MIN_CHARACTERISTIC_VALUE = 1;
    private final static int MAX_CHARACTERISTIC_VALUE = 99;

    private final static int BASE_WEIGHT_LOAD = 40;

    private int vitality;
    private int strength;
    private int endurance;
    private int dexterity;

    //Knight's wallet
    private int gold;

    //Knight's inventory
    //private final ItemList inventory = new ItemList();

    //Knight's ammunition
    private final Ammunition ammunition = new Ammunition();

    public Knight(String knightName, int knightAge, Gender knightGender) throws PeopleException {
        this(knightName, knightAge, knightGender, MIN_CHARACTERISTIC_VALUE, MIN_CHARACTERISTIC_VALUE, MIN_CHARACTERISTIC_VALUE, MIN_CHARACTERISTIC_VALUE, 0);
    }

    public Knight(String knightName, int knightAge, Gender knightGender, int knightGold) throws PeopleException {
        this(knightName, knightAge, knightGender, MIN_CHARACTERISTIC_VALUE, MIN_CHARACTERISTIC_VALUE, MIN_CHARACTERISTIC_VALUE, MIN_CHARACTERISTIC_VALUE, knightGold);
    }

    public Knight(String knightName, int knightAge, Gender knightGender,
                  int knightVitality, int knightStrength, int knightEndurance, int knightDexterity) throws PeopleException {
        this(knightName, knightAge, knightGender, knightVitality, knightStrength, knightEndurance, knightDexterity, 0);
    }

    public Knight(String knightName, int knightAge, Gender knightGender,
                  int knightVitality, int knightStrength, int knightEndurance, int knightDexterity, int knightGold) throws PeopleException {
        super(knightName, knightAge, knightGender);
        characteristicCheck(knightVitality);
        characteristicCheck(knightStrength);
        characteristicCheck(knightEndurance);
        characteristicCheck(knightDexterity);
        vitality = knightVitality;
        strength = knightStrength;
        endurance = knightEndurance;
        dexterity = knightDexterity;
        gold = knightGold;
    }

    private void characteristicCheck(int characteristic) throws PeopleException {
        if (characteristic < MIN_CHARACTERISTIC_VALUE) throw new PeopleException("Characteristic value is less than "+MIN_CHARACTERISTIC_VALUE);
        if (characteristic > MAX_CHARACTERISTIC_VALUE) throw new PeopleException("Characteristic value is greater than "+MAX_CHARACTERISTIC_VALUE);
    }

    private void goldCheck(int goldNum) throws PeopleException {
        if (goldNum <= 0) throw new PeopleException("Gold amount is equal or less than 0");
    }

    private void goldDifferenceCheck(int goldNum) throws PeopleException {
        if (gold-goldNum < 0) throw new PeopleException("Gold is not enough");
    }

    private void itemCheck(Item item) throws ItemException {
        if (item == null) throw new ItemException("Item is null");
    }

    public int getVitality() {
        return vitality;
    }

    public int getStrength() {
        return strength;
    }

    public int getEndurance() {
        return endurance;
    }

    public int getDexterity() {
        return dexterity;
    }

    public int getGold() {
        return gold;
    }

    public void addGold(int goldNum) throws PeopleException {
        goldCheck(goldNum);
        gold += goldNum;
    }

    public void takeGold(int goldNum) throws PeopleException {
        goldCheck(goldNum);
        goldDifferenceCheck(goldNum);
        gold -= goldNum;
    }

    public void increaseVitality() throws PeopleException {
        characteristicCheck(vitality);
        vitality += 1;
    }

    public void increaseStrength() throws PeopleException {
        characteristicCheck(strength);
        strength += 1;
    }

    public void increaseEndurance() throws PeopleException {
        characteristicCheck(endurance);
        endurance += 1;
    }

    public void increaseDexterity() throws PeopleException {
        characteristicCheck(dexterity);
        dexterity += 1;
    }

    public int getWeightLoad() {
        return BASE_WEIGHT_LOAD + endurance;
    }

    public Ammunition getAllAmmunitionCopy() throws CloneNotSupportedException {
        return ammunition.clone();
    }

    public void dressAmmunition(Item item) throws CloneNotSupportedException, ItemException, PeopleException {
        itemCheck(item);
        if (getWeightLoad() <= ammunition.ammunitionWeight()+item.getWeight()) throw new PeopleException("You can't dress this item. Weight is exceeded");
        else ammunition.dressItem(item);
    }

    public void removeAmmunition(Item item) throws ItemException {
        itemCheck(item);
        ammunition.removeItem(item);
    }

    public int getAmmunitionWeight() {
        return ammunition.ammunitionWeight();
    }

    public int getAmmunitionPrice() {
        return ammunition.ammunitionPrice();
    }

    public void sortAmmunitionByWeight(boolean isAsc) {
        ammunition.sortByWeight(isAsc);
    }

    public void sortAmmunitionByPrice(boolean isAsc) {
        ammunition.sortByPrice(isAsc);
    }

    public Ammunition getAmmunitionPriceFromTo(int from, int to) throws CloneNotSupportedException, ItemException {
        return ammunition.getPriceFromTo(from,to);
    }

    public Ammunition getAmmunitionWeightFromTo(int from, int to) throws CloneNotSupportedException, ItemException {
        return ammunition.getWeightFromTo(from, to);
    }

    public String toString() {
        return "Knight: "+name+"\n"+
                "Age: "+age+", gender: "+gender+"\n"+
                "Characteristics: vitality "+vitality+", strength "+strength+", endurance "+endurance+", dexterity "+dexterity+"\n"+
                ammunition.toString()
                ;
    }

}
