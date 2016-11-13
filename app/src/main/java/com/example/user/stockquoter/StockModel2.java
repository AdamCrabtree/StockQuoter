package com.example.user.stockquoter;

/**
 * Created by User on 10/9/2016.
 */

public class StockModel2 {
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

    public String getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(String fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public String getDaysHigh() {
        return daysHigh;
    }

    public void setDaysHigh(String daysHigh) {
        this.daysHigh = daysHigh;
    }

    public String getDaysLow() {
        return daysLow;
    }

    public void setDaysLow(String daysLow) {
        this.daysLow = daysLow;
    }

    public String getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(String fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

    public String getTickerSymbol() {
        return tickerSymbol;
    }

    public void setTickerSymbol(String tickerSymbol) {
        tickerSymbol = tickerSymbol.replace("\"", "");
        this.tickerSymbol = tickerSymbol;
    }
    public String toStringTicker(){
        return this.name + " " + this.tickerSymbol;
    }


    private String name, bidPrice, askPrice, fiftyTwoWeekHigh, daysHigh, daysLow, fiftyTwoWeekLow, tickerSymbol;
}
