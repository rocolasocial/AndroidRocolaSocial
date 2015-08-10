package examples.f.dev.rocolasocial;

import android.app.Activity;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import domain.GuestModel;

public class artistas_fragment extends Fragment {

    @Bind(R.id.idRecycleArtistas)
    RecyclerView recycleViewArtistas;

/*    @Bind(R.id.recycleListas)
    RecyclerView recycleViewListas;*/


    public artistas_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //RecycleView

        View viewArtistas = inflater.inflate(R.layout.recycleartistas, container, false);
        ButterKnife.bind(this, viewArtistas);
        setupRecycleViewArtistas();

        // Inflate the layout for this fragment
        return viewArtistas;

    }

    private void setupRecycleViewArtistas() {
        //porque  LinearLayoutManager sea vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycleViewArtistas.setLayoutManager(linearLayoutManager);
        MyAdapterArtistasRecycleView myAdapterArtistasRecycleView = new MyAdapterArtistasRecycleView(getActivity(), createGuestsCanciones());
        recycleViewArtistas.setAdapter(myAdapterArtistasRecycleView);

        myAdapterArtistasRecycleView.setOnItemclickListener(new MyAdapterArtistasRecycleView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), getActivity().getLocalClassName() + "posicion: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private static List<GuestModel> createGuestsCanciones() {

        int[] nameGuests = {R.string.name_guest_4, R.string.name_guest_3, R.string.name_guest_2, R.string.name_guest_1};
        int[] imageGuets = {R.drawable.guest_4, R.drawable.guest_3, R.drawable.guest_2, R.drawable.guest_1};

        List<GuestModel> guestModels = new ArrayList<>();


        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < nameGuests.length; j++) {
                guestModels.add(new GuestModel(imageGuets[j], nameGuests[j]));
            }
        }


        return guestModels;
    }


}
