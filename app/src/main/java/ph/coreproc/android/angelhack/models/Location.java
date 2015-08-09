package ph.coreproc.android.angelhack.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

public class Location extends Model {

    @Column(name = "province")
    public String province;

    @Column(name = "city_municipality")
    public String cityMunicipality;

    @Column(name = "barangay_street_no")
    public String barangayStreetNo;

    public Location() {
        super();
    }

    @Override
    public String toString() {
        String locationString = province + ", " +
                cityMunicipality + ", " +
                barangayStreetNo;
        locationString = locationString.trim();
        return locationString;
    }
}
