package com.com;

public class HuawaiY5 extends MobileHuawai{
    @Override
    public String dialUp(long phoneNumber) {
        return "Dialing up number + " + phoneNumber + "from" + this.getClass().getSimpleName();
    }

    @Override
    public String sendMessage(long phoneNumber) {
        return  "Sending message to " + phoneNumber + " from "+ this.getClass().getSimpleName();
    }


}
