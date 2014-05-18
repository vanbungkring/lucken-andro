package com.example.smsguard;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;
import java.util.Calendar;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.preference.PreferenceManager;
import android.view.View;
import android.view.ViewConfiguration;
import android.webkit.WebView.FindListener;
import android.widget.ImageView;
import android.widget.TextView;

public class helper {
	static SharedPreferences sp;

	public static SharedPreferences getSp(Context ctx) {
		if (sp == null)
			sp = PreferenceManager.getDefaultSharedPreferences(ctx);
		return sp;
	}

	public static void setActionBar(Activity act, String Title,
			Boolean showHomeButton) {
		act.getActionBar().setDisplayShowHomeEnabled(false);
		act.getActionBar().setTitle(Title);
		act.getActionBar().setBackgroundDrawable(
				new ColorDrawable(Color.parseColor("#1BC739")));
		act.getActionBar().setDisplayHomeAsUpEnabled(showHomeButton);

	}

	public static void getOverflowMenu(Context ctx) {

		try {
			ViewConfiguration config = ViewConfiguration.get(ctx);
			Field menuKeyField = ViewConfiguration.class
					.getDeclaredField("sHasPermanentMenuKey");
			if (menuKeyField != null) {
				menuKeyField.setAccessible(true);
				menuKeyField.setBoolean(config, false);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static String getCurrentDate(String format) {
		Calendar calendar = Calendar.getInstance();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
		return simpleDateFormat.format(calendar.getTime());
	}
}
