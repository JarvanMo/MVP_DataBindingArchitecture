package com.jarvanmo.myapplication.ui.viewmodel;

import android.databinding.BaseObservable;
import android.databinding.Bindable;

/**
 * Created by mo on 16-4-26.
 * @author mo
 */
public class MainViewModel extends BaseObservable {


    @Bindable
    private String userName;
    @Bindable
    private String password;

    public String getUserName() {
        return userName;
    }


    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
