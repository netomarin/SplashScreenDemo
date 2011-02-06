package com.netomarin.demo.splashscreen;

import java.util.Timer;
import java.util.TimerTask;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class SplashScreenActivity extends Activity {
	
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        TimerTask timerTask = new TimerTask() {
			@Override
			public void run() {
				//Iniciando outra Activity
				Intent i = new Intent();
				i.setClassName("com.netomarin.demo.splashscreen", "com.netomarin.demo.splashscreen.HomeActivity");
				startActivity(i);
			}
		};
		
		Timer timer = new Timer();
		timer.schedule(timerTask, 2000);
    }
}