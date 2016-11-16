package com.cins.floatball.service;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.cins.floatball.widget.FloatBall;

/**
 * Created by Eric on 2016/11/16.
 */

public class FlaotBallService extends Service{

    private FloatBall mFloatBall;

    @Override
    public IBinder onBind(Intent intent) {
        return new FloatBallServiceBinder();
    }

    @Override
    public void onCreate() {
        super.onCreate();
        mFloatBall = new FloatBall(this);
    }

    public void showFloat() {
        if ( mFloatBall != null ) {
            mFloatBall.show();
        }
    }

    public void hideFloat() {
        if ( mFloatBall != null ) {
            mFloatBall.hide();
        }
    }

    public void destroyFloat() {
        if ( mFloatBall != null ) {
            mFloatBall.destroy();
        }
        mFloatBall = null;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        destroyFloat();
    }

    public class FloatBallServiceBinder extends Binder {
        public FlaotBallService getService() {
            return FlaotBallService.this;
        }
    }
}
