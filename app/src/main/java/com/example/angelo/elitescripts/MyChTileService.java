package com.example.angelo.elitescripts;

import android.service.quicksettings.Tile;
import android.service.quicksettings.TileService;

public class MyChTileService extends TileService {


    MainActivity mainActivity = new MainActivity();
    @Override
    public void onClick() {
        super.onClick();
        mainActivity.ch();

        if (mainActivity.isChWorking){
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
        if (mainActivity.isChWorking){
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
       if (mainActivity.isChWorking){
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
