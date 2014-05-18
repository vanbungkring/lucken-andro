package com.example.smsguard.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.smsguard.ContactAdapter;
import com.example.smsguard.R;
import com.example.smsguard.helper;
import com.example.smsguard.R.id;
import com.example.smsguard.R.layout;
import com.example.smsguard.R.string;
import com.example.smsguard.model.Contact;

import android.app.Activity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class ContactActivity extends Activity {
	ListView list;
	List<Contact> Contacts = new ArrayList<Contact>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		helper.setActionBar(this, getString(R.string.ContactTittle), true);
		list = (ListView) findViewById(R.id.List);
		try {

			list.setEmptyView(findViewById(R.id.ListEmpty));
			list.setOnItemClickListener(new AdapterView.OnItemClickListener() {

				public void onItemClick(AdapterView<?> parent, View view,
						int position, long id) {
					ImageView imgdel = (ImageView) view
							.findViewById(R.id.ImgContactDel);
					if (imgdel.getVisibility() == View.GONE)
						imgdel.setVisibility(View.VISIBLE);
					else
						imgdel.setVisibility(View.GONE);
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
		Contacts.clear();
		for (int i = 0; i < 10; i++) {
			Contact ct = new Contact();
			ct.setId(i + "");
			ct.setName("Contact ke " + (i + 1));
			ct.setPhone("0898765432" + i);
			Contacts.add(ct);
		}
		ContactAdapter adapter = new ContactAdapter(this, Contacts);
		list.setAdapter(adapter);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		finish();
		return super.onMenuItemSelected(featureId, item);
	}
}
