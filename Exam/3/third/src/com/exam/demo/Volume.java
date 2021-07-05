package com.exam.demo;

public class Volume {
    int amount;

    public void volDecr(int amount){
        if (this.amount<amount) this.amount=0; else this.amount = this.amount - amount;
        System.out.println("The volume is decresed. Volume " + this.amount);
    }

    public void volIncr(int amount){
        if (this.amount+amount>100) this.amount=100; else this.amount = this.amount + amount;
        System.out.println("The volume is incresed. Volume" + this.amount);
    }
}
