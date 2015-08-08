package ph.coreproc.android.angelhack.utils;

import android.app.Activity;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.telephony.SmsManager;

/**
 * Created by Kaelito on 8/8/15.
 */
public abstract class SMSSender {


    Context mContext;

    public SMSSender(Context context) {
        mContext = context;
    }

    public void sendSMS(String phoneNumber, String message)
    {
        String SENT = "SMS_SENT";
        String DELIVERED = "SMS_DELIVERED";

        PendingIntent sentPI = PendingIntent.getBroadcast(mContext, 0,
                new Intent(SENT), 0);

        PendingIntent deliveredPI = PendingIntent.getBroadcast(mContext, 0,
                new Intent(DELIVERED), 0);

        //---when the SMS has been sent---
        mContext.registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
                        onMessageSent();
                        break;
                    case SmsManager.RESULT_ERROR_GENERIC_FAILURE:
                        onMessageSendFailed("Generic failure");
                        break;
                    case SmsManager.RESULT_ERROR_NO_SERVICE:
                        onMessageSendFailed("No service");
                        break;
                    case SmsManager.RESULT_ERROR_NULL_PDU:
                        onMessageSendFailed("Null PDU");
                        break;
                    case SmsManager.RESULT_ERROR_RADIO_OFF:
                        onMessageSendFailed("Radio off");
                        break;
                }
            }
        }, new IntentFilter(SENT));

        //---when the SMS has been delivered---
        mContext.registerReceiver(new BroadcastReceiver(){
            @Override
            public void onReceive(Context arg0, Intent arg1) {
                switch (getResultCode())
                {
                    case Activity.RESULT_OK:
//                        Toast.makeText(getBaseContext(), "SMS delivered",
//                                Toast.LENGTH_SHORT).show();
                        break;
                    case Activity.RESULT_CANCELED:
//                        Toast.makeText(getBaseContext(), "SMS not delivered",
//                                Toast.LENGTH_SHORT).show();
                        break;
                }
            }
        }, new IntentFilter(DELIVERED));

        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(phoneNumber, null, message, sentPI, deliveredPI);
    }

    public abstract void onMessageSent();

    public abstract void onMessageSendFailed(String error);

}
