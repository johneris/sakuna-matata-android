package ph.coreproc.android.angelhack.models;

import android.support.annotation.DrawableRes;

/**
 * Created by Kaelito on 8/9/15.
 */
public class Channel {

    public String name;
    public @DrawableRes int image;

    public Channel(String name, @DrawableRes int image) {
        this.name = name;
        this.image = image;
    }
}
