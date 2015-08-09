package ph.coreproc.android.angelhack.models;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;

/**
 * Created by Kaelito on 8/9/15.
 */
public class Message extends Model {

    @Column(name = "message")
    public String message;

    public Message() {
        super();
    }

}
