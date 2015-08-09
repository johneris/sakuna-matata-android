package ph.coreproc.android.angelhack.utils;

import java.util.ArrayList;
import java.util.List;

import ph.coreproc.android.angelhack.R;
import ph.coreproc.android.angelhack.models.Channel;

/**
 * Created by Kaelito on 8/9/15.
 */
public class Util {

    public static List<Channel> getChannels() {
        List<Channel> channelList = new ArrayList<>();
        channelList.add(new Channel("typhoon", R.drawable.ic_launcher));
        channelList.add(new Channel("storm_surge", R.drawable.ic_launcher));
        channelList.add(new Channel("earthquake", R.drawable.ic_launcher));
        channelList.add(new Channel("volcanic_eruption", R.drawable.ic_launcher));
        return channelList;
    }

}
