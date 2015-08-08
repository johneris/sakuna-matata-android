package ph.coreproc.android.angelhack.utils;

import android.content.Context;
import android.location.Address;
import android.location.Geocoder;
import android.telephony.SmsManager;

import java.util.List;
import java.util.Locale;

import ph.coreproc.android.angelhack.models.Location;

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

    public static Location getLocation(Context context, double latitude, double longitude, String description) {
        Location location = new Location();
        location.latitude = latitude;
        location.longitude = longitude;
        location.description = description;

        try {
            Geocoder geocoder;
            List<Address> addresses;
            geocoder = new Geocoder(context, Locale.getDefault());
            addresses = geocoder.getFromLocation(latitude, longitude, 1);

            location.province = addresses.get(0).getLocality();
            location.city = addresses.get(0).getAdminArea();

        } catch (Exception e) {
            e.printStackTrace();

            location.province = "";
            location.city = "";
        }

        return location;
    }



}
