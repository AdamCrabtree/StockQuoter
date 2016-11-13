package com.example.user.stockquoter;

/**
 * Created by User on 10/7/2016.
 */

public class StockModel {
    StockModel(){
        super();
    }

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name.replace("\"", "");
        this.name = name;
    }

    public String getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(String bidPrice) {
        this.bidPrice = bidPrice;
    }

    public String getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(String askPrice) {
        this.askPrice = askPrice;
    }

    private String  bidPrice, askPrice;
    public String toString(){
        return this.name + " Buy: " + this.askPrice + " Sell: " + this.bidPrice;
    }

}
