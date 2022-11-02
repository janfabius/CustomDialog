package com.example.customdialog;

import android.app.Activity;
import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener {
    public Activity activity;
    public Button btnYes, btnNo;

    public String button_sx;
    public String button_dx;
    public Drawable backgr;
    public Drawable icon;
    public String title;
    public String message;

    public boolean risposta;

    public boolean getRisposta() {
        return risposta;
    }

    public void setRisposta(boolean risposta) {
        this.risposta = risposta;
    }



    public CustomDialog(Activity activity, String textButtonSx, String textButtonDx, Drawable background, Drawable icona, String titolo, String messaggio) {

        super(activity);
        this.activity = activity;
            this.button_sx = textButtonSx;
            this.button_dx = textButtonDx;
            this.backgr = background;
            this.icon = icona;
            this.title = titolo;
            this.message = messaggio;

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.custom_dialog_layout);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setCancelable(false); //Optional
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        btnYes = (Button) findViewById(R.id.btn_okay);
        btnNo = (Button) findViewById(R.id.btn_cancel);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

        TextView t_titolo = findViewById(R.id.txt_titolo);
        TextView t_messaggio = findViewById(R.id.txt_messaggio);
        ImageView t_icon = findViewById(R.id.img_icon);

        btnNo.setText(button_sx);
        btnYes.setText(button_dx);
        t_titolo.setText(title);
        t_messaggio.setText(message);
        t_icon.setBackground(backgr);
        t_icon.setImageDrawable(icon);




    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_okay:
               setRisposta(true);
                break;
            case R.id.btn_cancel:
                setRisposta(false);
                break;
            default:
                break;
        }
        dismiss();
    }




}


