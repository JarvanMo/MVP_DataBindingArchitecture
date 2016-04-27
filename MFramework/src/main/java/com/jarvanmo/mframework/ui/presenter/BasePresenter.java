package com.jarvanmo.mframework.ui.presenter;

import com.jarvanmo.mframework.ui.view.BaseMvpView;

/**
 * @author mo
 * base presenter
 */
public interface BasePresenter<V extends BaseMvpView> {

    void attachView(V view);
    void detachView(boolean retainInstance);
}
