package com.example.ravi.image_title_firebase;

import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;
import android.widget.EditText;

import com.example.ravi.image_title_firebase.mFirebase.FireBaseClient;

public class MainActivity extends AppCompatActivity {


    final static String DB_URL="https://bimsapp-81da4.firebaseio.com/";
    EditText name_edit,url_edit;
    Button savebtn;
    RecyclerView rv;
    FireBaseClient fireBaseClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv=(RecyclerView) findViewById(R.id.my_recycler_view);
        rv.setLayoutManager(new LinearLayoutManager(this));

        fireBaseClient=new FireBaseClient(this,DB_URL,rv);

        fireBaseClient.refreshData();



    }

    //show inout dialog

    private void displayDialog()
    {
        Dialog d=new Dialog(this);
        d.setTitle("save online");
        d.setContentView(R.layout.dialoglayout);

//        name_edit=(EditText) findViewById(R.id.name_title);
//        url_edit=(EditText) findViewById(R.id.url_name);
//        savebtn=(Button) findViewById(R.id.savebtn);

    }


}
