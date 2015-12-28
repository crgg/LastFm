package com.warsoft.lastfm.ui;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.warsoft.lastfm.R;
import com.warsoft.lastfm.domain.Artist;
import com.warsoft.lastfm.io.LastFmApiAdapter;
import com.warsoft.lastfm.io.LastFmApiService;
import com.warsoft.lastfm.io.model.HypedArtistsResponse;
import com.warsoft.lastfm.ui.adapter.HypedArtistsAdapter;

import java.util.ArrayList;

import retrofit.Call;
import retrofit.Callback;
import retrofit.Response;
import retrofit.Retrofit;
import rx.android.schedulers.AndroidSchedulers;

/**
 * Created by ander on 26/12/2015.
 */
public class HypedArtistsFragment extends Fragment  {
    public static final String LOG_TAG = HypedArtistsFragment.class.getName();
    public static final int NUM_COLUMS = 2;
    private RecyclerView mHypedArtistList;
    private HypedArtistsAdapter adapter;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        adapter = new HypedArtistsAdapter(getActivity());
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_hyped_artists, container, false);
        mHypedArtistList = (RecyclerView) root.findViewById(R.id.hyped_artists_list);
        //inicializamos los metodos para no generar exepciones
        setupArtistsList();

        return root;
    }


    @Override
    public void onResume() {
        super.onResume();
        // Asynchronous Call in Retrofit 2.0

        Call<HypedArtistsResponse> call = LastFmApiAdapter.getApiService().getHypedArtists();
        call.enqueue(new Callback<HypedArtistsResponse>() {
            @Override
            public void onResponse(Response<HypedArtistsResponse> response, Retrofit retrofit) {
                adapter.addAll(response.body().getArtists());
            }

            @Override
            public void onFailure(Throwable t) {
t.printStackTrace();
            }
        });

    }


    private void setupArtistsList() {
        mHypedArtistList.setLayoutManager(new GridLayoutManager(getActivity(), NUM_COLUMS));
        mHypedArtistList.setAdapter(adapter);
        mHypedArtistList.addItemDecoration(new ItemOffsetDecoration(getActivity(), R.integer.offset));
    }



}
