package com.jarvanmo.myapplication.ui.activity;

import android.app.ProgressDialog;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.ProgressBar;

import com.jarvanmo.mframework.util.MToast;
import com.jarvanmo.myapplication.R;
import com.jarvanmo.myapplication.app.DemoBaseActivity;
import com.jarvanmo.myapplication.databinding.ActivityMainBinding;
import com.jarvanmo.myapplication.domain.model.User;
import com.jarvanmo.myapplication.ui.presenter.MainPresenter;
import com.jarvanmo.myapplication.ui.view.main.IMainView;
import com.jarvanmo.myapplication.ui.viewmodel.MainViewModel;

import javax.inject.Inject;

public class MainActivity extends DemoBaseActivity<IMainView, MainPresenter> implements IMainView {


    @Inject
    MainPresenter mPresenter;

    @Inject
    ActivityMainBinding activityMainBinding;

    ProgressDialog mProgressDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(mPresenter != null){
            MToast.showToast("inject ok");
            mPresenter.attachView(this);
        }

        activityMainBinding.signIn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User user = new User();
                user.setUserName(activityMainBinding.userName.getText().toString().trim());
                user.setPassword(activityMainBinding.password.getText().toString().trim());
                mPresenter.signIn(user);
            }
        });

        mProgressDialog  = new ProgressDialog(this);

    }

    @Override
    protected void startInject() {
        getActivityComponent().inject(this);
    }


    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return mPresenter;
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
