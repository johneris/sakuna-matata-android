package ph.coreproc.android.angelhack.ui.fragments;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.ColorRes;
import android.support.annotation.DrawableRes;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;
import ph.coreproc.android.angelhack.R;

public class IntroFragment extends Fragment {

    public static final String ARGS_TITLE = "ARGS_TITLE";
    public static final String ARGS_DESCRIPTION = "ARGS_DESCRIPTION";
    public static final String ARGS_IMAGE = "ARGS_IMAGE";
    public static final String ARGS_COLOR = "ARGS_COLOR";



    private Context mContext;

    private String title;
    private String description;
    private @DrawableRes int image;
    private @ColorRes int color;



    @Bind(R.id.rootView)
    public View rootView;

    @Bind(R.id.titleTextView)
    public TextView titleTextView;

    @Bind(R.id.imageView)
    public ImageView imageView;

    @Bind(R.id.descriptionTextView)
    public TextView descriptionTextView;



    public static IntroFragment newInstance(String title, String description,
                                            @DrawableRes int image, @ColorRes int color) {
        IntroFragment introFragment = new IntroFragment();

        Bundle args = new Bundle();
        args.putString(ARGS_TITLE, title);
        args.putString(ARGS_DESCRIPTION, description);
        args.putInt(ARGS_IMAGE, image);
        args.putInt(ARGS_COLOR, color);
        introFragment.setArguments(args);

        return introFragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_intro, container, false);

        Bundle bundle = getArguments();
        title = bundle.getString(ARGS_TITLE);
        description = bundle.getString(ARGS_DESCRIPTION);
        image = bundle.getInt(ARGS_IMAGE);
        color = bundle.getInt(ARGS_COLOR);

        ButterKnife.bind(this, view);
        initialize();

        mContext = getActivity();

        return view;
    }

    private void initialize() {
        rootView.setBackgroundColor(getResources().getColor(color));
        titleTextView.setText(title);
        imageView.setImageDrawable(ResourcesCompat.getDrawable(getResources(), image, null));
        descriptionTextView.setText(description);
    }

}
