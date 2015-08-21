package examples.f.dev.rocolasocial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.Bind;
import butterknife.ButterKnife;

public class cuenta_fragment extends Fragment {

    private static final String ARG_TITLE = "title";

    @Bind(R.id.imageCuenta)
    ImageView imageViewFragmentCuenta;

    @Bind(R.id.TextViewFragmentCuenta1)
    TextView textViewFragmentCuenta1;

    @Bind(R.id.TextViewFragmentCuenta2)
    TextView textViewFragmentCuenta2;

    public static cuenta_fragment newInstance(String title) {
        cuenta_fragment cuentaFragment = new cuenta_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);

        cuentaFragment.setArguments(args);
        return cuentaFragment;
    }

    public cuenta_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View viewRoot = inflater.inflate(R.layout.fragment_cuenta, container, false);
        ButterKnife.bind(this, viewRoot);

        //textViewFragmentCuenta.setText(getArguments().getString(ARG_TITLE));

        return viewRoot;
    }


}
