package com.company;

import java.util.ArrayList;

// class representing stock entity
// which implements typical Stock Operations
public class Stock implements StockOperations {
    private Category category;
    private ArrayList<Pair<Inventory, Integer>> inventories; // list of pairs Inventory - Integer (generic is used as a demand of diamond operator <L,R>, that type argument can not be primitive)

    //constructor with initialization
    public Stock(Category category) {
        this.category = category;
        inventories = new ArrayList<>();
    }

    //area of necessary getters
    public Category getCategory() {
        return category;
    }

    //method to add new inventory with its amount in field inventories
    @Override
    public void addInventary(Inventory inventory, Integer integer) {
        if (integer == null && integer < 0)
            throw new IllegalArgumentException("No correct value of amount"); //checking of correct value of amount: it should not be null, it shpold be positive
        this.inventories.add(new Pair<>(inventory, integer));
    }

    //method to decrement the inventory by some amount or remove it
    @Override
    public void deleteInventary(Inventory inventory, Integer integer) {
        if (integer == null || integer < 0)
            throw new IllegalArgumentException("No correct value of amount"); //checking of correct value of amount: it should not be null, it shpold be positive
        Pair<Inventory, Integer> currentInventary = null;
        for (Pair pair : inventories) {
            if (pair.getL().equals(inventory))
                currentInventary = pair; // search for inventory in Pair<Inventpry, Integer>
        }
        Integer currentAmount = currentInventary.getR() - integer; // operation of decremental
        if (currentAmount < 0)
            throw new IllegalArgumentException("Such amount of iventary is not available for ordering. Please, choose less items."); //condition of having enough inventory in the stock is checked
        currentInventary.setR(currentAmount); // in case of success new value of amount is set
    }

    //implementation of operation of searching by id
    @Override
    public Inventory findById(int id) {
        try {
            return inventories.get(id).getL();
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("No correct value of inventary");
        }
    }

    //override method of transferring instance into string type for printing
    @Override
    public String toString() {
        String result = "Stock{" + "category=" + category + ", inventaries:" + '\n';
        for (Pair invent : inventories) {
            result = result + "     " + invent.getL() + "; amounts: " + invent.getR() + '\n';
        }
        return result + '}';
    }


    //Multipurpose nested class for pair of two unknown type
    //needed for creation of combination Inventary and Integer
    public static class Pair<L, R> {
        private L l;
        private R r;

        public Pair(L l, R r) {
            this.l = l;
            this.r = r;
        }

        public L getL() {
            return l;
        }

        public R getR() {
            return r;
        }

        private void setR(R r) {
            this.r = r;
        }
    }

}
