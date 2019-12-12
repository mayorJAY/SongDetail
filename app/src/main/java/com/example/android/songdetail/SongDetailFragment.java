package com.example.android.songdetail;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.android.songdetail.content.SongUtils;
import com.example.josycom.songdetail.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class SongDetailFragment extends Fragment {
    // SongItem includes the song title and detail.
    public SongUtils.Song mSong;

    public SongDetailFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments().containsKey(SongUtils.SONG_ID_KEY)) {
            // Load the content specified by the fragment arguments.
            mSong = SongUtils.SONG_ITEMS.get(getArguments()
                    .getInt(SongUtils.SONG_ID_KEY));
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_song_detail, container, false);
        // Show the detail information in a TextView
        if (mSong != null) {
            ((TextView) rootView.findViewById(R.id.fragment_tv))
                    .setText(mSong.details);
        }
        return rootView;
    }

    public static SongDetailFragment newInstance(int selectedSong){
        SongDetailFragment fragment = new SongDetailFragment();
        Bundle args = new Bundle();
        args.putInt(SongUtils.SONG_ID_KEY, selectedSong);
        fragment.setArguments(args);
        return fragment;
    }
}
