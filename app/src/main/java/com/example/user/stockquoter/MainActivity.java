package com.example.user.stockquoter;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.List;

import static com.example.user.stockquoter.R.id.ListView1;
import static com.example.user.stockquoter.R.layout.listview;

public class MainActivity extends AppCompatActivity {
    private Handler mHandler = new Handler();
    private static final String TAG = YahooConnector.class.getSimpleName();
    private boolean noData = true;
    String[] myString = {
            "AAL",
            "AAPL",
            "ADBE",
            "ADI",
            "ADP",
            "ADSK",
            "AKAM",
            "ALXN",
            "AMAT",
            "AMGN",
            "AMZN",
            "ATVI",
            "AVGO",
            "BBBY",
            "BIDU",
            "BIIB",
            "BMRN",
            "CA",
            "CELG,",
            "CERN",
            "CHKP",
            "CHTR",
            "CMCSA",
            "COST",
            "CSCO",
            "CSX",
            "CTRP",
            "CTSH",
            "CTXS",
            "DISCA",
            "DISCK",
            "DISH",
            "DLTR",
            "EA",
            "EBAY",
            "ESRX",
            "EXPE",
            "FAST",
            "FB",
            "FISV",
            "FOX",
            "FOXA",
            "GILD",
            "GOOG",
            "GOOGL",
            "HSIC",
            "ILMN",
            "INCY",
            "INTC",
            "INTU",

    };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StringBuilder stringBuilder = new StringBuilder();
        int n = 0;
        for(String s : myString){
            stringBuilder.append(myString[n] + "+");
            n++;
        }
        String requestString = stringBuilder.toString();
        final ListView listView1 = (ListView) findViewById(ListView1);
                YahooConnector myConnection = new YahooConnector(requestString);
                String testString;
                myConnection.ConnectionCreate();
                List<StockModel> mModelList = myConnection.stockModelList;
                while (noData) {
                    if (myConnection.dataRetrieved == false) {
                        mModelList = myConnection.stockModelList;
                    } else {
                        noData = false;
                    }
                }
                ArrayAdapter<StockModel> adapter = new ArrayAdapter<StockModel>(this, listview, mModelList);
                listView1.setAdapter(adapter);
        listView1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView parent, View v, int position, long id){
                Intent myIntent = new Intent(MainActivity.this, moreStockInfoIntent.class);
                myIntent.putExtra("tickerSymbol", getPositionToString(position));
                startActivity(myIntent);
            }
        });
    }
    private String getPositionToString(int position){
        String tickerSymbol = myString[position];
        return tickerSymbol;
    }
}
