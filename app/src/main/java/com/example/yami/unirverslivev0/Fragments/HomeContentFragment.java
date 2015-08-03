package com.example.yami.unirverslivev0.Fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.yami.unirverslivev0.R;

/**
 * Created by Yami on 7/27/2015.
 */
public class HomeContentFragment  extends Fragment {
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.home_content_fragment,container,false);
        return v;
    }
}