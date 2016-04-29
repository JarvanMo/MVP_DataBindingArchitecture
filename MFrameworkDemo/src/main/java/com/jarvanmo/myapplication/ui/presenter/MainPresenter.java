package com.jarvanmo.myapplication.ui.presenter;

import com.jarvanmo.mframework.ui.presenter.BasePresenter;
import com.jarvanmo.myapplication.app.scope.ActivityScope;
import com.jarvanmo.myapplication.domain.biz.signin.ISignInBiz;
import com.jarvanmo.myapplication.domain.biz.signin.OnSignInListener;
import com.jarvanmo.myapplication.domain.model.User;
import com.jarvanmo.myapplication.ui.view.main.IMainView;
import com.jarvanmo.myapplication.ui.viewmodel.MainViewModel;

/**
 * Created by mo on 16-4-26.
 *
 */
@ActivityScope
public class MainPresenter implements BasePresenter<IMainView> {

    private ISignInBiz mSignInBiz;
    private IMainView mMainView;

    public MainPresenter(ISignInBiz signInBiz){
        mSignInBiz = signInBiz;
    }

    public void signIn(User user) {

        mMainView.showLoading("begin sign in");
        mSignInBiz.signIn(user, new OnSignInListener() {
            @Override
            public void onSignSuccess(User user) {

                MainViewModel viewModel = new MainViewModel();
                viewModel.setUserName(user.getUserName());
                viewModel.setPassword(user.getPassword());
                mMainView.onLoadUserInfoSuccess(viewModel);
                mMainView.endLoading();
            }

            @Override
            public void onSignFailed(String message) {
                mMainView.onLoadUserInfoFailed(message);
                mMainView.endLoading();
            }
        });
    }

    @Override
    public void attachView(IMainView view) {
        mMainView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {

    }
}
