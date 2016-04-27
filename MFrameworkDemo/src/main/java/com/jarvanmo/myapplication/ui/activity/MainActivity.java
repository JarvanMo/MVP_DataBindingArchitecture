package com.jarvanmo.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.view.View;

import com.jarvanmo.mframework.util.MToast;
import com.jarvanmo.myapplication.app.DemoBaseActivity;
import com.jarvanmo.myapplication.app.Test;
import com.jarvanmo.myapplication.app.component.AppComponent;
import com.jarvanmo.myapplication.app.component.DaggerMainActivityComponent;
import com.jarvanmo.myapplication.app.module.MainActivityModule;
import com.jarvanmo.myapplication.databinding.ActivityMainBinding;
import com.jarvanmo.myapplication.domain.api.ApiService;
import com.jarvanmo.myapplication.domain.model.User;
import com.jarvanmo.myapplication.ui.presenter.MainPresenter;
import com.jarvanmo.myapplication.ui.view.main.IMainView;
import com.jarvanmo.myapplication.ui.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends DemoBaseActivity implements IMainView {


    @Inject
    MainPresenter mPresenter;
    @Inject
    ActivityMainBinding activityMainBinding;
    @Inject
    ApiService apiService;
    @Inject
    Test test;

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (test != null) {
            MToast.showToast("inject ok");
        }

        mPresenter.attachView(this);

        activityMainBinding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUserName(activityMainBinding.userName.getText().toString().trim());
                user.setPassword(activityMainBinding.password.getText().toString().trim());
                mPresenter.signIn(user);
            }
        });

        mProgressDialog = new ProgressDialog(this);

    }

    @Override
    protected void setupActivityComponent(AppComponent appComponent) {
        DaggerMainActivityComponent.builder().appComponent(appComponent).mainActivityModule(new MainActivityModule(this)).build().inject(this);

    }


    @Override
    public void showLoading(String message) {

        mProgressDialog.setMessage(message);
        mProgressDialog.show();
    }

    @Override
    public void endLoading() {
        mProgressDialog.dismiss();
    }

    @Override
    public void onLoadUserInfoSuccess(MainViewModel viewModel) {

        activityMainBinding.setUserInfo(viewModel);
        MToast.showToast("Sign In Success");
    }

    @Override
    public void onLoadUserInfoFailed(String message) {
        showToast(message);
    }
}
