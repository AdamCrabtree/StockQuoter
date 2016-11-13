package com.example.user.stockquoter;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * Created by User on 10/9/2016.
 */

public class YahooConnector2 {
    String request;
    StockModel2 myModel = new StockModel2();
    boolean dataRetrieved = false;
    YahooConnector2(String request) {
        this.request = request;
    }

    void ConnectionCreate() {
        String yahooFinanceURL = "http://finance.yahoo.com/d/quotes.csv?s=" + request + "&f=nsabhgkj";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(yahooFinanceURL).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                String output;
                int n = 0;
                InputStream in = response.body().byteStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                while((output = reader.readLine()) != null){
                    String[] temp =  output.split(",");
                    while(n <= 8){
                        if(n==0)
                            myModel.setName(temp[n]);
                        if(n==1)
                            myModel.setTickerSymbol(temp[n]);
                        if(n==2) {
                            myModel.setAskPrice(temp[n]);
                        }
                        if(n==3){
                            myModel.setBidPrice(temp[n]);
                        }
                        if(n==4){
                            myModel.setDaysHigh(temp[n]);
                        }
                        if(n==5){
                            myModel.setDaysLow(temp[n]);
                        }
                        if(n==6){
                            myModel.setFiftyTwoWeekHigh(temp[n]);
                        }
                        if(n==7){
                            myModel.setFiftyTwoWeekLow(temp[n]);
                        }
                        n++;
                    }
                    n = 0;
                }
                dataRetrieved = true;
            }
        });
    }
}