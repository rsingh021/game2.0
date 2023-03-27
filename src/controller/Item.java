package controller;

public class Item {
    private int itemID;
    private String name;
    private String description;


    public Item(int itemID, String name, String description) {
        this.itemID = itemID;
        this.name = name;
        this.description = description;

    }

    //getter methods set

    public int getItemID() {
        return itemID;
    }

    public void setItemID(int itemID) {
        this.itemID = itemID;
    }

    public String getName()	{
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDescription()	{
        return description;
    }


    @Override
    public String toString() {
        return "Item{" +
                "itemID=" + itemID +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                '}';
    }
}