package com.example.ravi.image_title_firebase.mFirebase;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import com.example.ravi.image_title_firebase.mData.Menus;
import com.example.ravi.image_title_firebase.mRecycler.MyAdapter;
import com.firebase.client.ChildEventListener;
import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.ArrayList;

/**
 * Created by ravi on 9/2/17.
 */

public class FireBaseClient {

    Context c;
    String DB_URL;
    RecyclerView rv;
    Firebase firebase;
    ArrayList<Menus> menu=new ArrayList<>();
    MyAdapter adapter;

    public FireBaseClient(Context c, String DB_URL, RecyclerView rv){

        this.c=c;
        this.DB_URL=DB_URL;
        this.rv=rv;

        //initialise
        firebase.setAndroidContext(c);
        //instantiate
        firebase=new Firebase(DB_URL);

    }

    //save
    public void saveOnline(String p,String url)
    {
        Menus m=new Menus();
        m.setName(p);
        m.setUrl(url);
        firebase.child("Menu").push().setValue(m);
    }

    //retrieve

    public void refreshData()
    {
        firebase.addChildEventListener(new ChildEventListener() {
            @Override
            public void onChildAdded(DataSnapshot dataSnapshot, String s) {
                getUpdates(dataSnapshot);

            }

            @Override
            public void onChildChanged(DataSnapshot dataSnapshot, String s) {

                getUpdates(dataSnapshot);
            }

            @Override
            public void onChildRemoved(DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(DataSnapshot dataSnapshot, String s) {

            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });

    }

    private void getUpdates(DataSnapshot dataSnapshot)
    {
        menu.clear();
        for (DataSnapshot ds : dataSnapshot.getChildren())
        {
            Menus m=new Menus();
            m.setName(ds.getValue(Menus.class).getName());
            m.setUrl(ds.getValue(Menus.class).getUrl());
            menu.add(m);

        }
        if(menu.size()>0)
        {
            adapter=new MyAdapter(c,menu);
            rv.setAdapter(adapter);

        }else {

            Toast.makeText(c,"No data",Toast.LENGTH_SHORT).show();
        }

    }




}
