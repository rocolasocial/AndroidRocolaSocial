package examples.f.dev.rocolasocial;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;
import com.google.android.gms.common.api.Api;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import de.hdodenhof.circleimageview.CircleImageView;
import examples.f.dev.rocolasocial.domain.Canciones;
import examples.f.dev.rocolasocial.domain.GuestModel;
import examples.f.dev.rocolasocial.domain.Track;
import examples.f.dev.rocolasocial.domain.User;
import examples.f.dev.rocolasocial.io.ApiClient;
import examples.f.dev.rocolasocial.model.SetApiData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Salvador on 09/08/2015.
 */
public class MyAdapterRecycleView extends RecyclerView.Adapter<MyAdapterRecycleView.ViewHolder> implements Callback<ArrayList<User>> {
//implements Callback<ArrayList<User>>

    //private ArrayList<User> adapterUsers;
    static Boolean API_RESULT_OK = false;
    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    private List<Canciones> adapterCanciones;
    private ArrayList<User> users;
    private Canciones mCanciones = new Canciones();
    private Response response;

    //= ApiDataCanciones(adapterUsers);

    public MyAdapterRecycleView(Context context,  List<Canciones> adapterCanciones) {
        this.adapterCanciones = adapterCanciones;
        inflater = LayoutInflater.from(context);
        executeRetrofit();
    }


    public void executeRetrofit() {
        ApiClient.getInstance()
                .getTopsTracks(this);
    }

    @Override
    public void success(ArrayList<User> users, Response response) {
        API_RESULT_OK = true;
        List<Canciones> passCanciones = new ArrayList<>();
        SetApiData setApiData;
        setApiData = SetApiData.getInstance();
        setApiData.setSongs(users);

        createApiData();

        adapterCanciones.remove(0);
        passCanciones = ApiDataCanciones(users, mCanciones);
        adapterCanciones.addAll(0, passCanciones);

        notifyDataSetChanged();
    }

    //@Override
    public void failure(RetrofitError error) {
        error.printStackTrace();
    }

    public void setOnItemclickListener(OnItemClickListener onItemclickListener) {
        this.onItemClickListener = onItemclickListener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //false para que invierta
        Fresco.initialize(inflater.getContext());
        View viewItem = inflater.inflate(R.layout.item_canciones, parent, false);
        ViewHolder viewHolder = new ViewHolder(viewItem);
        return viewHolder;
    }


    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(adapterCanciones.get(position), position);

    }

    @Override
    public int getItemCount() {
        return adapterCanciones.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        @Bind(R.id.idCoverUrl)
        SimpleDraweeView vhidCoverUrl;

        @Bind(R.id.tvName)
        TextView vhtvName;

        //@Bind(R.id.tvAlbum)
        //TextView vhtvAlbum;

        @Bind(R.id.tvGenre)
        TextView vhtvGenre;

        //@Bind(R.id.tvArtist)
        //TextView vhtvArtist;

        private int position;


        public ViewHolder(View viewItem) {
            // como extiende de una interfaz debemos llamar a su padre.
            super(viewItem);
            ButterKnife.bind(this, viewItem);

            // this
            viewItem.setOnClickListener(this);

        }

        public void setData(Canciones cancionesModel, int position) {
            //Fresco
            SimpleDraweeView imageFresco = (SimpleDraweeView) vhidCoverUrl ;
            Uri uriFresco = Uri.parse(cancionesModel.getCoverUrl());
            imageFresco.setImageURI(uriFresco);

            vhtvName.setText(cancionesModel.getName());
            vhtvGenre.setText(cancionesModel.getGenre());
            //vhidCoverUrl.setImageURI(Uri.parse(cancionesModel.getCoverUrl()));
            //vhtvAlbum.setText(cancionesModel.getAlbum());
            //vhtvArtist.setText(cancionesModel.getArtist());

            this.position = position;
        }

        @Override
        public void onClick(View v) {
//            int position = (int) v.getTag();
            onItemClickListener.onItemClick(v, position);

        }
    }

    public List<Canciones> ApiDataCanciones(ArrayList<User> users, Canciones canciones) {

        List<Canciones> returnSongs = new ArrayList<Canciones>();

        ArrayList<User> songs;
        songs = SetApiData.getInstance().getSongs();

        for (User user : songs) {
            for (int x = 0; x < user.getCanciones().size(); x++) {
                    Canciones tmp = new Canciones();
                    tmp.setCoverUrl(user.getCanciones().get(x).getCoverUrl());
                    tmp.setName(user.getCanciones().get(x).getName());
                    tmp.setAlbum(user.getCanciones().get(x).getAlbum());
                    tmp.setGenre(user.getCanciones().get(x).getGenre());
                    tmp.setArtist(user.getCanciones().get(x).getArtist());

                    returnSongs.add(x, tmp);
            }

        }

        return returnSongs ;
    }

    //definir la interface en el adaptador para recuperar el click en la MyadapterRecycleView.java
    public interface OnItemClickListener{
        public void onItemClick(View view, int position);
    }

    public void createApiData () {
        //ArrayList<User>

        ArrayList<User> songs;
        songs = SetApiData.getInstance().getSongs();
    }

}
