package com.example.yami.unirverslivev0.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yami.unirverslivev0.Activity.MainActivity;
import com.example.yami.unirverslivev0.R;

/**
 * Created by Admin on 04-06-2015.
 */
public class MesVideoContentFragment extends Fragment {

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        ((MainActivity) getActivity())
                .setActionBarTitle("Mes Video");
        View v = inflater.inflate(R.layout.mevideo_content_fragment,container,false);
        return v;
    }

}
