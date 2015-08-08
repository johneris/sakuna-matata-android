package ph.coreproc.android.angelhack.ui.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import ph.coreproc.android.angelhack.utils.Preferences;

/**
 * Created by Kaelito on 8/8/15.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if(Preferences.getFirstLaunch(this)) {
            Preferences.setFirstLaunch(this, false);
            startActivity(new Intent(this, IntroActivity.class));
        } else {
            startActivity(new Intent(this, HomeActivity.class));
        }

        finish();
    }

}
