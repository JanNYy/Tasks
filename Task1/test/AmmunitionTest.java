import courses.task1.items.Ammunition;
import courses.task1.items.ItemException;
import courses.task1.items.concrete.*;
import courses.task1.items.types.*;
import courses.task1.workshop.Smithy;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class AmmunitionTest {

    private Ammunition testAmmo;
    private Smithy testSmithy;
    private Helmet testHelmet;
    private Armor testArmor;
    private Gloves testGloves;
    private Boots testBoots;
    private Sword testSword;
    private Shield testShield;

    @Before
    public void initAmmunition() {
        testAmmo = new Ammunition();
    }

    @Test
     public void ammunitionWeight_weightOfEmptyAmmunitionIsZero() {
        int expected = 0;
        int actual = testAmmo.ammunitionWeight();
        assertEquals(expected,actual);
    }

    private void createAmmunitionItemsParamsSortedDESC() throws ItemException {
        testSmithy = new Smithy();
        testHelmet = (Helmet) testSmithy.createItem(HelmetTypes.ARMET,"testHelmet",6,6,1);
        testArmor = (Armor) testSmithy.createItem(ArmorTypes.CHAIN_ARMOR,"testArmor",5,5,1);
        testGloves = (Gloves) testSmithy.createItem(GlovesTypes.CHAIN_GLOVES,"testGloves",4,4,1);
        testBoots = (Boots) testSmithy.createItem(BootsTypes.METAL_BOOTS,"testBoots",3,3,1);
        testSword = (Sword) testSmithy.createItem(SwordTypes.LONGSWORD,"testSword",2,2,1);
        testShield = (Shield) testSmithy.createItem(ShieldTypes.ROUND_SHIELD,"testShield",1,1,1);
    }

    private void createAmmunitionItemsParamsSortedASC() throws ItemException {
        testSmithy = new Smithy();
        testHelmet = (Helmet) testSmithy.createItem(HelmetTypes.ARMET,"testHelmet",1,1,1);
        testArmor = (Armor) testSmithy.createItem(ArmorTypes.CHAIN_ARMOR,"testArmor",2,2,1);
        testGloves = (Gloves) testSmithy.createItem(GlovesTypes.CHAIN_GLOVES,"testGloves",3,3,1);
        testBoots = (Boots) testSmithy.createItem(BootsTypes.METAL_BOOTS,"testBoots",4,4,1);
        testSword = (Sword) testSmithy.createItem(SwordTypes.LONGSWORD,"testSword",5,5,1);
        testShield = (Shield) testSmithy.createItem(ShieldTypes.ROUND_SHIELD,"testShield",6,6,1);
    }

    private void dressAllAmmunition() throws CloneNotSupportedException, ItemException {
        testAmmo.dressItem(testHelmet);
        testAmmo.dressItem(testArmor);
        testAmmo.dressItem(testGloves);
        testAmmo.dressItem(testBoots);
        testAmmo.dressItem(testSword);
        testAmmo.dressItem(testShield);
    }

    @Test
    public void ammunitionWeight_weightOfFullAmmunitionIs21() throws CloneNotSupportedException, ItemException {
        int expected = 21;
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();
        int actual = testAmmo.ammunitionWeight();
        assertEquals(expected, actual);
    }

    @Test
    public void ammunitionPrice_priceOfEmptyAmmunitionIs0() throws Exception {
        int expected = 0;
        int actual = testAmmo.ammunitionPrice();
        assertEquals(expected,actual);
    }

    @Test
    public void ammunitionPrice_priceOfFullAmmunitionIs21() throws CloneNotSupportedException, ItemException {
        int expected = 21;
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();
        int actual = testAmmo.ammunitionPrice();
        assertEquals(expected,actual);
    }

    @Test(expected = ItemException.class)
    public void dressItem_ItemIsNull_throwItemException() throws Exception {
        testAmmo.dressItem(null);
    }

    @Test(expected = ItemException.class)
    public void removeItem_ItemIsNull_throwItemException() throws Exception {
        testAmmo.removeItem(null);
    }

    @Test
    public void sortByWeight_desc() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();

        Ammunition actual = new Ammunition();
        actual.dressItem(testBoots);
        actual.dressItem(testSword);
        actual.dressItem(testHelmet);
        actual.dressItem(testGloves);
        actual.dressItem(testArmor);
        actual.dressItem(testShield);

        actual.sortByWeight(false);

        assertEquals(actual, testAmmo);
    }

    @Test
    public void sortByWeight_asc() throws Exception {
        createAmmunitionItemsParamsSortedASC();
        dressAllAmmunition();

        Ammunition actual = new Ammunition();
        actual.dressItem(testBoots);
        actual.dressItem(testSword);
        actual.dressItem(testHelmet);
        actual.dressItem(testGloves);
        actual.dressItem(testArmor);
        actual.dressItem(testShield);

        actual.sortByWeight(true);

        assertEquals(actual, testAmmo);
    }

    @Test
    public void sortByPrice_desc() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();

        Ammunition actual = new Ammunition();
        //Unsorted
        actual.dressItem(testBoots);
        actual.dressItem(testSword);
        actual.dressItem(testHelmet);
        actual.dressItem(testGloves);
        actual.dressItem(testArmor);
        actual.dressItem(testShield);

        actual.sortByPrice(false);

        assertEquals(actual, testAmmo);
    }

    @Test
    public void sortByPrice_asc() throws Exception {
        createAmmunitionItemsParamsSortedASC();
        dressAllAmmunition();

        Ammunition actual = new Ammunition();
        //Unsorted
        actual.dressItem(testBoots);
        actual.dressItem(testSword);
        actual.dressItem(testHelmet);
        actual.dressItem(testGloves);
        actual.dressItem(testArmor);
        actual.dressItem(testShield);

        actual.sortByPrice(true);

        assertEquals(actual, testAmmo);
    }

    @Test
    public void getPriceFrom1To2() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();

        Ammunition expected = new Ammunition();
        expected.dressItem(testSword);
        expected.dressItem(testShield);

        Ammunition actual = testAmmo.getPriceFromTo(1, 2);

        assertEquals(actual,expected);
    }

    @Test
    public void getPriceFrom2To1() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();

        Ammunition expected = new Ammunition();
        expected.dressItem(testSword);
        expected.dressItem(testShield);

        Ammunition actual = testAmmo.getPriceFromTo(2, 1);

        assertEquals(actual,expected);
    }

    @Test(expected = ItemException.class)
    public void getPriceFromTo_withNegativeFirstParam() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();
       testAmmo.getPriceFromTo(-1, 2);
    }

    @Test(expected = ItemException.class)
    public void getPriceFromTo_withNegativeSecondParam() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();
        testAmmo.getPriceFromTo(1, -2);
    }

    @Test
    public void getWeightFrom1To2() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();

        Ammunition expected = new Ammunition();
        expected.dressItem(testSword);
        expected.dressItem(testShield);

        Ammunition actual = testAmmo.getWeightFromTo(1, 2);

        assertEquals(actual, expected);
    }

    public void getWeightFrom2To1() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();

        Ammunition expected = new Ammunition();
        expected.dressItem(testSword);
        expected.dressItem(testShield);

        Ammunition actual = testAmmo.getWeightFromTo(2, 1);

        assertEquals(actual,expected);
    }

    @Test(expected = ItemException.class)
    public void getWeightFromTo_withNegativeFirstParam() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();
        testAmmo.getWeightFromTo(-1, 2);
    }

    @Test(expected = ItemException.class)
    public void getWeightFromTo_withNegativeSecondParam() throws Exception {
        createAmmunitionItemsParamsSortedDESC();
        dressAllAmmunition();
        testAmmo.getWeightFromTo(1, -2);
    }

}