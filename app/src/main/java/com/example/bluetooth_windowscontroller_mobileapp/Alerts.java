package com.example.bluetooth_windowscontroller_mobileapp;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;

import java.util.HashMap;
import java.util.Map;

public class Alerts {
    private Context context;
    ApiRequest req = new ApiRequest();

    public Alerts(Context context){
        context = context;
    }

    public void ShowDialog(Context context, String title, String message, String apiName, View view){
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        dialog.setMessage(message);
        dialog.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                req.PostRequest(context, apiName,null, view);
            }
        }).create();
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        }).create();
        dialog.show();
    }

    public void ShowDialogWithInputField(Context context, String title, String apiName, View view){
        Map< String,String> hm = new HashMap< String,String>();
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        final EditText value = new EditText(context);
        value.setHint("Please enter value");
        dialog.setView(value);
        dialog.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                hm.put("value",value.getText().toString());
                req.PostRequest(context, apiName, hm, view);
            }
        }).create();
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        }).create();
        dialog.show();
    }

    public void ShowDialogWithTwoInputFields(Context context, String title, String apiName, View view){
        Map< String,String> hm = new HashMap< String,String>();
        AlertDialog.Builder dialog = new AlertDialog.Builder(context);
        dialog.setTitle(title);
        final EditText textName = new EditText(context);
        dialog.setView(textName);
        final EditText textValue = new EditText(context);
        dialog.setView(textValue);
        LinearLayout lila1 = new LinearLayout(context);
        lila1.setOrientation(LinearLayout.VERTICAL);
        textName.setHint("Please enter file name");
        textValue.setHint("Please enter text");
        lila1.addView(textName);
        lila1.addView(textValue);
        dialog.setView(lila1);
        dialog.setPositiveButton("Send", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                hm.put("textName",textName.getText().toString());
                hm.put("textValue",textValue.getText().toString());
                req.PostRequest(context, apiName, hm, view);
            }
        }).create();
        dialog.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                return;
            }
        }).create();
        dialog.show();
    }
}
