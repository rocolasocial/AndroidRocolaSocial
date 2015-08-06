package examples.f.dev.rocolasocial;

import android.os.Bundle;
import android.support.design.widget.NavigationView;

import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import butterknife.Bind;
import butterknife.ButterKnife;

public class RocolaActivity extends AppCompatActivity {

    @Bind(R.id.toolbar)
    Toolbar toolbar;

    @Bind(R.id.drawerLayout)
    DrawerLayout drawerLayout;

    @Bind(R.id.navigationView)
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_rocola);

        ButterKnife.bind(this);

        replaceToolbar();

        setupNavigationView();

    }

    private void setupNavigationView(){
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {

                switch (menuItem.getItemId()) {
                    case R.id.itembuscar:
                        replaceFragmentBuscar(buscar_fragment.newInstance(menuItem.getTitle().toString()));
                        break;
                    case R.id.itemdescubre:
                        replaceFragmentDescubre(descubre_fragment.newInstance(menuItem.getTitle().toString()));
                        break;
                    case R.id.itemturastro:
                        replaceFragmentRastro(raster_fragment.newInstance(menuItem.getTitle().toString()));
                        break;
                    case R.id.itemtucuenta:
                        replaceFragmentTuCuenta(cuenta_fragment.newInstance(menuItem.getTitle().toString()));
                        break;
                }

                menuItem.setChecked(true);
                drawerLayout.closeDrawers();
                return false;
            }

        });

    }

    private void replaceFragmentBuscar(buscar_fragment buscarFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, buscarFragment)
                .commit();
    }
    private void replaceFragmentDescubre(descubre_fragment descubreFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, descubreFragment)
                .commit();
    }
    private void replaceFragmentRastro(raster_fragment rastroFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, rastroFragment)
                .commit();
    }
    private void replaceFragmentTuCuenta(cuenta_fragment cuentaFragment) {
        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container, cuentaFragment)
                .commit();
    }


    private void replaceToolbar(){

        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();

        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        actionBar.setHomeAsUpIndicator(R.drawable.ic_menu_white_24dp);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_rocola, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        if (id == android.R.id.home) {
            drawerLayout.openDrawer(GravityCompat.START);
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
