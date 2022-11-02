package com.example.customdialog;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity  {


    Context mContext = this;

   // private Dialog dialog;
    private Button ShowDialog1,ShowDialog2,ShowDialog3;

    private CustomDialog customDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ShowDialog1 = findViewById(R.id.dialog_btn1);
        ShowDialog2 = findViewById(R.id.dialog_btn2);
        ShowDialog3 = findViewById(R.id.dialog_btn3);

        ShowDialog1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog = new CustomDialog(MainActivity.this,
                        1,
                        "Cancella",
                        "OK",
                        getDrawable(R.color.colorPrimaryDark1),
                        getDrawable(R.drawable.ic_baseline_done_outline_24),
                        "Success",
                        "messaggio da scrivere qui bla bla,b,,ikffnnf\nriga a capo.\nciao?");
                customDialog.show();

                // gestione del Click
                customDialog.findViewById(R.id.btn_okay).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"eseguo risposta ok",Toast.LENGTH_SHORT).show();
                        customDialog.dismiss();
                    }
                });
                customDialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"eseguo risposta cancella",Toast.LENGTH_SHORT).show();
                        customDialog.dismiss();
                    }
                });

            }//onClick
        });


        ShowDialog2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog = new CustomDialog(MainActivity.this,
                        2,
                        "Cancella",
                        "OK",
                        getDrawable(R.color.colorPrimaryDark1),
                        getDrawable(R.drawable.ic_baseline_done_outline_24),
                        "Success",
                        "messaggio da scrivere qui bla bla,b,,ikffnnf\nriga a capo.\nciao?");
                customDialog.show();

                // gestione del Click
                customDialog.findViewById(R.id.btn_okay).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"eseguo risposta ok",Toast.LENGTH_SHORT).show();
                        customDialog.dismiss();
                    }
                });
                customDialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"eseguo risposta cancella",Toast.LENGTH_SHORT).show();
                        customDialog.dismiss();
                    }
                });

            }//onClick
        });


        ShowDialog3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                customDialog = new CustomDialog(MainActivity.this,
                        3,
                        "Cancella",
                        "OK",
                        getDrawable(R.color.colorPrimaryDark1),
                        getDrawable(R.drawable.ic_baseline_done_outline_24),
                        "Success",
                        "messaggio da scrivere qui bla bla,b,,ikffnnf\nriga a capo.\nciao?");
                customDialog.show();

                // gestione del Click
                customDialog.findViewById(R.id.btn_okay).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(getApplicationContext(),"eseguo risposta ok",Toast.LENGTH_SHORT).show();
                        customDialog.dismiss();
                    }
                });
                customDialog.findViewById(R.id.btn_cancel).setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(mContext,"eseguo risposta cancella",Toast.LENGTH_SHORT).show();
                        customDialog.dismiss();
                    }
                });

            }//onClick
        });










    }
}