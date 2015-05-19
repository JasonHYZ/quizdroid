package edu.washington.yizhouh.quizdroid4;

import android.content.Intent;
import android.os.Bundle;
import android.preference.PreferenceActivity;

/**
 * Created by yizhouhuang on 5/16/15.
 */
public class UserSettingActivity extends PreferenceActivity {

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.user_settings);

        //Intent back = new Intent(UserSettingActivity.this, MainActivity.class);
        //startActivity(back);


    }
}
