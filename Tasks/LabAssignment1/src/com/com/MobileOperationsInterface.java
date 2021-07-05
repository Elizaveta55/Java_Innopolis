package com.com;

public interface MobileOperationsInterface {
    String dialUp (long phoneNumber);
    String sendMessage (long phoneNumber);
    String takePhoto ();
    String payByApplePay ();
    String payByGooglePay ();
}
