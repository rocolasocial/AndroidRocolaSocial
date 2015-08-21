package examples.f.dev.rocolasocial;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.view.SimpleDraweeView;

import java.util.ArrayList;
import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;
import examples.f.dev.rocolasocial.domain.Canciones;
import examples.f.dev.rocolasocial.domain.User;
import examples.f.dev.rocolasocial.io.ApiClient;
import examples.f.dev.rocolasocial.model.SetApiData;
import retrofit.Callback;
import retrofit.RetrofitError;
import retrofit.client.Response;

/**
 * Created by Salvador on 10/08/2015.
 */
public class MyAdapterArtistasRecycleView extends RecyclerView.Adapter<MyAdapterArtistasRecycleView.ViewHolder> implements Callback<ArrayList<User>> {

    private LayoutInflater inflater;
    private OnItemClickListener onItemClickListener;
    private List<Canciones> adapterArtistas;
    private ArrayList<User> users;
    private Canciones mArtistas = new Canciones();
    private Response response;


    public MyAdapterArtistasRecycleView(Context context,  List<Canciones> guestArtistas) {
        this.adapterArtistas = guestArtistas;
        inflater = LayoutInflater.from(context);
        executeRetrofit();
    }


    public void executeRetrofit() {
        ApiClient.getInstance()
                .getTopsTracks(this);
    }

    @Override
    public void success(ArrayList<User> users, Response response) {
        List<Canciones> passArtistas = new ArrayList<>();
        SetApiData setApiData;
        setApiData = SetApiData.getInstance();
        setApiData.setSongs(users);

        createApiData();

        adapterArtistas.remove(0);
        passArtistas = ApiDataCanciones(users, mArtistas);
        adapterArtistas.addAll(0, passArtistas);

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
        View viewItem = inflater.inflate(R.layout.item_artistas, parent, false);
        ViewHolder viewHolder = new ViewHolder(viewItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {

        holder.setData(adapterArtistas.get(position), position);

    }

    @Override
    public int getItemCount() {
        return adapterArtistas.size();
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

        @Bind(R.id.tvArtist)
        TextView vhtvArtist;

        private int position;


        public ViewHolder(View viewItem) {
            // como extiende de una interfaz debemos llamar a su padre.
            super(viewItem);
            ButterKnife.bind(this, viewItem);
            // this
            viewItem.setOnClickListener(this);

        }


        public void setData(Canciones artistasModel, int position) {
            //Fresco
            SimpleDraweeView imageFresco = (SimpleDraweeView) vhidCoverUrl ;
            Uri uriFresco = Uri.parse(artistasModel.getCoverUrl());
            imageFresco.setImageURI(uriFresco);

            vhtvArtist.setText(artistasModel.getArtist());
            vhtvName.setText(artistasModel.getName());
            vhtvGenre.setText(artistasModel.getGenre());

            //vhidCoverUrl.setImageURI(Uri.parse(artistasModel.getCoverUrl()));
            //vhtvAlbum.setText(artistasModel.getAlbum());

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

        //= new ArrayList<>();

        ArrayList<User> songs;
        songs = SetApiData.getInstance().getSongs();

        for (User user : songs) {
            for (int x = 0; x < user.getCanciones().size(); x++) {
                Canciones tmp = new Canciones();
                tmp.setCoverUrl(user.getCanciones().get(x).getCoverUrl());
                tmp.setArtist(user.getCanciones().get(x).getArtist());
                tmp.setName(user.getCanciones().get(x).getName());
                tmp.setGenre(user.getCanciones().get(x).getGenre());
                tmp.setAlbum(user.getCanciones().get(x).getAlbum());

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
