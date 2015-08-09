package ph.coreproc.android.angelhack.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;

import com.activeandroid.query.Select;

import java.util.List;

import ph.coreproc.android.angelhack.models.Location;

public abstract class LocationDialogFragment extends DialogFragment {

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }


    private Location newLocation;
    private List<Location> mLocationList;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Previous Locations");

        mLocationList = new Select().from(Location.class).execute();
        final ArrayAdapter<String> locationArrayAdapter = getChannelArrayAdapter();

        newLocation = mLocationList.get(0);
        builder.setSingleChoiceItems(locationArrayAdapter, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        newLocation = mLocationList.get(which);
                    }
                });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onLocationSelected(newLocation);
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        return builder.create();
    }

    public abstract void onLocationSelected(Location location);

    private ArrayAdapter<String> getChannelArrayAdapter() {
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                mContext,
                android.R.layout.select_dialog_singlechoice);

        for(Location location : mLocationList) {
            arrayAdapter.add(location.toString());
        }

        return arrayAdapter;
    }

}
