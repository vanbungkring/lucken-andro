package com.example.smsguard.activity;

import com.example.smsguard.R;
import com.example.smsguard.helper;
import com.example.smsguard.R.layout;
import com.example.smsguard.R.string;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;

public class ComposeActvity extends BaseActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_compose);
		helper.setActionBar(this, getString(R.string.ComposeTitle), true);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		finish();
		return super.onMenuItemSelected(featureId, item);
	}
}
