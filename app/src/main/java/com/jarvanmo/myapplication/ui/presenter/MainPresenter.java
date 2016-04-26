package com.jarvanmo.myapplication.ui.presenter;

import com.jarvanmo.mframework.ui.presenter.BasePresenter;
import com.jarvanmo.myapplication.domain.biz.ISignIn.ISignInBiz;
import com.jarvanmo.myapplication.domain.biz.ISignIn.OnSignInListener;
import com.jarvanmo.myapplication.domain.model.User;
import com.jarvanmo.myapplication.ui.view.main.IMainView;
import com.jarvanmo.myapplication.ui.viewmodel.MainViewModel;

/**
 * Created by mo on 16-4-26.
 *
 *
 */
public class MainPresenter extends BasePresenter<IMainView>{

    private ISignInBiz signInBiz;
    private IMainView mainView = getView();

    public void getNameAndPassword(User user){
        signInBiz.signIn(user, new OnSignInListener() {
            @Override
            public void onSignSuccess(User user) {

                MainViewModel viewModel = new MainViewModel();
                viewModel.setUserName(user.getUserName());
                viewModel.setPassword(user.getPassword());
                mainView.onLoadUserInfoComplete(viewModel);
            }

            @Override
            public void onSignFailed(String message) {

            }
        });
    }
}
