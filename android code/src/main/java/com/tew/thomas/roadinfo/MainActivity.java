package com.tew.thomas.roadinfo;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.Scanner;
import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    URL roadInfo;
    BufferedReader in;
    ArrayList<Road> roads = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button refreshBtn = (Button) findViewById(R.id.refreshBtn);
        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                GetInfo info = new GetInfo();
                info.execute("");

                while (!info.getIsFinished()) {}
                System.out.println("Info get finshed");
                roads = info.getRoads();
                TextView lowerLcc = (TextView) findViewById(R.id.lccMouth);
                TextView upperLcc = (TextView) findViewById(R.id.upperLCC);
                lowerLcc.setText(roads.get(0).toString());
                upperLcc.setText(roads.get(1).toString());

            }
        });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
