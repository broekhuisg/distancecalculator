package nl.gavinbroekhuis.distancetracker;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView serviceStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        serviceStatus = (TextView) findViewById(R.id.txtViewServiceStatus);
    }

    public void btnStartDistanceService(View view) {
        startService(new Intent(this, DistanceCalculatorService.class));
        serviceStatus.setText("Service is running");
    }

    public void btnStopDistanceService(View view) {
        stopService(new Intent(this, DistanceCalculatorService.class));
        serviceStatus.setText("Service is stopped");
    }

    public void btnGoToMap(View view) {
//        Intent intent = new Intent(this, MapActivity.class);
//        startActivity(intent);
    }
}