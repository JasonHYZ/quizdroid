package edu.washington.yizhouh.quizdroid5;

import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by yizhouhuang on 5/17/15.
 */
public class UserSettingActivity extends PreferenceActivity{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_settings);

    }
}
