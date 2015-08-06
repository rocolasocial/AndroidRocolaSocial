package examples.f.dev.rocolasocial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class descubre_fragment extends Fragment {

    private static final String ARG_TITLE = "title";

    @Bind(R.id.textViewFragmentDescubre)
    TextView textViewFragmentDescubre;

    public static descubre_fragment newInstance(String title) {
        descubre_fragment descubreFragment = new descubre_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        descubreFragment.setArguments(args);
        return descubreFragment;
    }

    public descubre_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_descubre, container, false);
        ButterKnife.bind(this, viewRoot);

        textViewFragmentDescubre.setText(getArguments().getString(ARG_TITLE));

        return viewRoot;
    }


}
