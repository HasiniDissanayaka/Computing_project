package com.example.computingproject.UniqueUserHelperClass;

public class Pay {

    String amount,card,expire,cvc;

    public Pay(){

    }

    public Pay(String amount, String card, String expire, String cvc) {
        this.amount = amount;
        this.card = card;
        this.expire = expire;
        this.cvc = cvc;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public String getcard() {
        return card;
    }

    public void setcard(String card) {
        this.card = card;
    }

    public String getExpire() {
        return expire;
    }

    public void setExpire(String expire) {
        this.expire = expire;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }
}
