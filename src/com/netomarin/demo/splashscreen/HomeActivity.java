package com.netomarin.demo.splashscreen;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class HomeActivity extends Activity {

	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.home);
        Log.d(getClass().getName(), "Activity iniciada.");
    }
}