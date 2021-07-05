package com.com;

import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        ArrayList<Mobile> mobiles = new ArrayList<>();
        mobiles.add(new GalaxyA3());
        mobiles.add(new GalaxyS());
        mobiles.add(new GalaxyNote());
        mobiles.add(new HuawaiY5());
        mobiles.add(new HuawaiY6());
        mobiles.add(new HuawaiY6Pro());
        mobiles.add(new AppleIphone1());
        mobiles.add(new AppleIphone5S());
        mobiles.add(new AppleIphone6S());

        for (Mobile mobile: mobiles){
            if (mobile.dialUp(34575)!=null) System.out.println(mobile.dialUp(34575));
            if (mobile.sendMessage(34575)!=null)System.out.println(mobile.sendMessage(34575));
            if (mobile.takePhoto()!=null)System.out.println(mobile.takePhoto());
            if (mobile.payByApplePay()!=null)System.out.println(mobile.payByApplePay());
            if (mobile.payByGooglePay()!=null)System.out.println(mobile.payByGooglePay());
            System.out.println();
        }
    }
}
