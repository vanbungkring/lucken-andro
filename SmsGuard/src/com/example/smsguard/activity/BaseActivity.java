package com.example.smsguard.activity;

import java.util.Date;

import com.example.smsguard.helper;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.CountDownTimer;
import android.view.MotionEvent; 

public class BaseActivity extends Activity {
	CountDownTimer ct;
	Date dateLast;
	long locktime;

	@Override
	public boolean onTouchEvent(MotionEvent event) {
		ctReset();
		return super.onTouchEvent(event);
	}

	@Override
	protected void onResume() {
		super.onResume();

		String lastlogin = helper.getSp(this).getString("lastlogin", "");
		dateLast = helper.getDate(lastlogin);
		Date dateNow = helper.getDate(helper.getDate());
		long dateDiff = dateNow.getTime() - dateLast.getTime();
		  locktime = Long.parseLong(helper.getSp(this).getString(
				"prefAutolock", "30")) * 60000;
		if (dateDiff > locktime) 
			logout();
		 else
			ctReset();
		// lastlogin = lastlogin + " " + helper.getSp(this).getInt("iCounter",
		// 0) ;
		// Toast.makeText(this, lastlogin, Toast.LENGTH_SHORT).show();

	}

	@Override
	protected void onPause() {
		super.onPause();
		if (ct != null) {
			ct.cancel();
			dateLast = new Date();
			Editor edit = helper.getSp(this).edit();
			edit.putString("lastlogin", helper.getDate()); 
			edit.commit();
		}
	}

	void ctReset() {
		if (ct != null) {
			ct.cancel();
		}
		locktime = Long.parseLong(helper.getSp(this).getString(
				"prefAutolock", "30")) * 60000;
		ct = new CountDownTimer(locktime, 1000) {

			public void onTick(long millisUntilFinished) { 
			}

			public void onFinish() {
				logout();
			}
		};
		ct.start();
	}

	void logout(){
		Editor edit = helper.getSp(BaseActivity.this).edit();
		edit.putBoolean("islogin", false);
		edit.commit();
		startActivity(new Intent(BaseActivity.this, LoginActivity.class));
		finish();
	}
}
