package com.example.smsguard.activity;

import com.example.smsguard.R;
import com.example.smsguard.helper;

import android.app.Activity;
import android.os.Bundle;

public class ContactSendActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send);
		helper.setActionBar(this, getString(R.string.SendTitle), true);
	}

}
