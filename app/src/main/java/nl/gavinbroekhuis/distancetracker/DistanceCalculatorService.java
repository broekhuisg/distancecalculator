package nl.gavinbroekhuis.distancetracker;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;

import androidx.annotation.Nullable;

public class DistanceCalculatorService extends Service {

    private static final String TAG = "DCService";
    public boolean isRunning = false;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    // A normal service (instead of the JobIntentService) starts...
    // in the same thread, so create a seperate before
    public DistanceCalculatorService() {

    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    isRunning = true;
                    while(isRunning) {
                        Log.d(TAG, "Service is running...");
                        Thread.sleep(1000);
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
        return START_STICKY;
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        isRunning = false;
        Log.d(TAG, "stopped");
    }
}
