package ph.coreproc.android.angelhack.ui.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v7.app.AlertDialog;
import android.widget.ArrayAdapter;

public abstract class ChannelDialogFragment extends DialogFragment {

    private Context mContext;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getActivity();
    }


    private String newChannel;

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        AlertDialog.Builder builder = new AlertDialog.Builder(mContext);
        builder.setTitle("Channels");

        final ArrayAdapter<String> channelArrayAdapter = getChannelArrayAdapter();

        builder.setSingleChoiceItems(channelArrayAdapter, 0,
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        newChannel = channelArrayAdapter.getItem(which);
                    }
                });
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int id) {
                onChannelChanged(newChannel);
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

    public abstract void onChannelChanged(String channel);

    private ArrayAdapter<String> getChannelArrayAdapter() {
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(
                mContext,
                android.R.layout.select_dialog_singlechoice);
        arrayAdapter.add("TYPHOON");
        arrayAdapter.add("EARTHQUAKE");
        arrayAdapter.add("TSUNAMI");
        return arrayAdapter;
    }

}
