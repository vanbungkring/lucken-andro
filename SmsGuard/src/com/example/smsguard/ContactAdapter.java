package com.example.smsguard;

import java.io.File;
import java.util.List;

import com.example.smsguard.model.Contact;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.Message;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ContactAdapter extends BaseAdapter {
	private static LayoutInflater inflater = null;
	private Activity activity;
	List<Contact> Contacts;

	public ContactAdapter(Activity a, List<Contact> contacts) {
		activity = a;
		Contacts = contacts;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Contacts.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	ViewHolder holder;

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View vi = convertView;

		if (convertView == null) {
			holder = new ViewHolder();
			vi = inflater.inflate(R.layout.contact_item, null);
			holder.TvContactName = (TextView) vi
					.findViewById(R.id.TvContactName);
			holder.TvContactPhone = (TextView) vi
					.findViewById(R.id.TvContactPhone);
			holder.ImgHapus = (ImageView) vi.findViewById(R.id.ImgContactDel);

			InputFilter[] FilterArray = new InputFilter[1];
			FilterArray[0] = new InputFilter.LengthFilter(100);
			holder.TvContactName.setFilters(FilterArray);
			vi.setTag(holder);

		} else
			holder = (ViewHolder) vi.getTag();

		try {
			Contact contact = Contacts.get(position);
			holder.TvContactName.setText(contact.getName());
			holder.TvContactName.setTag(contact.getId());
			holder.TvContactPhone.setText(contact.getPhone());
		} catch (Exception e) {

		}
		return vi;
	}

	public static class ViewHolder {
		public TextView TvContactName;
		public TextView TvContactPhone;
		public ImageView ImgHapus;
	}
}