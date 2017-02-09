package com.example.ravi.image_title_firebase.mRecycler;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.ravi.image_title_firebase.R;
import com.example.ravi.image_title_firebase.mData.Menus;
import com.example.ravi.image_title_firebase.mPicasso.PicassoClient;

import java.util.ArrayList;

/**
 * Created by ravi on 9/2/17.
 */

public class MyAdapter extends RecyclerView.Adapter<MyHolder> {

    Context c;
    ArrayList<Menus> menu;

    public MyAdapter(Context c, ArrayList<Menus> menu){

        this.c=c;
        this.menu=menu;
    }



    @Override
    public MyHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v= LayoutInflater.from(parent.getContext()).inflate(R.layout.model,parent,false);
        MyHolder holder=new MyHolder(v);
        return holder;
    }

    @Override
    public void onBindViewHolder(MyHolder holder, int position) {
        holder.nametxt.setText(menu.get(position).getName());

        PicassoClient.downloadIamge(c,menu.get(position).getUrl(),holder.img);

    }

    @Override
    public int getItemCount() {
        return menu.size();
    }
}
