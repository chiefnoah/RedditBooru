package com.redditbooru.android.Fragments;


import android.os.Bundle;
import android.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.CookieManager;
import android.widget.GridLayout;
import android.widget.GridView;
import android.widget.TextView;

import com.google.gson.Gson;
import com.redditbooru.android.Adapters.GalleryAdapter;
import com.redditbooru.android.Beans.OImage;
import com.redditbooru.android.Interfaces.IRequestCallback;
import com.redditbooru.android.R;
import com.redditbooru.android.Tasks.ImageSearchTask;
import com.redditbooru.android.Util.Constants;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * A simple {@link Fragment} subclass.
 */
public class GalleryFragment extends Fragment implements IRequestCallback {

    GalleryAdapter galleryAdapter;
    GridView rootView;

    //private ArrayList<OImage> images;
    public GalleryFragment() {
        // Required empty public constructor
        //images = new ArrayList<OImage>();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        String cookie = CookieManager.getInstance().getCookie(Constants.REDDITBOORU_URL);
        cookie = cookie !=null ? cookie: "";
        ImageSearchTask imageTask = new ImageSearchTask(this, cookie);
        HashMap<String, String> requestParams = new HashMap<>();
        //requestParams.put("limit", "15");
        imageTask.execute(requestParams);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        rootView = (GridView)inflater.inflate(R.layout.fragment_gallery, container, false);
        galleryAdapter = new GalleryAdapter(getActivity(), R.id.gallery_grid_view, new ArrayList<OImage>());
        rootView.setAdapter(galleryAdapter);

        return rootView;
    }

    @Override
    public void OnJsonReceived(String json) {
        Gson gson = new Gson();

        OImage[] imagesArray = gson.fromJson(json, OImage[].class);
        for(OImage image : imagesArray) {
            galleryAdapter.add(image);
        }
    }
}
