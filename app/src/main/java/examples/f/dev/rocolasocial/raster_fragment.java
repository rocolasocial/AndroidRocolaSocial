package examples.f.dev.rocolasocial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;


public class raster_fragment extends Fragment {

    private static final String ARG_TITLE = "title";

    @Bind(R.id.textViewFragmentRastro)
    TextView textViewFragmentRastro;

    public static raster_fragment newInstance(String title) {
        raster_fragment rastroFragment = new raster_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);

        rastroFragment.setArguments(args);
        return rastroFragment;
    }

    public raster_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_rastro, container, false);
        ButterKnife.bind(viewRoot);
        textViewFragmentRastro.setText(getArguments().getString(ARG_TITLE));
        return viewRoot;
    }

}
