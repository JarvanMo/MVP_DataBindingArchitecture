package com.jarvanmo.myapplication.ui.presenter;

import com.jarvanmo.mframework.ui.presenter.BasePresenter;
import com.jarvanmo.myapplication.domain.biz.ISignIn.ISignInBiz;
import com.jarvanmo.myapplication.domain.biz.ISignIn.OnSignInListener;
import com.jarvanmo.myapplication.domain.biz.ISignIn.SignInBizIml;
import com.jarvanmo.myapplication.domain.model.User;
import com.jarvanmo.myapplication.ui.view.main.IMainView;
import com.jarvanmo.myapplication.ui.viewmodel.MainViewModel;

/**
 * Created by mo on 16-4-26.
 *
 */
public class MainPresenter implements BasePresenter<IMainView> {

    private ISignInBiz signInBiz = new SignInBizIml();
    private IMainView mainView;


    public void signIn(User user) {

        mainView.showLoading("begin sign in");
        signInBiz.signIn(user, new OnSignInListener() {
            @Override
            public void onSignSuccess(User user) {

                MainViewModel viewModel = new MainViewModel();
                viewModel.setUserName(user.getUserName());
                viewModel.setPassword(user.getPassword());
                mainView.onLoadUserInfoSuccess(viewModel);
                mainView.endLoading();
            }

            @Override
            public void onSignFailed(String message) {
                mainView.onLoadUserInfoFailed(message);
                mainView.endLoading();
            }
        });
    }

    @Override
    public void attachView(IMainView view) {
        mainView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {

    }
}
