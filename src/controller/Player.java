package controller;

import java.util.ArrayList;


public class Player {

    private int location;
    private ArrayList<Item> inventory;

    /**
     * No argument constructor
     */

    public Player() {

    }

    /**
     * Full argument constructor
     *
     * @param location
     */

    public Player(int location) {
        this.location = location;
        this.inventory = new ArrayList<Item>();
    }


    public void setInventory(ArrayList<Item> inventory) {
        this.inventory = inventory;
    }

    public void setLocation(int location) {
        this.location = location;
    }
    public ArrayList<Item> getInventory()	{
        return inventory;
    }
    public int getLocation() {
        return this.location;
    }

    public void addItem(Item it){
        this.inventory.add(it);
        System.out.println("Added: " + it.getName());
    }

    public void remove(String itemName) {
        // check each item in inventory
        for (int i = 0; i < itemName.length(); i++) {
            Item item = this.inventory.get(i);

            // find item in inventory that matches user input
            //
            if (item.getName().equalsIgnoreCase(itemName)) {


                // add item to room
                //location.addItem(item.getName(), item.getDescription());

                // remove item from inventory
                inventory.remove(i);
                //System.out.println(itemName + " has been dropped and placed in " + location.getName() + ".");
                return;
            }
        }
        System.out.println("Item not found. ");
    }

}
