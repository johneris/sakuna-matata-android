package ph.coreproc.android.angelhack.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by johneris on 6/16/2015.
 */
public class Preferences {

    private static String PACKAGE = "ph.coreproc.android.angelHack2015";

    /**
     * Keys used to get and put values
     */
    public final static String API_KEY = "API_KEY";


    public static void setApiKey(Context context, String apiKey) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        prefs.edit().putString(API_KEY, apiKey).commit();
    }

    public static String getApiKey(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        return prefs.getString(API_KEY, "");
    }

}