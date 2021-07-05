package com.company.Models;

import java.util.Date;

//subclass of class Client
public class ClientGolden extends Client {

    //constructor calls super-class constructor directly
    public ClientGolden(String name, Date date, boolean isMale) {
        super(name, date, isMale);
    }
}
