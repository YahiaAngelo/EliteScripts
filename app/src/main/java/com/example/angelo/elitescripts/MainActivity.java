package com.example.angelo.elitescripts;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jaredrummler.android.shell.CommandResult;
import com.jaredrummler.android.shell.Shell;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {


    public MainActivity activity;

    public static Context contextOfApplication;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);

        this.activity = activity;
        contextOfApplication = getApplicationContext();

        try {
            Runtime.getRuntime().exec("su");
        } catch (IOException e) {
        }

        final Button chButton = (Button) findViewById(R.id.chbutton);

        chButton.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
            ch();
            }
        });

        Button slkButton = (Button) findViewById(R.id.slkbutton);

        slkButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                slk();
            }
        });

        Button uButton = (Button) findViewById(R.id.ubutton);

        uButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                u();
            }
        });

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, InfoActivity.class);
                startActivity(intent);
            }
        });

    }

    public void ch(){
        CommandResult result = Shell.SU.run("sh ./system/refined/ch.sh");
        if (result.isSuccessful()){
            Log.v("EliteScripts", "ch script is working!");
            SharedPreferences sharedPref = PreferenceManager
                    .getDefaultSharedPreferences(getContextOfApplication());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("isChWorking", true);
            editor.putBoolean("isSlkWorking", false);
            editor.putBoolean("isUWorking", false);
            editor.apply();
            Toast.makeText(this, R.string.chWorkedToast,
                    Toast.LENGTH_LONG).show();
        }else{
            Log.v("EliteScripts", "Oops, ch script is not working");
            SharedPreferences sharedPref = PreferenceManager
                    .getDefaultSharedPreferences(getContextOfApplication());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("isChWorking", false);
            editor.apply();
            Toast.makeText(this, R.string.failedToast,
                    Toast.LENGTH_LONG).show();
        }
    }

    public void slk(){
        CommandResult result = Shell.SU.run("sh ./system/refined/slk.sh");
        if (result.isSuccessful()){
            Log.v("EliteScripts", "slk script is working!");
            SharedPreferences sharedPref = PreferenceManager
                    .getDefaultSharedPreferences(getContextOfApplication());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("isChWorking", false);
            editor.putBoolean("isSlkWorking", true);
            editor.putBoolean("isUWorking", false);
            editor.apply();
            Toast.makeText(this, R.string.slkWorkedToast,
                    Toast.LENGTH_LONG).show();
        }else{
            Log.v("EliteScripts", "Oops, slk scripts is not working");
            SharedPreferences sharedPref = PreferenceManager
                    .getDefaultSharedPreferences(getContextOfApplication());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("isSlkWorking", false);
            editor.apply();
            Toast.makeText(this, R.string.failedToast,
                    Toast.LENGTH_LONG).show();

        }
    }

    public void u() {
        CommandResult result = Shell.SU.run("sh ./system/refined/u.sh");
        if (result.isSuccessful()){
            Log.v("EliteScripts", "u script is working!");
            SharedPreferences sharedPref = PreferenceManager
                    .getDefaultSharedPreferences(getContextOfApplication());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("isChWorking", false);
            editor.putBoolean("isSlkWorking", false);
            editor.putBoolean("isUWorking", true);
            editor.apply();
            Toast.makeText(this, R.string.uWorkedToast,
                    Toast.LENGTH_LONG).show();
        }else{
            Log.v("EliteScripts", "Oops, u script is not working");
            SharedPreferences sharedPref = PreferenceManager
                    .getDefaultSharedPreferences(getContextOfApplication());
            SharedPreferences.Editor editor = sharedPref.edit();
            editor.putBoolean("isUWorking", false);
            editor.apply();
            Toast.makeText(this, R.string.failedToast,
                    Toast.LENGTH_LONG).show();

        }

    }

    public static Context getContextOfApplication(){
        return contextOfApplication;
    }
}
