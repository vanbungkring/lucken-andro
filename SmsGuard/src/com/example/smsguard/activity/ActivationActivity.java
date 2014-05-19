package com.example.smsguard.activity;

import com.example.smsguard.R;
import com.example.smsguard.helper;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class ActivationActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_activation);
		helper.setActionBar(this, getString(R.string.ActivationTitle), true);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		finish();
		return super.onMenuItemSelected(featureId, item);
	}
}
