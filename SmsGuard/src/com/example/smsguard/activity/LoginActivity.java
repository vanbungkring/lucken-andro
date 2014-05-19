package com.example.smsguard.activity;
 
import com.example.smsguard.R;
import com.example.smsguard.helper;
import com.example.smsguard.R.id;
import com.example.smsguard.R.layout;
import com.example.smsguard.R.string;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences.Editor;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class LoginActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		helper.setActionBar(this, getString(R.string.LoginTitle), false);
		((Button) findViewById(R.id.BtLoginSignin))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						if (((Button) findViewById(R.id.BtLoginSignin))
								.getText().toString().length() > 0) {
							Editor edit = helper.getSp(LoginActivity.this).edit();
							edit.putBoolean("islogin", true);
							edit.commit();
							startActivity(new Intent(LoginActivity.this,
									MainActivity.class));
							finish();
						}
					}
				});
	}
}
