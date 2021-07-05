package com.com;

public class AppleIphone1 extends Apple {
    @Override
    public String dialUp(long phoneNumber) {
        return "Dialing up number + " + phoneNumber + "from" + this.getClass().getSimpleName();
    }

    @Override
    public String sendMessage(long phoneNumber) {
        return  "Sending message to " + phoneNumber + " from "+ this.getClass().getSimpleName();
    }

}
