package com.example.smsguard.activity;

import java.util.ArrayList;
import java.util.List;

import com.example.smsguard.ContactAdapter;
import com.example.smsguard.R;
import com.example.smsguard.helper;
import com.example.smsguard.model.Contact;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;

public class ContactActivity extends BaseActivity {
	ListView list;
	List<Contact> Contacts = new ArrayList<Contact>();
	EditText EtSearch;
	ContactAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_contact);
		helper.setActionBar(this, getString(R.string.ContactTittle), true);
		list = (ListView) findViewById(R.id.List);
		EtSearch = (EditText) findViewById(R.id.EtContactSearch);
		try {
			EtSearch.addTextChangedListener(new TextWatcher() {

				@Override
				public void onTextChanged(CharSequence s, int start,
						int before, int count) {
					// TODO Auto-generated method stub
					setListAdapter();
					adapter.getFilter().filter(s);
				}

				@Override
				public void beforeTextChanged(CharSequence s, int start,
						int count, int after) {
					// TODO Auto-generated method stub

				}

				@Override
				public void afterTextChanged(Editable s) {
					// TODO Auto-generated method stub

				}
			});
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
		adapter = new ContactAdapter(this, Contacts);
		list.setAdapter(adapter);
	}

	@Override
	public boolean onMenuItemSelected(int featureId, MenuItem item) {
		finish();
		return super.onMenuItemSelected(featureId, item);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
		inflater.inflate(R.menu.contact, menu);
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
		case R.id.mn_contact_add:
			i = new Intent(ContactActivity.this, ContactSendActivity.class);
			break;
		 
		}
		startActivity(i);
		return super.onOptionsItemSelected(item);
	}
}
