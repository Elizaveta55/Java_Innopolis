package com.company;

import java.time.LocalDate;

//class of salers, extends from abstract Human
public class Consumer extends Human {

    //saler invokes constructor of super-class and then check rather age is appropriate
    //otherwise Illegal Argument Acception is invoked in case of too small value of age
    public Consumer(String name, int age, boolean isMale) {
        super(name, age, isMale);
        if (age < 18)
            throw new IllegalArgumentException("It's not allowed for person under 18y.o. to work as a consumer");
    }

    //override method of transferring instance into string type for printing
    @Override
    public String toString() {
        return "Consumer{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }

    //method of creating order
    // Since order can be created only by saler, that method is replaced there, in Consumer class
    public void createOrder(Category category, int idInventary, int idCustomer, int amount, Shop shop) {
        Customer customer = null; //create instance of buyer, who will be found by id
        Inventory tempInventory = null; //create instance of inventory, who will be found by id
        try {
            customer = shop.getCustomers().get(idCustomer); //try to find client by id
        } catch (IndexOutOfBoundsException e) { // if id of client is not exist in list then
            throw new IllegalArgumentException("Number of client is not valid"); // message about invalid value will be thrown
        }
        for (Stock stock : shop.getStocks()) {
            if (stock.getCategory().equals(category)) {
                try {
                    tempInventory = stock.findById(idInventary); //try to find inventory by id
                } catch (IndexOutOfBoundsException e) {// if id of inventory is not exist in list then
                    throw new IllegalArgumentException("Number of inventory is not valid"); // message about invalid value will be thrown
                }
            }
        }
        if (category.equals(Category.FOOD) || category.equals(Category.PHARMACY)) { //check condition of expiration date
            if (tempInventory instanceof InventoryExpirationDate) { //if inventary contains field 'ExpirationDate'
                InventoryExpirationDate temp = (InventoryExpirationDate) tempInventory; //then we use downcast
                if (temp.getExpirationDate().isBefore(LocalDate.now())) //and check rather inventory hits its expiration date
                    throw new IllegalArgumentException("Inventory hits its expiration date");
            }
        }
        shop.removeInventary(tempInventory, category, amount); // firstly, removing method is invoked to be sure amount is appropriate
        // or otherwise there is exception should be thrown
        //to stop operation of adding order (like transaction behavior)
        shop.addOrder(new Order(tempInventory, this, customer, tempInventory.getPrice() * amount, amount)); //adding new order

    }
}
