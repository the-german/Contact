package com.example.thegerman.mycontact.utils;

import android.content.Context;

import com.example.thegerman.mycontact.R;
import com.nostra13.universalimageloader.cache.memory.impl.WeakMemoryCache;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.ImageScaleType;
import com.nostra13.universalimageloader.core.display.FadeInBitmapDisplayer;

public class UniversalImageLoader {
    private static final int defaultImage = R.drawable.ic_launcher_background;
    private Context mContext;

    public UniversalImageLoader(Context mContext) {
        this.mContext = mContext;
    }

    public ImageLoaderConfiguration imageLoaderConfiguration(){
        // Setup Universal Loader Configuration
        DisplayImageOptions displayImageOptions = new DisplayImageOptions.Builder()
                .showImageOnLoading(defaultImage)
                .showImageForEmptyUri(defaultImage)
                .showImageOnFail(defaultImage)
                .cacheOnDisk(true).cacheInMemory(true)
                .cacheOnDisk(true).resetViewBeforeLoading(true)
                .imageScaleType(ImageScaleType.EXACTLY)
                .displayer(new FadeInBitmapDisplayer(300)).build();

        ImageLoaderConfiguration imageLoaderConfiguration = new ImageLoaderConfiguration.Builder(mContext)
                .defaultDisplayImageOptions(displayImageOptions)
                .memoryCache(new WeakMemoryCache())
                .diskCacheSize(100 * 1024 * 1024)
                .build();

        return imageLoaderConfiguration;
    }
}
