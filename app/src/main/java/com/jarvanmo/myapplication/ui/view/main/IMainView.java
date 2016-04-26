package com.jarvanmo.myapplication.ui.view.main;

import com.jarvanmo.mframework.ui.view.BaseMvpView;
import com.jarvanmo.myapplication.domain.model.User;
import com.jarvanmo.myapplication.ui.viewmodel.MainViewModel;

/**
 * Created by mo on 16-4-26.
 *
 */
public interface IMainView extends BaseMvpView {

    void loadUserInfoStart();
    void onLoadUserInfoComplete(MainViewModel viewModel);


}
