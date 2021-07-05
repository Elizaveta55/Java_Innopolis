package com.company.Models;

import java.util.Date;

//Subclass of class Client
public class ClientRegular extends Client {

    //constructor calls super-class constructor directly
    public ClientRegular(String name, Date date, boolean isMale) {
        super(name, date, isMale);
    }
}
