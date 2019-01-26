package com.example.firstaid;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

public class Tips extends AppCompatActivity {

    Button bt1, bt2;
    String items[] = new String[]{"Bleeding", "Heart Attack", "poisoning", "Heat Stroke", "Cut and wounds", "Sprain", "Shock", "Un-Consious", "Sun Burn"};

    ArrayAdapter<String> mArrayAdapter;


    private ProgressBar mProgressBar;

    private int mProgressStatus = 0;

    private Handler mHandler = new Handler();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tips);

        bt1 = (Button) findViewById(R.id.tips);
        bt2 = (Button) findViewById(R.id.hospital);
        mProgressBar = (ProgressBar) findViewById(R.id.progressbar);


        bt1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(Tips.this, Tips.class));
                overridePendingTransition(0, 0);

            }
        });

        bt2.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                startActivity(new Intent(Tips.this, MapsActivity.class));
                overridePendingTransition(0, 0);

            }
        });



        final ListView listView = (ListView) findViewById(R.id.listView);
        mArrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(mArrayAdapter);
        //listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()    {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {
                if (position == 0) {
                    Intent myIntent = new Intent(view.getContext(), Bleeding.class);
                    startActivityForResult(myIntent, 0);
                }

                if (position == 1) {
                    Intent myIntent = new Intent(view.getContext(), Attack.class);
                    startActivityForResult(myIntent, 0);
                }
//
//                if (position == 2) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity1.class);
//                    startActivityForResult(myIntent, 0);
//                }
//
                if (position == 3) {
                    Intent myIntent = new Intent(view.getContext(), HeatStroke.class);
                    startActivityForResult(myIntent, 0);
                }
//
                if (position == 4) {
                    Intent myIntent = new Intent(view.getContext(), Wound.class);
                    startActivityForResult(myIntent, 0);
                }
//
                if (position == 5) {
                    Intent myIntent = new Intent(view.getContext(), Sprain.class);
                    startActivityForResult(myIntent, 0);
                }
//
                if (position == 6) {
                    Intent myIntent = new Intent(view.getContext(), Unconsious.class);
                    startActivityForResult(myIntent, 0);
                }
//
//                if (position == 7) {
//                    Intent myIntent = new Intent(view.getContext(), ListItemActivity2.class);
//                    startActivityForResult(myIntent, 0);
//                }


                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position);

                // Show Alert

                Toast.makeText(Tips.this,  itemValue, Toast.LENGTH_LONG).show();

            }

        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                while (mProgressStatus < 100){
                    mProgressStatus++;
                    android.os.SystemClock.sleep(50);
                    mHandler.post(new Runnable() {
                        @Override
                        public void run() {
                            mProgressBar.setProgress(mProgressStatus);
                        }
                    });
                }
            }
        }).start();

    }
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(
                Tips.this);

        // set title
        alertDialogBuilder.setTitle("Exit");

        // set dialog message
        alertDialogBuilder
                .setMessage("Do you really want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, close
                        // current activity
                        Tips.this.finish();
                    }
                })
                .setNegativeButton("No",new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog,int id) {
                        // if this button is clicked, just close
                        // the dialog box and do nothing
                        dialog.cancel();
                    }
                });

        // create alert dialog
        AlertDialog alertDialog = alertDialogBuilder.create();

        // show it
        alertDialog.show();
    }

}
