import courses.task1.items.ItemException;
import courses.task1.items.concrete.*;
import courses.task1.items.types.*;
import courses.task1.workshop.Smithy;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SmithyTest {

    private Smithy testSmithy;

    @Before
    public void initSmithy() throws ItemException {
        testSmithy = new Smithy();
    }

    @Test(expected = ItemException.class)
    public void createArmor_nameIsNull_throwItemException() throws ItemException {
        testSmithy.createItem(ArmorTypes.CHAIN_ARMOR, null, 1, 1, 1);
    }

    @Test(expected = ItemException.class)
    public void createArmor_nameIsEmpty_throwItemException() throws ItemException {
        testSmithy.createItem(ArmorTypes.CHAIN_ARMOR, "", 1, 1, 1);
    }

    @Test(expected = ItemException.class)
    public void createArmor_priceIsNegative_throwItemException() throws ItemException {
        testSmithy.createItem(ArmorTypes.CHAIN_ARMOR, "testArmor", -1, 1, 1);
    }

    @Test(expected = ItemException.class)
    public void createArmor_weightIsNegative_throwItemException() throws ItemException {
        testSmithy.createItem(ArmorTypes.CHAIN_ARMOR, "testArmor", 1, -1, 1);
    }

    @Test(expected = ItemException.class)
    public void createArmor_protectionIsNegative_throwItemException() throws ItemException {
        testSmithy.createItem(ArmorTypes.CHAIN_ARMOR, "testArmor", 1, 1, -1);
    }

    @Test(expected = ItemException.class)
    public void createSword_nameIsNull_throwItemException() throws ItemException {
        testSmithy.createItem(SwordTypes.LONGSWORD, null, 1, 1, 1);
    }

    @Test(expected = ItemException.class)
    public void createSword_nameIsEmpty_throwItemException() throws ItemException {
        testSmithy.createItem(SwordTypes.LONGSWORD, "", 1, 1, 1);
    }

    @Test(expected = ItemException.class)
    public void createSword_priceIsNegative_throwItemException() throws ItemException {
        testSmithy.createItem(SwordTypes.LONGSWORD, "testSword", -1, 1, 1);
    }

    @Test(expected = ItemException.class)
    public void createSword_weightIsNegative_throwItemException() throws ItemException {
        testSmithy.createItem(SwordTypes.LONGSWORD, "testSword", 1, -1, 1);
    }

    @Test(expected = ItemException.class)
    public void createSword_damageIsNegative_throwItemException() throws ItemException {
        testSmithy.createItem(SwordTypes.LONGSWORD, "testSword", 1, 1, -1);
    }

    @Test
    public void createHelmet_typeIsArmet() throws ItemException {
        HelmetTypes expected = HelmetTypes.ARMET;
        Helmet testHelmet = (Helmet) testSmithy.createItem(HelmetTypes.ARMET, "testSword", 1, 1, 1);
        HelmetTypes actual = testHelmet.getHelmetType();
        assertEquals(expected, actual);
    }

    @Test
    public void createGloves_nameIsNewGloves() throws ItemException {
        String expected = "NewGloves";
        Gloves testGloves = (Gloves) testSmithy.createItem(GlovesTypes.CHAIN_GLOVES, "NewGloves", 1, 1, 1);
        String actual = testGloves.getName();
        assertEquals(expected,actual);
    }

    @Test
    public void createBoots_priceIs10() throws ItemException {
        int expected = 10;
        Boots testBoots = (Boots) testSmithy.createItem(BootsTypes.METAL_BOOTS, "testBoots", 10, 1, 1);
        int actual = testBoots.getPrice();
        assertEquals(expected,actual);
    }

    @Test
    public void createShield_weightIs5() throws ItemException {
        int expected = 5;
        Shield testBoots = (Shield) testSmithy.createItem(ShieldTypes.TOWER_SHIELD, "testShield", 1, 5, 1);
        int actual = testBoots.getWeight();
        assertEquals(expected,actual);
    }

    @Test
    public void createSword_damageIs50() throws ItemException {
        int expected = 50;
        Sword testSword = (Sword) testSmithy.createItem(SwordTypes.LONGSWORD, "testSword", 1, 1, 50);
        int actual = testSword.getDamage();
        assertEquals(expected,actual);
    }

}