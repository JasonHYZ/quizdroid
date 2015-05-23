package edu.washington.yizhouh.quizdroid5;

import android.app.DownloadManager;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Environment;
import android.provider.Settings;
import android.widget.Toast;
import android.net.Uri;


/**
 * Created by yizhouhuang on 5/17/15.
 */
public class AlarmReceiver extends BroadcastReceiver{


    @Override
    public void onReceive(Context context, Intent intent) {
        String url =intent.getStringExtra("URL");
        Toast.makeText(context, url, Toast.LENGTH_SHORT).show();


        Intent downloadServiceIntent = new Intent(context,DownloadService.class);
        downloadServiceIntent.putExtra("URL",url);
        context.startService(downloadServiceIntent);

    }

}
