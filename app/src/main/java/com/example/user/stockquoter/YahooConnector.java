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
import java.util.ArrayList;

/**
 * Created by Adam Crabtree on 10/7/2016.
 * Connects to yahoo and gets stock name, ask and bid price (nab) of stock
 */

public class YahooConnector {
    private static final String TAG = YahooConnector.class.getSimpleName();
    private String request;
    ArrayList<StockModel> stockModelList = new ArrayList<StockModel>();
    boolean dataRetrieved = false;
    YahooConnector(String request){
        this.request = request;
    }
    void ConnectionCreate(){
        String yahooFinanceURL = "http://finance.yahoo.com/d/quotes.csv?s=" + request + "&f=nab";
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(yahooFinanceURL).build();
        Call call = client.newCall(request);
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {

            }

            @Override
            public void onResponse(Response response) throws IOException {
                InputStream in = response.body().byteStream();
                BufferedReader reader = new BufferedReader(new InputStreamReader(in));
                String output;
                int n = 0;
                while((output = reader.readLine()) != null){
                    String[] temp =  output.split(",");
                    StockModel myModel = new StockModel();
                    while(n <= 2){
                        if(n==0)
                            myModel.setName(temp[n]);
                        if(n==1)
                            myModel.setAskPrice(temp[n]);
                        if(n==2) {
                            myModel.setBidPrice(temp[n]);
                            stockModelList.add(myModel);
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
