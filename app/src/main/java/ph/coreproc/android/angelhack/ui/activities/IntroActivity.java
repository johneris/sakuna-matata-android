package ph.coreproc.android.angelhack.ui.activities;

import android.content.Intent;
import android.os.Bundle;

import com.github.paolorotolo.appintro.AppIntro2;

import ph.coreproc.android.angelhack.R;
import ph.coreproc.android.angelhack.ui.fragments.IntroFragment;


public class IntroActivity extends AppIntro2 {

    @Override
    public void init(Bundle savedInstanceState) {
        addSlide(IntroFragment.newInstance("Title 1", "description 1", R.drawable.ic_launcher, R.color.primary));
        addSlide(IntroFragment.newInstance("Title 2", "description 2", R.drawable.ic_launcher, R.color.primary));
        addSlide(IntroFragment.newInstance("Title 3", "description 3", R.drawable.ic_launcher, R.color.primary));
    }

    @Override
    public void onDonePressed() {
        startActivity(new Intent(this, HomeActivity.class));
        finish();
    }

}
