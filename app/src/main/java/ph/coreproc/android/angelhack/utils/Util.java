package ph.coreproc.android.angelhack.utils;

import android.telephony.SmsManager;

/**
 * Created by Kaelito on 8/8/15.
 */
public class Util {

    public static boolean sendSMS(String phoneNumber, String message) {
        try {
            SmsManager smsManager = SmsManager.getDefault();
            smsManager.sendTextMessage(phoneNumber, null, message, null, null);
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

}
