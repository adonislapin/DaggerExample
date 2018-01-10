package com.globant.mvpweatherapp.utils;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;

import com.globant.mvpweatherapp.R;

/**
 * Created by Adoniram on 09/06/2017.
 */

public class PopUpUtils {

    public static AlertDialog showUserMessage(Context context, String message){

        AlertDialog.Builder builder = new AlertDialog.Builder(context);
        builder.setMessage(message)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle(context.getString(R.string.alert))
                .setNeutralButton(context.getText(R.string.ok), new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        dialog.dismiss();
                    }
                });

        return  builder.create();
    }

}
