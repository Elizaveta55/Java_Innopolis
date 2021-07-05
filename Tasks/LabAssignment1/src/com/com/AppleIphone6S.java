package com.com;

public class AppleIphone6S extends Apple {
    @Override
    public String dialUp(long phoneNumber) {
        return "Dialing up number + " + phoneNumber + "from" + this.getClass().getSimpleName();
    }

    @Override
    public String sendMessage(long phoneNumber) {
        return  "Sending message to " + phoneNumber + " from "+ this.getClass().getSimpleName();
    }

    @Override
    public String takePhoto() {
        return "Take a photo from "+ this.getClass().getSimpleName();
    }

    @Override
    public String payByApplePay() {
        return  "Paying by Apple Pay from "+ this.getClass().getSimpleName();
    }

    @Override
    public String payByGooglePay() {
        return  "Paying by Google Pay from "+ this.getClass().getSimpleName();
    }
}
