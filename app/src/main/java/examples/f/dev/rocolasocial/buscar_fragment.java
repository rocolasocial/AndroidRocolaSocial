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


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link buscar_fragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link buscar_fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class buscar_fragment extends Fragment {

    private static final String BUSCAR_TITLE = "title";

    @Bind(R.id.imageBuscar)
    ImageView imageViewFragmentBuscar;

    @Bind(R.id.TextViewFragmentBuscar1)
    TextView textViewFragmentBuscar1;

    @Bind(R.id.TextViewFragmentBuscar2)
    TextView textViewFragmentBuscar2;

    public static buscar_fragment newInstance(String title) {
        buscar_fragment buscarFragment = new buscar_fragment();
        Bundle args = new Bundle();
        args.putString(BUSCAR_TITLE, title);

        buscarFragment.setArguments(args);
        return buscarFragment;
    }

    public buscar_fragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View viewRoot = inflater.inflate(R.layout.fragment_buscar, container, false);
        ButterKnife.bind(this, viewRoot);
        //textViewFragmentBuscar.setText(getArguments().getString(BUSCAR_TITLE));
        return viewRoot;
    }





    /*    @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            if (getArguments() != null) {
                mParam1 = getArguments().getString(ARG_PARAM1);
                mParam2 = getArguments().getString(ARG_PARAM2);
            }
        }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        try {
            mListener = (OnFragmentInteractionListener) activity;
        } catch (ClassCastException e) {
            throw new ClassCastException(activity.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.

    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        public void onFragmentInteraction(Uri uri);
    }   */

}
