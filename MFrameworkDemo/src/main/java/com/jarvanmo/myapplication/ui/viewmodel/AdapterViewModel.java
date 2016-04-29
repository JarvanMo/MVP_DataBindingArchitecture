package com.jarvanmo.myapplication.ui.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by mo on 16-4-29.
 *
 * @author mo
 */
public class AdapterViewModel extends BaseObservable{

    @Bindable
    private String time;
    private String imageUrl;

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }
}
