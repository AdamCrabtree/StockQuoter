package com.example.user.stockquoter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by User on 10/9/2016.
 */

public class moreStockInfoIntent extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.companyinformation);
        final TextView mNameTicker = (TextView) findViewById(R.id.nameTicker);
        final TextView mMoreInfo = (TextView) findViewById(R.id.moreInfo);
        final Button mGoBack = (Button) findViewById(R.id.button);
        super.onCreate(savedInstanceState);
        Bundle extras = getIntent().getExtras();
        StockModel2 model2;
        String requestString = extras.getString("tickerSymbol");
        YahooConnector2 myConnection = new YahooConnector2(requestString);
        myConnection.ConnectionCreate();
        while(true){
            if(myConnection.dataRetrieved){
                model2 = myConnection.myModel;
                if(myConnection.dataRetrieved){
                    break;
                }
            }
        }
        String nameAndTicker = model2.getName() + System.getProperty("line.separator") + model2.getTickerSymbol();
        String moreInfoString = "Ask Price: " + model2.getAskPrice()
                + System.getProperty("line.separator") + "Bid price: " + model2.getBidPrice()
                + System.getProperty("line.separator") + "Day's high: " + model2.getDaysHigh()
                + System.getProperty("line.separator") + "Day's low: " + model2.getDaysLow()
                + System.getProperty("line.separator") + "Fifty two week high: " + model2.getFiftyTwoWeekHigh()
                + System.getProperty("line.separator") + "Fifty two week low: " + model2.getFiftyTwoWeekLow();

        mNameTicker.setText(nameAndTicker);
        mMoreInfo.setText(moreInfoString);
        mGoBack.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent myIntent = new Intent(moreStockInfoIntent.this, MainActivity.class);
                startActivity(myIntent);
            }
        });



    }
}
