package com.example.smsguard.activity;
 

import com.example.smsguard.R; 

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

public class CoverActivity extends Activity {
	private static int SPLASH_TIME_OUT = 2000;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.cover);
		new Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				Intent i = new Intent(CoverActivity.this, MainActivity.class);
				startActivity(i); 
				finish();
			}
		}, SPLASH_TIME_OUT);
	}

}
