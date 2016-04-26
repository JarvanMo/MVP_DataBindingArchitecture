package com.jarvanmo.myapplication.ui.activity;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.jarvanmo.mframework.ui.activity.BaseActivity;
import com.jarvanmo.myapplication.R;
import com.jarvanmo.myapplication.domain.model.User;
import com.jarvanmo.myapplication.ui.presenter.MainPresenter;
import com.jarvanmo.myapplication.ui.view.main.IMainView;
import com.jarvanmo.myapplication.ui.viewmodel.MainViewModel;

public class MainActivity extends BaseActivity<IMainView,MainPresenter> implements IMainView {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return null;
    }


    @Override
    public void loadUserInfoStart() {

    }

    @Override
    public void onLoadUserInfoComplete(MainViewModel viewModel) {

    }
}
