package com.redditbooru.android.Adapters;

import android.content.Context;
import android.content.res.Resources;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.redditbooru.android.Beans.OImage;
import com.redditbooru.android.R;
import com.redditbooru.android.Util.Constants;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by peder_000 on 4/4/2015.
 */
public class GalleryAdapter extends ArrayAdapter<OImage> {


    public GalleryAdapter(Context c, int viewId, ArrayList<OImage> data) {
        super(c, viewId, data);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LinearLayout rootView;
        ViewHolder viewHolder;

        if(convertView == null) {
            rootView = new LinearLayout(getContext());
            //Inflate the generated view
            String inflater = Context.LAYOUT_INFLATER_SERVICE;
            LayoutInflater layoutInflater = (LayoutInflater)getContext().getSystemService(inflater);
            layoutInflater.inflate(R.layout.gallery_item, rootView, true);
            viewHolder = new ViewHolder(); //Create an instance of our viewHolder

            //Set the view references in the viewholder
            viewHolder.image = (ImageView)rootView.findViewById(R.id.gallery_item_thumbnail_image_view);
            viewHolder.sourceTextView = (TextView)rootView.findViewById(R.id.gallery_item_source_text_view);
            viewHolder.upvotesTextView = (TextView)rootView.findViewById(R.id.gallery_item_upvotes_text_view);

            rootView.setTag(viewHolder);
        } else {
            rootView = (LinearLayout) convertView;
            viewHolder = (ViewHolder) rootView.getTag();
        }

        /// Converts 14 dip into its equivalent px

        Resources r = getContext().getResources();
        int px = (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 150, r.getDisplayMetrics());

        //It should be possible to dynamically choose exactly which size image we need here, but I'll look into it later
            Uri thumbnailUri = Uri.parse(Constants.REDDITBOORU_URL + getItem(position).getThumb() + "-_" + px + "_" + px + ".jpg");
        Picasso.with(viewHolder.image.getContext()).load(thumbnailUri).fit().into(viewHolder.image);
        viewHolder.sourceTextView.setText(getItem(position).getSourceName());
        String score = getItem(position).getScore() + "";
        viewHolder.upvotesTextView.setText(score);

        return rootView;
    }

    private class ViewHolder {
        public ImageView image;
        public TextView upvotesTextView;
        public TextView sourceTextView;
    }
}
