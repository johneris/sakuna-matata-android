package ph.coreproc.android.angelhack.utils;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by johneris on 6/16/2015.
 */
public class Preferences {

    private static String PACKAGE = "ph.coreproc.android.angelhack";

    /**
     * Keys used to get and put values
     */
    private final static String FIRST_LAUNCH = "FIRST_LAUNCH";



    public static void setFirstLaunch(Context context, boolean firstLaunch) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        prefs.edit().putBoolean(FIRST_LAUNCH, firstLaunch).commit();
    }

    public static boolean getFirstLaunch(Context context) {
        SharedPreferences prefs = context.getSharedPreferences(PACKAGE, Context.MODE_PRIVATE);
        return prefs.getBoolean(FIRST_LAUNCH, true);
    }

}