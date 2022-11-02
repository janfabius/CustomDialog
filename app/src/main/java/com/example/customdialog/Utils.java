package com.example.customdialog;

import android.content.Context;
import android.content.DialogInterface;

import androidx.appcompat.app.AlertDialog;

public class Utils {


    public static final int BTN_POS = 0;

    static public void alertDlg(Context context, String title, String msg, String btnPos, String btnNeutral, String btnNeg, DialogInterface.OnClickListener ocListener) {
        AlertDialog.Builder db = new AlertDialog.Builder(context);
        db.setTitle(title);
        db.setMessage(msg);
        if (btnPos != null) db.setPositiveButton(btnPos, ocListener);
        if (btnNeutral != null) db.setNeutralButton(btnNeutral, ocListener);
        if (btnNeg != null) db.setNegativeButton(btnNeg, ocListener);
        db.setIcon(android.R.drawable.ic_dialog_alert);
        db.show();
    }




}
