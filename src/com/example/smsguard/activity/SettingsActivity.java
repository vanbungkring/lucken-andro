/**
 * 
 */
package com.example.smsguard.activity;

import com.example.smsguard.R;
import com.example.smsguard.helper;
import com.example.smsguard.R.string;
import com.example.smsguard.R.xml;

import android.content.SharedPreferences;
import android.content.SharedPreferences.OnSharedPreferenceChangeListener;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceActivity;

/**
 * @author Luqman
 * 
 */
public class SettingsActivity extends PreferenceActivity implements
		OnSharedPreferenceChangeListener {
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		addPreferencesFromResource(R.xml.settings);
		helper.setActionBar(this, getString(R.string.SettingTitle), true);
		SharedPreferences sp = getPreferenceScreen().getSharedPreferences();
		EditTextPreference editTextPref = (EditTextPreference) findPreference("prefSmsCenter");
		editTextPref.setSummary(sp.getString("prefSmsCenter", ""));
		editTextPref = (EditTextPreference) findPreference("prefRegistrationCenter");
		editTextPref.setSummary(sp.getString("prefRegistrationCenter", ""));
		setSummary("prefServiceType", sp.getString("prefServiceType", ""));
		setSummary("prefAutolock", sp.getString("prefAutolock", ""));
		setSummary("prefLanguageSelection",
				sp.getString("prefLanguageSelection", ""));
	}

	@Override
	protected void onResume() {
		super.onResume();
		getPreferenceScreen().getSharedPreferences()
				.registerOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onPause() {
		super.onPause();
		getPreferenceScreen().getSharedPreferences()
				.unregisterOnSharedPreferenceChangeListener(this);
	}

	@Override
	protected void onSaveInstanceState(Bundle outState) {
		// TODO Auto-generated method stub
		super.onSaveInstanceState(outState);
	}

	@Override
	public void onSharedPreferenceChanged(SharedPreferences sharedPreferences,
			String key) {
		// TODO Auto-generated method stub
		Preference pref = findPreference(key);
		if (pref instanceof EditTextPreference) {
			EditTextPreference etp = (EditTextPreference) pref;
			pref.setSummary(etp.getText());
		}
		if (pref instanceof ListPreference) {
			setSummary(key, ((ListPreference) pref).getValue());
		}
	}

	private void setSummary(String key, String value) {
		int loop = 0;
		String[] data = null;
		String[] data1 = null;
		if (key.equals("prefAutolock")) {
			data = getResources().getStringArray(R.array.autolockValues);
			data1 = getResources().getStringArray(R.array.autolock);
		} else if (key.equals("prefLanguageSelection")) {
			data = getResources().getStringArray(R.array.languageValues);
			data1 = getResources().getStringArray(R.array.language);
		} else if (key.equals("prefServiceType")) {
			data = getResources().getStringArray(R.array.serviceValues);
			data1 = getResources().getStringArray(R.array.service);
		}
		for (String dai : data) {
			if (dai.equals(value))
				(findPreference(key)).setSummary(data1[loop]);
			loop++;
		}
	}
}
