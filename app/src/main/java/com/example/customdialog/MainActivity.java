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


public class MainActivity extends AppCompatActivity {


    Context mContext = this;

   // private Dialog dialog;
    private Button ShowDialog;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        ShowDialog = findViewById(R.id.dialog_btn);

        ShowDialog.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

//                boolean ricevi;
//                ricevi = showCustomDialog(mContext, "Cancella", "OK",
//                        getDrawable(R.color.colorPrimaryDark1),
//                        getDrawable(R.drawable.ic_baseline_done_outline_24),
//                        "Success",
//                        "messaggio da scrivere qui bla bla,b,,ikffnnf\nriga a capo.\nciao?");
//
//                Log.i("FAB0211","ricevi->" + ricevi);
//
//                if(ricevi){
//                    Toast.makeText(getApplicationContext(),"eseguo risposta ok",Toast.LENGTH_SHORT).show();
//                }else{
//                    Toast.makeText(mContext,"eseguo risposta cancella",Toast.LENGTH_SHORT).show();
//                }


//                Utils.alertDlg(mContext, "Confirm", "Delete the file?", "Yes", null, "Cancel",
//                        (DialogInterface dialog, int which) -> {
//                            if(which == Utils.BTN_POS)
//                                Toast.makeText(getApplicationContext(),"eseguo risposta ok",Toast.LENGTH_SHORT).show();
//                        });
//

                CustomDialog customDialog = new CustomDialog(MainActivity.this, "Cancella", "OK",
                        getDrawable(R.color.colorPrimaryDark1),
                        getDrawable(R.drawable.ic_baseline_done_outline_24),
                        "Success",
                        "messaggio da scrivere qui bla bla,b,,ikffnnf\nriga a capo.\nciao?");
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    customDialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
                }
                customDialog.show();


                Log.i("FAB0211","getRisposta->" + customDialog.getRisposta());

                if(customDialog.getRisposta()){
                    Toast.makeText(getApplicationContext(),"eseguo risposta ok",Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(mContext,"eseguo risposta cancella",Toast.LENGTH_SHORT).show();
                }


            }//onClick


        });






    }



    boolean RISPOSTA;
    private boolean showCustomDialog(Context mContext, String textButtonSx, String textButtonDx, Drawable background, Drawable icona, String titolo, String messaggio) {

        Dialog dialog;

        //Create the Dialog here
        dialog = new Dialog(mContext);
        dialog.setContentView(R.layout.custom_dialog_layout);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            dialog.getWindow().setBackgroundDrawable(getDrawable(R.drawable.custom_dialog_background));
        }
        dialog.getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        dialog.setCancelable(false); //Optional
        dialog.getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog

        Button Okay = dialog.findViewById(R.id.btn_okay);
        Button Cancel = dialog.findViewById(R.id.btn_cancel);
        TextView t_titolo = dialog.findViewById(R.id.txt_titolo);
        TextView t_messaggio = dialog.findViewById(R.id.txt_messaggio);
        ImageView icon = dialog.findViewById(R.id.img_icon);

        Cancel.setText(textButtonSx);
        Okay.setText(textButtonDx);
        t_titolo.setText(titolo);
        t_messaggio.setText(messaggio);
        icon.setBackground(background);
        icon.setImageDrawable(icona);

        dialog.show();

        Okay.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                dialog.dismiss();
                RISPOSTA = true;
            }




        });

        Cancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dialog.dismiss();
                RISPOSTA = false;
            }


        });



        return RISPOSTA;

    }




}