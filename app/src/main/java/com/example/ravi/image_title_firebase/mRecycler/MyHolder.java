package com.example.ravi.image_title_firebase.mRecycler;

import android.media.Image;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ravi.image_title_firebase.R;

/**
 * Created by ravi on 9/2/17.
 */

public class MyHolder extends RecyclerView.ViewHolder {

    TextView nametxt;
    ImageView img;


    public MyHolder(View itemView) {
        super(itemView);

        nametxt =(TextView) itemView.findViewById(R.id.name_title);
        img =(ImageView) itemView.findViewById(R.id.imageView);
    }
}
