package com.netomarin.demo.splashscreen;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class SplashScreenActivity extends Activity {

	Class<?> activityClass;
	Class[] paramTypes = { Integer.TYPE, Integer.TYPE };

	Method overrideAnimation = null;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		try {
			activityClass = Class.forName("android.app.Activity");
			overrideAnimation = activityClass.getDeclaredMethod(
					"overridePendingTransition", paramTypes);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(SplashScreenActivity.this,
						HomeActivity.class);
				startActivity(i);
				finish();
				if (overrideAnimation != null) {
					try {
						overrideAnimation.invoke(SplashScreenActivity.this, android.R.anim.fade_in,
								android.R.anim.fade_out);
					} catch (IllegalArgumentException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (IllegalAccessException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					} catch (InvocationTargetException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}, 2000);
	}
}