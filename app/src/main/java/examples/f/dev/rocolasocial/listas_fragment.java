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


public class listas_fragment extends Fragment {


    @Bind(R.id.idRecycleListas)
    RecyclerView recycleViewListas;


    public listas_fragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        //RecycleView

        View viewListas = inflater.inflate(R.layout.recyclelistas, container, false);
        ButterKnife.bind(this, viewListas);
        setupRecycleViewListas();

        // Inflate the layout for this fragment
        return viewListas;

    }

    private void setupRecycleViewListas() {
        //porque  LinearLayoutManager sea vertical
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), LinearLayoutManager.VERTICAL, false);
        recycleViewListas.setLayoutManager(linearLayoutManager);
        MyAdapterListasRecycleView myAdapterListasRecycleView = new MyAdapterListasRecycleView(getActivity(), createGuestsCanciones());
        recycleViewListas.setAdapter(myAdapterListasRecycleView);

        myAdapterListasRecycleView.setOnItemclickListener(new MyAdapterListasRecycleView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Toast.makeText(getActivity(), getActivity().getLocalClassName() + "posicion: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private static List<GuestModel> createGuestsCanciones() {

        int[] nameGuests = {R.string.name_guest_2, R.string.name_guest_3, R.string.name_guest_4, R.string.name_guest_1};
        int[] imageGuets = {R.drawable.guest_2, R.drawable.guest_3, R.drawable.guest_4, R.drawable.guest_1};

        List<GuestModel> guestModels = new ArrayList<>();


        for (int i = 0; i < 2; i++) {

            for (int j = 0; j < nameGuests.length; j++) {
                guestModels.add(new GuestModel(imageGuets[j], nameGuests[j]));
            }
        }


        return guestModels;
    }



}
