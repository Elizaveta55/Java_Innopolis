package com.company;

//class of buyer, child of 'Human' class
public class Customer extends Human {

    //no additional condition to check therefore constructor of super-class is invoked
    public Customer(String name, int age, boolean isMale) {
        super(name, age, isMale);
    }

    //override method of transferring instance into string type for printing
    @Override
    public String toString() {
        return "Customer{" +
                "Name='" + Name + '\'' +
                ", age=" + age +
                ", isMale=" + isMale +
                '}';
    }
}
