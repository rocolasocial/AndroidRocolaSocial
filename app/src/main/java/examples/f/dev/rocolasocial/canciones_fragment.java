package examples.f.dev.rocolasocial;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import examples.f.dev.rocolasocial.domain.GuestModel;
import examples.f.dev.rocolasocial.domain.User;
import examples.f.dev.rocolasocial.io.ApiClient;
import examples.f.dev.rocolasocial.model.SetApiData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class canciones_fragment extends Fragment  {

    private static final String ARG_TITLE = "title";

    @Bind(R.id.idRecycleCanciones)
    RecyclerView recycleViewCanciones;



    //Constructor for new
    public static canciones_fragment newInstance(String title) {
        canciones_fragment cancionesFragment = new canciones_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        cancionesFragment.setArguments(args);
        return cancionesFragment;
    }


    public canciones_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //RecycleView

        View viewCanciones = inflater.inflate(R.layout.recyclecanciones, container, false);
        ButterKnife.bind(this, viewCanciones);
        setupRecycleViewCanciones();

        // Inflate the layout for this fragment
        return viewCanciones;

    }

    private void setupRecycleViewCanciones() {
        //porque  LinearLayoutManager sea vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycleViewCanciones.setLayoutManager(linearLayoutManager);
        MyAdapterRecycleView myAdapterRecycleView = new MyAdapterRecycleView(getActivity(), new ArrayList<User>());
        //createGuestsCanciones());
        recycleViewCanciones.setAdapter(myAdapterRecycleView);

        myAdapterRecycleView.setOnItemclickListener(new MyAdapterRecycleView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), "posicion: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private static List<GuestModel> createGuestsCanciones() {

        int[] nameGuests = {R.string.name_guest_1, R.string.name_guest_2, R.string.name_guest_3, R.string.name_guest_4};
        int[] imageGuets = {R.drawable.guest_1, R.drawable.guest_2, R.drawable.guest_3, R.drawable.guest_4};

        List<GuestModel> guestModels = new ArrayList<>();


        for (int i = 0; i < 4; i++) {

            for (int j = 0; j < nameGuests.length; j++) {
                guestModels.add(new GuestModel(imageGuets[j], nameGuests[j]));
                Log.i("", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><   Create RecycleVie CANCIONES    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            }
        }

        return guestModels;
    }

}
