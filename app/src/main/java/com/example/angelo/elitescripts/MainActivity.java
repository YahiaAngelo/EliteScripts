package com.example.angelo.elitescripts;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.jaredrummler.android.shell.CommandResult;
import com.jaredrummler.android.shell.Shell;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    public boolean isChWorking;
    public boolean isSlkWorking;
    public boolean isUWorking;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.app_bar_main);
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
            isChWorking = true;
            isSlkWorking = false;
            isUWorking = false;
        }else{
            Log.v("EliteScripts", "Oops, ch script is not working");
            isChWorking = false;
        }
    }

    public void slk(){
        CommandResult result = Shell.SU.run("sh ./system/refined/slk.sh");
        if (result.isSuccessful()){
            Log.v("EliteScripts", "slk script is working!");
            isSlkWorking = true;
            isChWorking = false;
            isUWorking = false;
        }else{
            Log.v("EliteScripts", "Oops, slk scripts is not working");
            isSlkWorking = false;
        }
    }

    public void u() {
        CommandResult result = Shell.SU.run("sh ./system/refined/u.sh");
        if (result.isSuccessful()){
            Log.v("EliteScripts", "u script is working!");
            isUWorking = true;
            isSlkWorking = false;
            isChWorking = false;
        }else{
            Log.v("EliteScripts", "Oops, u script is not working");
            isUWorking = false;
        }

    }
}
