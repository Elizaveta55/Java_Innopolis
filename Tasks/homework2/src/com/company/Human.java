package com.company;

// abstract declaration of human with typical fields for every human
public abstract class Human {
    //protected tipe is implied to give access to child classes
    protected String Name;
    protected int age;
    protected boolean isMale;

    //constructors with checking of all given condition of human
    public Human(String name, int age, boolean isMale) {
        if (name.equals("")) throw new IllegalArgumentException("No correct value of name");
        if (age < 0 || age > 190) throw new IllegalArgumentException("No correct value of age");
        Name = name;
        this.age = age;
        this.isMale = isMale;
    }
}
