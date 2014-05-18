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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ChatActivity extends Activity {
	ListView list;
	List<Message> Messsages = new ArrayList<Message>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_chat);
		helper.setActionBar(this, getString(R.string.ChatTitle), false);
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
			if (i == 1 || i == 3 || i == 5 || i == 6 || i == 8 || i == 9)
				ct.setSender("me");
			ct.setDate("May 06,2004 01:0" + i);
			ct.setContent("Lorem ipsum dollar sit amet, amet amet jabang bayi "
					+ i);
			Messsages.add(ct);
		}
		MessageAdapter adapter = new MessageAdapter(this, Messsages, true);
		list.setAdapter(adapter);
	}
}
