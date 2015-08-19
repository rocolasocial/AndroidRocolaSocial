package examples.f.dev.rocolasocial;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import examples.f.dev.rocolasocial.domain.User;
import examples.f.dev.rocolasocial.io.ApiClient;
import examples.f.dev.rocolasocial.io.ApiService;
import examples.f.dev.rocolasocial.model.SetApiData;
import retrofit.Callback;
import retrofit.RestAdapter;
import retrofit.RetrofitError;
import retrofit.client.Response;


public class descubre_fragment extends Fragment implements Callback<ArrayList<User>> {
//implements Callback<ArrayList<User>>
    private static final String ARG_TITLE = "title";
    static Boolean API_RESULT_OK = false;
    SupportMapFragment mapFragment;

    @Bind(R.id.viewpager)
    ViewPager viewPager;

    @Bind(R.id.tablayout)
    TabLayout tabLayout;


    //Constructor for new
    public static descubre_fragment newInstance(String title) {
        descubre_fragment descubreFragment = new descubre_fragment();
        Bundle args = new Bundle();
        args.putString(ARG_TITLE, title);
        descubreFragment.setArguments(args);
        return descubreFragment;
    }

    //Constructor
    public descubre_fragment() {
        // Required empty public constructor
    }

    @Override
    public void onResume(){

        super.onResume();

        ApiClient.getInstance()
                .getTopsTracks(this);

        Log.i("", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><   onCreate FINISH    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void success(ArrayList<User> users, Response response) {
        API_RESULT_OK = true;
        Log.i("", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><   RETROFIT SUCCESS FINISH    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");
    }

    @Override
    public void onPostExecute(ArrayList<User> users) {
        SetApiData setApiData;
        setApiData = SetApiData.getInstance();
        setApiData.setSongs(users);

        Log.i("", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><   RETROFIT ONPOSTEXECUTE FINISH    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        createApiData();
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }



    //Crear la Vista de descubre_fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {


        Double latlong[][] = {{19.465945, -99.141741} ,
                {19.461979, -99.144831} ,
                {19.454939, -99.151783},
                {19.448545, -99.152899},
                {19.446198, -99.153585},
                {19.441747, -99.155045},
                {19.435595, -99.157705},
                {19.430820, -99.159679},
                {19.426125, -99.161654},
                {19.424101, -99.163370},
                {19.422563, -99.163284},
                {19.417869, -99.165001},
                {19.415602, -99.165859},
                {19.409450, -99.167919},
                {19.403297, -99.169464},
                {19.396497, -99.171696},
                {19.389534, -99.174099},
                {19.382247, -99.176846},
                {19.375932, -99.178219},
                {19.370750, -99.179935},
                {19.363138, -99.182167},
                {19.354878, -99.185600},
                {19.347266, -99.187317} };

        int fin = latlong.length;
        Double x_lat, y_long;

        View viewRoot = inflater.inflate(R.layout.fragment_descubre, container, false);
        ButterKnife.bind(this, viewRoot);

        //Map
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapdescubre);
        mapFragment.getMap().setMyLocationEnabled(true);
        mapFragment.getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(19.363138, -99.182167), 13));
        mapFragment.getMap().addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_walk))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(19.354878, -99.185600)));

        for (int x = 1; x < fin; x++) {
            x_lat = latlong[x][0];
            y_long = latlong[x][1];
            //x_lat = 19.354878;
            //y_long = -99.187317;
            mapFragment.getMap().addMarker(new MarkerOptions()
                    .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_walk))
                    .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                    .position(new LatLng(x_lat, y_long)));

        }

        //Tabs
        List<Fragment> fragments = new ArrayList();
        fragments.add(new canciones_fragment());
        fragments.add(new artistas_fragment());
        fragments.add(new listas_fragment());

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter (getChildFragmentManager(), fragments);
        viewPager.setAdapter(myFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

        Log.i("", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><   onCreateView FINISH    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

         return viewRoot;

    }
/*
    @Override
    public void onResume() {
        super.onResume();
        ApiClient.getInstance()
                .getTopsTracks(this);

        Log.i("", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><   onResume FINISH    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

    }

   @Override
    public void success(ArrayList<User> users, Response response) {
        API_RESULT_OK = true;
        SetApiData setApiData;
        setApiData = SetApiData.getInstance();
        setApiData.setSongs(users);

        Log.i("", ">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>><   RETROFIT SUCCESS FINISH    <<<<<<<<<<<<<<<<<<<<<<<<<<<<<");

        createApiData();
    }

    @Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }*/



    public void createApiData () {
        //ArrayList<User>

        ArrayList<User> songs;
        songs = SetApiData.getInstance().getSongs();

        for (User user : songs) {

            Log.i("Canciones: ", "Canciones: " + user.toString());
            Log.i("Canciones: ", user.getUserName());
            Log.i("Canciones: ", String.valueOf(user.getInitialtime()));
            Log.i("Canciones: ", String.valueOf(user.getFinishtime()));
            for (int x = 0; x < user.getCanciones().size(); x++) {
                Log.i("Canciones: ", String.valueOf(user.getCanciones().get(x).getName()));
                Log.i("Canciones: ", String.valueOf(user.getCanciones().get(x).getAlbum()));
                Log.i("Canciones: ", String.valueOf(user.getCanciones().get(x).getCoverUrl()));
                Log.i("Canciones: ", String.valueOf(user.getCanciones().get(x).getGenre()));
                Log.i("Canciones: ", String.valueOf(user.getCanciones().get(x).getArtist()));
                Log.i("Canciones: ", String.valueOf(user.getCanciones().get(x).getCoordinates()[0]));
                Log.i("Canciones: ", String.valueOf(user.getCanciones().get(x).getCoordinates()[1]));
            }

        }

        //return  users;
    }

}
