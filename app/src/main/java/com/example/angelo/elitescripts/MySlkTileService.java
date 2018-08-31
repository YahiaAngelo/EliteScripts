package com.example.angelo.elitescripts;

import android.content.Context;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class MySlkTileService extends TileService {
    MainActivity mainActivity = new MainActivity();
    Context applicationContext = MainActivity.getContextOfApplication();

    SharedPreferences sharedPref = PreferenceManager
            .getDefaultSharedPreferences(applicationContext);
    boolean isSlkWorking = sharedPref.getBoolean("isSlkWorking", false);


    @Override
    public void onClick() {
        super.onClick();
        mainActivity.slk();

        if (isSlkWorking){
            getQsTile().setState(Tile.STATE_ACTIVE);
            getQsTile().updateTile();
        }else {
            getQsTile().setState(Tile.STATE_INACTIVE);
            getQsTile().updateTile();
        }
    }

    @Override
    public void onTileAdded() {
        super.onTileAdded();
        if (isSlkWorking){
            getQsTile().setState(Tile.STATE_ACTIVE);
            getQsTile().updateTile();
        }else {
            getQsTile().setState(Tile.STATE_INACTIVE);
            getQsTile().updateTile();
        }
    }

    @Override
    public void onTileRemoved() {
        super.onTileRemoved();
        getQsTile().setState(Tile.STATE_UNAVAILABLE);
        getQsTile().updateTile();
    }

    @Override
    public void onStartListening() {
        super.onStartListening();
        if (isSlkWorking){
            getQsTile().setState(Tile.STATE_ACTIVE);
            getQsTile().updateTile();
        }else {
            getQsTile().setState(Tile.STATE_INACTIVE);
            getQsTile().updateTile();
        }
    }

    @Override
    public void onStopListening() {
        super.onStopListening();

    }

    @Override
    public void onDestroy() {
        super.onDestroy();

    }
}
