package com.jarvanmo.mframework.util;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.StringRes;
import android.widget.Toast;

/**
 * Created by mo on 16-3-28.
 * MToast is a util for toast
 */
public final class MToast {

    private static Toast mToast = null;
    private static Context mContext = null;

    private static long sOneTime = 0;
    private static long sTwoTime = 0;

    private static String sOldMessage = "";

    /***
     * Must call this method before use JMToast
     * usually, we init MToast in our application
     **/
    public static void init(Context context) {
        mContext = context;
    }


    /***
     * Usually , you'd better  call　 {@link #showToast(int)}　instead,
     * because we need internationalization sometimes.
     **/
    public static void showToast(@NonNull String message) {

        if (mToast == null) {
            mToast = Toast.makeText(mContext, message, Toast.LENGTH_SHORT);
            mToast.show();
            sOneTime = System.currentTimeMillis();
        } else {
            sTwoTime = System.currentTimeMillis();
            if (sOldMessage.equals(message)) {
                if (sTwoTime - sOneTime > Toast.LENGTH_SHORT) {
                    mToast.show();
                }
            } else {
                sOldMessage = message;
                mToast.setText(sOldMessage);
                mToast.show();
            }
        }

        sOneTime = sTwoTime;
    }

    public static void showToast(@StringRes int messageId) {
        showToast(mContext.getString(messageId));
    }


    /**
     * Close the view if it's showing, or don't show it if it isn't showing yet.
     * You do not normally have to call this.  Normally view will disappear on its own
     * after the appropriate duration.
     */
    public static void cancel() {
        if (mToast != null) {
            mToast.cancel();
        }

    }

}
