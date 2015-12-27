package com.warsoft.lastfm.ui.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.warsoft.lastfm.R;
import com.warsoft.lastfm.domain.Artist;

import java.util.ArrayList;

/**
 * Created by ander on 27/12/2015.
 */
public class HypedArtistsAdapter extends RecyclerView.Adapter<HypedArtistsAdapter.HypedArtistViewHolder>{
ArrayList<Artist> artists;
    Context context;

    public HypedArtistsAdapter(Context context) {
        this.context = context;
        this.artists = new ArrayList<>();
    }

    @Override
    public HypedArtistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
       View itemView = LayoutInflater.from(context)
               .inflate(R.layout.item_hyped_artist, parent, false);
        return new HypedArtistViewHolder(itemView);
    }



    @Override
    public void onBindViewHolder(HypedArtistViewHolder holder, int position) {
Artist currentArtist = artists.get(position);
        holder.setArtistName(currentArtist.getName());
    }

    @Override
    public int getItemCount() {
        return artists.size();
    }

    public  void addAll(@NonNull ArrayList<Artist> artists){
        if (artists==null)
            throw new NullPointerException("The items cannot by null");
        this.artists.addAll(artists);
        notifyDataSetChanged();
     //   notifyItemRangeInserted(getItemCount() -1,artists.size());
    }

    public class HypedArtistViewHolder extends RecyclerView.ViewHolder{
        TextView artistName;
        ImageView artistImage;

    public HypedArtistViewHolder(View itemView) {
        super(itemView);

        artistName = (TextView)itemView.findViewById(R.id.artist_name);
        artistImage =(ImageView)itemView.findViewById(R.id.img_artist);
    }

        public void setArtistName(String name){
            artistName.setText(name);
        }
}

}
