package com.example.ravi.image_title_firebase.mPicasso;

import android.content.Context;
import android.widget.ImageView;

import com.example.ravi.image_title_firebase.R;
import com.squareup.picasso.Picasso;

/**
 * Created by ravi on 9/2/17.
 */

public class PicassoClient {

    public static void downloadIamge(Context c, String url, ImageView img)
    {
      if(url !=null && url.length()>0)
      {
          Picasso.with(c).load(url).placeholder(R.drawable.ravi).into(img);

      }else {

          Picasso.with(c).load(R.drawable.ravi).into(img);
      }




    }



}
