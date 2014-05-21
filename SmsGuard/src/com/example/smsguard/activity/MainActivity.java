package com.example.smsguard.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.smsguard.ContactAdapter;
import com.example.smsguard.MessageAdapter;
import com.example.smsguard.R;
import com.example.smsguard.helper;
import com.example.smsguard.R.id;
import com.example.smsguard.R.layout;
import com.example.smsguard.R.menu;
import com.example.smsguard.R.string;
import com.example.smsguard.model.Contact;
import com.example.smsguard.model.Message;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.AbsListView.OnScrollListener;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends BaseActivity {
	ListView list;
	List<Message> Messsages = new ArrayList<Message>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		if (helper.getSp(this).getBoolean("islogin", false)) {
			setContentView(R.layout.activity_main);
			helper.setActionBar(this, getString(R.string.MainTitle), false);
			helper.getOverflowMenu(this);
			list = (ListView) findViewById(R.id.List);
			try {

				list.setEmptyView(findViewById(R.id.ListEmpty));
				list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

					public void onItemClick(AdapterView<?> parent, View view,
							int position, long id) {
						startActivity(new Intent(MainActivity.this, ChatActivity.class));
					}
				});
				list.setOnScrollListener(new OnScrollListener() {
					
					@Override
					public void onScrollStateChanged(AbsListView view, int scrollState) {
						// TODO Auto-generated method stub
						ctReset();
					}
					
					@Override
					public void onScroll(AbsListView view, int firstVisibleItem,
							int visibleItemCount, int totalItemCount) {
						// TODO Auto-generated method stub
						
					}
				});
			} catch (Exception e) {

			}
		} else {
			startActivity(new Intent(MainActivity.this, LoginActivity.class));
			finish();
		}

	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setListAdapter();
	}

	private void setListAdapter() {
		Messsages.clear();
		for (int i = 0; i < 10; i++) {
			Message ct = new Message();
			ct.setId(i + "");
			ct.setSender("+62898765432" + i);
			ct.setDate("May 06,2004 01:0" + i);
			ct.setContent("Lorem ipsum dollar sit amet, amet amet jabang bayi "
					+ i);
			Messsages.add(ct);
		}
		MessageAdapter adapter = new MessageAdapter(this, Messsages,false);
		list.setAdapter(adapter);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.main, menu);
		return super.onCreateOptionsMenu(menu);
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		Intent i = null;
		switch (id) {
		case R.id.mn_add:
			i = new Intent(MainActivity.this, ComposeActvity.class);
			break;
		case R.id.mn_messages:
			i = new Intent(MainActivity.this, ChatActivity.class);
			break;
		case R.id.mn_contatcs:
			i = new Intent(MainActivity.this, ContactActivity.class);
			break;
		case R.id.mn_actiovation:
			i = new Intent(MainActivity.this, ActivationActivity.class);
			break;
		case R.id.mn_setting:
			i = new Intent(MainActivity.this, SettingsActivity.class);
			break;
		}
		startActivity(i);
		return super.onOptionsItemSelected(item);
	}

}
