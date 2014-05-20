package com.example.smsguard.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.smsguard.MessageAdapter;
import com.example.smsguard.R;
import com.example.smsguard.helper;
import com.example.smsguard.model.Message;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

public class ChatActivity extends Activity {
	ListView list;
	List<Message> Messsages = new ArrayList<Message>();
	EditText EtMessage;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		helper.setActionBar(this, getString(R.string.ChatTitle), true);
		EtMessage = (EditText) findViewById(R.id.EtChatMessage);
		list = (ListView) findViewById(R.id.List);
		try {

			list.setEmptyView(findViewById(R.id.ListEmpty));
			list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {

				}
			});
		} catch (Exception e) {

		}
		((Button) findViewById(R.id.BtChatSend))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View v) {
						// TODO Auto-generated method stub
						Message ct = new Message();
						ct.setId(Messsages.size() + 1 + "");
						ct.setSender("me");
						ct.setDate(helper.getCurrentDate("MMM dd"));
						ct.setTime(helper.getCurrentDate("HH:mm"));
						ct.setContent(EtMessage.getText().toString());
						Messsages.add(ct);
						setListAdapter();
						EtMessage.setText("");
					}
				});

		Messsages.clear();
		for (int i = 0; i < 10; i++) {
			Message ct = new Message();
			ct.setId(i + "");
			ct.setSender("+62898765432" + i);
			if (i == 1 || i == 3 || i == 5 || i == 6 || i == 8 || i == 9)
				ct.setSender("me");
			ct.setDate("May 06");
			ct.setTime("01:0" + i);
			ct.setContent("Lorem ipsum dollar sit amet, amet amet jabang bayi "
					+ i);
			Messsages.add(ct);
		}
	}

	@Override
	protected void onResume() {
		// TODO Auto-generated method stub
		super.onResume();
		setListAdapter();
	}

	private void setListAdapter() {

		MessageAdapter adapter = new MessageAdapter(this, Messsages, true);
		list.setAdapter(adapter);

	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		finish();
		return super.onMenuItemSelected(featureId, item);
	}
}
