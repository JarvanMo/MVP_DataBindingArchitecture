package com.jarvanmo.mframework.ui.presenter;

import com.hannesdorfmann.mosby.mvp.MvpPresenter;
import com.jarvanmo.mframework.ui.view.BaseMvpView;

/**
 * @author mo
 */
public  interface BasePresenter<V extends BaseMvpView> extends MvpPresenter<V> {
}
