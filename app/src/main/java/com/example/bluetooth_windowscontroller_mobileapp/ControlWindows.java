package com.example.bluetooth_windowscontroller_mobileapp;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class ControlWindows extends AppCompatActivity {
    Alerts alerts = new Alerts(this);
    Button shutdownWindows, restartWindows,
            openGoogleChrome, createNotepad, scheduleShutDown, scheduleRestart, executeCommand;
    private Context context;
    View view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control_windows);
        context = this;
        shutdownWindows = (Button) findViewById(R.id.shutdownWindows);
        restartWindows = (Button) findViewById(R.id.restartWindows);
        openGoogleChrome = (Button) findViewById(R.id.openGoogleChrome);
        createNotepad = (Button) findViewById(R.id.createNotepad);
        scheduleShutDown = (Button) findViewById(R.id.scheduleShutdown);
        scheduleRestart = (Button) findViewById(R.id.scheduleRestart);
        executeCommand = (Button) findViewById(R.id.executeCommand);
        view = findViewById(R.id.linearLayout);

        shutdownWindows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerts.ShowDialog(context, "Are you sure you want to shutdown Windows?", "Shutdown windows", "shutdown", view);
            }
        });

        restartWindows.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerts.ShowDialog(context, "Are you sure you want to restart Windows?", "Restart windows", "restart", view);
            }
        });

        openGoogleChrome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerts.ShowDialog(context, "Are you sure you want to open google chrome?", "Open google chrome", "chrome", view);
            }
        });

        createNotepad.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerts.ShowDialogWithTwoInputFields(context, "Please enter the text you want to insert in the notepad", "notepad", view);
            }
        });

        scheduleShutDown.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerts.ShowDialogWithInputField(context, "Please enter the time (milliseconds) to shutdown", "scheduleShutdown", view);
            }
        });

        scheduleRestart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerts.ShowDialogWithInputField(context, "Please enter the time (milliseconds) to restart", "scheduleRestart", view);
            }
        });

        executeCommand.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                alerts.ShowDialogWithInputField(context, "Please enter the command to execute", "executeCommand", view);
            }
        });
    }
}
