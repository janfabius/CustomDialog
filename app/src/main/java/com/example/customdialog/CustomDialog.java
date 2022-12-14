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

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.DividerItemDecoration;

public class CustomDialog extends Dialog implements android.view.View.OnClickListener {
    public Activity activity;
    public Button btnYes, btnNo;

    public String button_sx;
    public String button_dx;
    public Drawable backgr;
    public Drawable icon;
    public String title;
    public String message;
    public int model;




    public CustomDialog(Activity activity, int template,String textButtonSx, String textButtonDx, Drawable background, Drawable icona, String titolo, String messaggio) {

        super(activity);
        this.activity = activity;
        this.button_sx = textButtonSx;
        this.button_dx = textButtonDx;
        this.backgr = background;
        this.icon = icona;
        this.title = titolo;
        this.message = messaggio;
        this.model = template;

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);


        switch (model){
            case 1: setContentView(R.layout.custom_dialog_layout);
                break;
            case 2: setContentView(R.layout.custom_dialog_layout_2);
                break;
            case 3: setContentView(R.layout.custom_dialog_layout_3);
                break;
            case 4: setContentView(R.layout.custom_dialog_layout_4);
                break;
        }
        //setContentView(R.layout.custom_dialog_layout);

        getWindow().setLayout(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        setCancelable(false); //Optional
        getWindow().getAttributes().windowAnimations = R.style.DialogAnimation; //Setting the animations to dialog
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setBackgroundDrawable(getContext().getDrawable(R.drawable.custom_dialog_background));
        }

        btnYes = (Button) findViewById(R.id.btn_okay);
        btnNo = (Button) findViewById(R.id.btn_cancel);
        btnYes.setOnClickListener(this);
        btnNo.setOnClickListener(this);

        TextView t_titolo = findViewById(R.id.txt_titolo);
        TextView t_messaggio = findViewById(R.id.txt_messaggio);
        ImageView t_icon = findViewById(R.id.img_icon);
        View divisore = findViewById(R.id.divider);

        if(button_sx.equals("")) {
            btnNo.setText("");
            btnNo.setVisibility(View.INVISIBLE);

            ConstraintLayout.LayoutParams params = (ConstraintLayout.LayoutParams) divisore.getLayoutParams();
            params.horizontalBias = 0.0f; // here is one modification for example. modify anything else you want :)
            divisore.setLayoutParams(params); // request the view to use the new modified params

        }else{
            btnNo.setText(button_sx);
            btnNo.setVisibility(View.VISIBLE);
        }


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

                break;
            case R.id.btn_cancel:

                break;

            default:
                break;
        }
        dismiss();
    }





}


