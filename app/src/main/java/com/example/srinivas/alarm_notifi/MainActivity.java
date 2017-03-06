package com.example.srinivas.alarm_notifi;

import android.app.AlarmManager;
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = (Button)findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText e1= (EditText)findViewById(R.id.editText);
                int i = Integer.parseInt(e1.getText().toString());
                Intent intent = new Intent(MainActivity.this,OurBroadcastReceiver.class);
                PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity.this,23424243, intent, 0);
                AlarmManager alarmManager = (AlarmManager)getSystemService(ALARM_SERVICE);
                alarmManager.set(AlarmManager.RTC_WAKEUP, System.currentTimeMillis()+(i*1000), pendingIntent);


                Toast.makeText(MainActivity.this, "Alarm set in" + i + "seconds", Toast.LENGTH_LONG).show();






            }
        });



    }
}
