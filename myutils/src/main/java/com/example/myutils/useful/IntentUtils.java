package com.example.myutils.useful;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.provider.MediaStore;

import java.io.File;

/**
 * Created by Administrator on 2018/7/16 0016.
 */

public class IntentUtils {
    /**
     * 把图片添加到相册里面
     * @param context
     * @param path
     */
    public static void addPhotoToXiangce(Context context,String path) {
        Uri localUri = Uri.fromFile(new File(path));
        Intent localIntent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE, localUri);
        context.sendBroadcast(localIntent);
    }

    /**
     * 访问本地的video
     * @param activity
     */
    public static void editVideo(Activity activity){
        Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Video.Media.EXTERNAL_CONTENT_URI);
        activity.startActivityForResult(intent, 0);
    }
}
