package com.company.Models;

import java.util.Date;

//subclass of class Client
public class ClientVIP extends Client {

    //constructor calls super-class constructor directly
    public ClientVIP(String name, Date date, boolean isMale) {
        super(name, date, isMale);
    }
}
