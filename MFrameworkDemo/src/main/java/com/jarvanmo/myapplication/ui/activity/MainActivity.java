package com.jarvanmo.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.jarvanmo.mframework.util.MToast;
import com.jarvanmo.myapplication.app.DemoBaseActivity;
import com.jarvanmo.myapplication.app.component.AppComponent;
import com.jarvanmo.myapplication.app.component.DaggerMainActivityComponent;
import com.jarvanmo.myapplication.app.module.MainActivityModule;
import com.jarvanmo.myapplication.app.scope.ActivityScope;
import com.jarvanmo.myapplication.databinding.ActivityMainBinding;
import com.jarvanmo.myapplication.domain.model.User;
import com.jarvanmo.myapplication.ui.presenter.MainPresenter;
import com.jarvanmo.myapplication.ui.view.main.IMainView;
import com.jarvanmo.myapplication.ui.viewmodel.MainViewModel;

import javax.inject.Inject;

@ActivityScope
public class MainActivity extends DemoBaseActivity implements IMainView {


    @Inject
    MainPresenter mPresenter;

    @Inject
    ActivityMainBinding activityMainBinding;

    private ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

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

        activityMainBinding.toNextBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, TestAdapterActivity.class);
                startActivity(intent);
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
        MToast.show("Sign In Success");
    }

    @Override
    public void onLoadUserInfoFailed(String message) {
        showToast(message);
    }


}
