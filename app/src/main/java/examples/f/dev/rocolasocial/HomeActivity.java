package examples.f.dev.rocolasocial;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import butterknife.ButterKnife;
import butterknife.OnClick;


public class HomeActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //getSupportActionBar().hide();
        setContentView(R.layout.activity_home);

        ButterKnife.bind(this);
    }



    @OnClick({R.id.btnIniciar, R.id.btnCreaTuCuenta})
    public void OnClick(View view){
        switch (view.getId()){
            case R.id.btnIniciar:
                launchActivity(IniciarSesion.class);
                break;
            case R.id.btnCreaTuCuenta:
                launchActivity(CrearCuenta.class);
                break;
        }

    }

    public void launchActivity(Class MyClass){
        Intent intent = new Intent(HomeActivity.this, MyClass);
        startActivity(intent);
    }





    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_home, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
