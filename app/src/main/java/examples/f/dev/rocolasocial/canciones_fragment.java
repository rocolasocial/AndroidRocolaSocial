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
import examples.f.dev.rocolasocial.domain.Canciones;
import examples.f.dev.rocolasocial.domain.GuestModel;
import examples.f.dev.rocolasocial.domain.Track;
import examples.f.dev.rocolasocial.domain.User;
import examples.f.dev.rocolasocial.model.SetApiData;


public class canciones_fragment extends Fragment  {

    private static final String ARG_TITLE = "title";


    @Bind(R.id.idRecycleCanciones)
    RecyclerView recycleViewCanciones;


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
        MyAdapterRecycleView myAdapterRecycleView;
        myAdapterRecycleView = new MyAdapterRecycleView(getActivity(), createCanciones());
        //createGuestsCanciones());
        recycleViewCanciones.setAdapter(myAdapterRecycleView);

        myAdapterRecycleView.setOnItemclickListener(new MyAdapterRecycleView.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                //Toast.makeText(getActivity(), "posicion: " + position, Toast.LENGTH_SHORT).show();
                Toast.makeText(getActivity(), "Ir a la info de la cancion: " + position, Toast.LENGTH_SHORT).show();
            }
        });

    }

    private static List<Canciones> createCanciones() {

/*        String[] mCoverUrl = {"http://userserve-ak.last.fm/serve/64s/105845747.png", "http://userserve-ak.last.fm/serve/64s/105845747.png", "http://userserve-ak.last.fm/serve/64s/105845747.png", "http://userserve-ak.last.fm/serve/64s/105845747.png", };
        String[] mName = {"--", "--", "--", "--"};
        String[] mAlbum = {"--", "--", "--", "--"};
        String[] mGenre = {"--", "--", "--", "--"};
        String[] mArtist = {"--", "--", "--", "--"};*/

        String[] mCoverUrl = {"http://userserve-ak.last.fm/serve/64s/105845747.png"};
        String[] mName = {"--"};
        String[] mAlbum = {"--"};
        String[] mGenre = {"--"};
        String[] mArtist = {"--"};

        List<Canciones> guestCanciones = new ArrayList<>();
        guestCanciones.add(new Canciones(mCoverUrl[0], mName[0], mAlbum[0], mGenre[0], mArtist[0]));

/*        for (int i = 0; i < 5; i++) {

            for (int j = 0; j < mCoverUrl.length; j++) {
                guestCanciones.add(new Canciones( mCoverUrl[j], mName[j], mAlbum[j], mGenre[j], mArtist[j]));
                Log.i("",">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><   Create RecycleVie Canciones Dummy    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
            }
        }*/

        return guestCanciones;
    }

}
