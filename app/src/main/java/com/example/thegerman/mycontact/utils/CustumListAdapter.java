package com.example.thegerman.mycontact.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ProgressBar;
import android.widget.TextView;


import com.example.thegerman.mycontact.R;
import com.example.thegerman.mycontact.models.Contacts;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.assist.FailReason;
import com.nostra13.universalimageloader.core.listener.ImageLoadingListener;

import java.util.ArrayList;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class CustumListAdapter extends ArrayAdapter<Contacts> {
    private LayoutInflater layoutInflater;
    private List<Contacts> contactsList = null;
    private ArrayList<Contacts> arrayList; // Used for search bar
    private int layoutRessource;
    private Context mContext;
    private String mAppend;
    public CustumListAdapter( Context context, int resource,  List<Contacts> objects,String append) {
        super(context, resource, objects);

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutRessource = resource;
        this.mContext = context;
        mAppend = append;
        this.contactsList = objects;
        arrayList  = new ArrayList<>();
        this.arrayList.addAll(contactsList);

    }

    private static class ViewHolder{
        TextView name;
        CircleImageView contactImage;
        ProgressBar mProgressbar;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
//        Create the view
        final ViewHolder holder;

        if (convertView == null){
            convertView = layoutInflater.inflate(layoutRessource,parent,false);
            holder = new ViewHolder();

            //******************************************************************
            //Stuff to change
            //******************************************************************
            holder.name = convertView.findViewById(R.id.contactName);
            holder.contactImage = convertView.findViewById(R.id.contactImage);
            holder.mProgressbar = convertView.findViewById(R.id.contactProgressBar);
            //******************************************************************
            //Stuff to change
            //******************************************************************

            convertView.setTag(holder);
        }else{
            holder = (ViewHolder) convertView.getTag();
            //******************************************************************
            //Stuff to change
            //******************************************************************
            String name_ = getItem(position).getName();
            String imagePath = getItem(position).getProfileImage();
            holder.name.setText(name_);
            ImageLoader imageLoader = ImageLoader.getInstance();
            imageLoader.displayImage(mAppend + imagePath, holder.contactImage, new ImageLoadingListener() {
                @Override
                public void onLoadingStarted(String imageUri, View view) {
                    holder.mProgressbar.setVisibility(View.VISIBLE);
                }

                @Override
                public void onLoadingFailed(String imageUri, View view, FailReason failReason) {
                    holder.mProgressbar.setVisibility(View.GONE);

                }

                @Override
                public void onLoadingComplete(String imageUri, View view, Bitmap loadedImage) {
                    holder.mProgressbar.setVisibility(View.GONE);

                }

                @Override
                public void onLoadingCancelled(String imageUri, View view) {
                    holder.mProgressbar.setVisibility(View.GONE);

                }
            });
        }

        return convertView;

    }
}
