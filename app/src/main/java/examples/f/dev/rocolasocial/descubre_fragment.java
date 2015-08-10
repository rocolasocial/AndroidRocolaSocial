package examples.f.dev.rocolasocial;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import domain.GuestModel;

import static android.support.v7.widget.LinearLayoutManager.*;


public class descubre_fragment extends Fragment  {

    private static final String ARG_TITLE = "title";
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

    //Crear la Vista de descubre_fragment
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        // Inflate the layout for  descubre_fragment
        View viewRoot = inflater.inflate(R.layout.fragment_descubre, container, false);
        ButterKnife.bind(this, viewRoot);

        //Map
        mapFragment = (SupportMapFragment) getChildFragmentManager().findFragmentById(R.id.mapdescubre);
        mapFragment.getMap().setMyLocationEnabled(true);
        mapFragment.getMap().moveCamera(CameraUpdateFactory.newLatLngZoom(
                new LatLng(19.363138, -99.182167), 14));
        mapFragment.getMap().addMarker(new MarkerOptions()
                .icon(BitmapDescriptorFactory.fromResource(R.drawable.ic_walk))
                .anchor(0.0f, 1.0f) // Anchors the marker on the bottom left
                .position(new LatLng(19.354878, -99.185600)));

        //Tabs
        List<Fragment> fragments = new ArrayList();
        fragments.add(new canciones_fragment());
        fragments.add(new artistas_fragment());
        fragments.add(new listas_fragment());

        MyFragmentAdapter myFragmentAdapter = new MyFragmentAdapter (getChildFragmentManager(), fragments);
        viewPager.setAdapter(myFragmentAdapter);
        tabLayout.setupWithViewPager(viewPager);

         return viewRoot;

    }

}
