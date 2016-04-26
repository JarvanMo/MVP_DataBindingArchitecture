package com.jarvanmo.mframework.ui.activity;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.view.LayoutInflater;
import android.view.View;

import com.hannesdorfmann.mosby.mvp.MvpActivity;
import com.jarvanmo.mframework.ui.presenter.BasePresenter;
import com.jarvanmo.mframework.ui.view.BaseMvpView;

/**
 * Created by mo on 16-4-26.
 *
 */
public abstract class BaseActivity<V extends BaseMvpView, P extends BasePresenter<V>> extends MvpActivity<V, P> {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    protected boolean isAppFontSizeControlledByOs(){
        return true;
    }

    @Override
    public Resources getResources() {
        if(isAppFontSizeControlledByOs()) {
            return super.getResources();
        }else {

            Resources resources = super.getResources();
            Configuration configuration = new Configuration();
            configuration.setToDefaults();
            resources.updateConfiguration(configuration,resources.getDisplayMetrics());

            return  resources;
        }
    }

}
