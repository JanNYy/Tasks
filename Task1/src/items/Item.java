package courses.task1.items;

import courses.task1.items.types.Appointment;

public class Item implements Cloneable{

    protected String name;
    protected int price;
    protected int weight;
    protected Appointment applicableTo;

    public Item(String itemName, int itemPrice, int itemWeight, Appointment itemAppointment) throws ItemException {
        checkName(itemName);
        checkPrice(itemPrice);
        checkWeight(itemWeight);
        name = itemName;
        price = itemPrice;
        weight = itemWeight;
        applicableTo = itemAppointment;
    }

    private void checkName(String name) throws ItemException {
        if ((name == null)||(name.equals(""))) throw new ItemException("Name is invalid");
    }

    private void checkPrice(int price) throws ItemException {
        if (price < 0) throw new ItemException("Price is less than 0");
    }

    private void checkWeight(int weight) throws ItemException {
        if (weight < 0) throw new ItemException("Weight is less than 0");
    }

    public String getName() {
        return name;
    }

    public int getPrice() {
        return price;
    }

    public int getWeight() {
        return weight;
    }

    public Appointment getApplicableTo() {
        return applicableTo;
    }

    public void setPrice(int itemPrice) {
        price = itemPrice;
    }

    public String toString() {
        return "Item name: "+name+" (price: "+price+", weight: "+weight+")";
    }

    public Item clone() throws CloneNotSupportedException {
        return (Item) super.clone();
    }

    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof Item)) return false;
        Item item = (Item) obj;
        if (price != item.price) return false;
        if (weight != item.weight) return false;
        return name.equals(item.name);
    }

    public int hashCode() {
        int result = name.hashCode();
        result = 31 * result + price;
        result = 31 * result + weight;
        return result;
    }
}
