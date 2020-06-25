package com.example.village;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.EditTextPreference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.widget.BaseAdapter;
import androidx.annotation.Nullable;

/**
 * Created by amagr on 2018-01-01.
 */

public class SettingPreferenceFragment extends PreferenceFragment {

    SharedPreferences pref;

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.settings_preference);
        pref =PreferenceManager.getDefaultSharedPreferences(getActivity());

    }// onCreate

    @Override
    public void onResume() {
        super.onResume();

//설정값 변경리스너..등록
        pref.registerOnSharedPreferenceChangeListener(listener);
    }//onResume() ..

    SharedPreferences.OnSharedPreferenceChangeListener listener = new SharedPreferences.OnSharedPreferenceChangeListener() {

        @Override
        public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
            if (key.equals("nickName")) {
                EditTextPreference ep = (EditTextPreference) findPreference(key);
                ep.setSummary(pref.getString(key, ""));
            }
            ((BaseAdapter)getPreferenceScreen().getRootAdapter()).notifyDataSetChanged();

        }

    };

}