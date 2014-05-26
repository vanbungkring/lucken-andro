package com.example.smsguard;

import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.text.InputFilter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;

import com.example.smsguard.model.Message;

public class MessageAdapter extends BaseAdapter implements Filterable {
	private static LayoutInflater inflater = null;
	private Activity activity;
	List<Message> Messages;
	Boolean IsChating = false; 

	public MessageAdapter(Activity a, List<Message> messages, Boolean isChating) {
		activity = a;
		Messages = messages;
		IsChating = isChating;
		inflater = (LayoutInflater) activity
				.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return Messages.size();
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
		Message message;
		if (convertView == null) {
			message = Messages.get(position);
			holder = new ViewHolder();
			if (IsChating) {
				if (message.getSender() == "me")
					vi = inflater.inflate(R.layout.chat_item_grey, null);
				else
					vi = inflater.inflate(R.layout.chat_item_green, null);
				holder.TvMessageDate = (TextView) vi
						.findViewById(R.id.TvChatDate);
				holder.TvMessageTime = (TextView) vi
						.findViewById(R.id.TvChatTime);
				holder.TvMessageContent = (TextView) vi
						.findViewById(R.id.TvChatContent);
			} else {
				vi = inflater.inflate(R.layout.message_item, null);
				holder.TvMessageSender = (TextView) vi
						.findViewById(R.id.TvMessegeSender);
				holder.TvMessageDate = (TextView) vi
						.findViewById(R.id.TvMessageDate);
				holder.TvMessageContent = (TextView) vi
						.findViewById(R.id.TvMessageContent);
			}
			InputFilter[] FilterArray = new InputFilter[1];
			FilterArray[0] = new InputFilter.LengthFilter(100);
			holder.TvMessageContent.setFilters(FilterArray);
			vi.setTag(holder);

		} else
			holder = (ViewHolder) vi.getTag();

		try {
			message = Messages.get(position);
			if (!IsChating)
				holder.TvMessageSender.setText(message.getSender());
			else
				holder.TvMessageTime.setText(message.getTime());
			holder.TvMessageDate.setText(message.getDate());
			holder.TvMessageContent.setText(message.getContent());
			holder.TvMessageContent.setTag(message.getId());
		} catch (Exception e) {

		}
		return vi;
	}

	public static class ViewHolder {
		public TextView TvMessageSender;
		public TextView TvMessageDate;
		public TextView TvMessageTime;
		public TextView TvMessageContent;
	}

	@Override
	public Filter getFilter() {
		// TODO Auto-generated method stub
		return null;
	}
}