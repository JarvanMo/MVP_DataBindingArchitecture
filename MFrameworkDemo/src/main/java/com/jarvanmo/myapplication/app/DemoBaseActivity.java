package com.jarvanmo.myapplication.app;

import android.os.Bundle;

import com.jarvanmo.mframework.ui.activity.BaseActivity;
import com.jarvanmo.mframework.ui.presenter.BasePresenter;
import com.jarvanmo.mframework.ui.view.BaseMvpView;
import com.jarvanmo.myapplication.app.component.ActivityComponent;
import com.jarvanmo.myapplication.app.component.AppComponent;
import com.jarvanmo.myapplication.app.component.DaggerActivityComponent;
import com.jarvanmo.myapplication.app.component.DaggerAppComponent;
import com.jarvanmo.myapplication.app.module.ActivityModule;
import com.jarvanmo.myapplication.app.module.AppModule;

/**
 * Created by mo on 16-4-27.
 *
 *
 */
public abstract  class DemoBaseActivity<V extends BaseMvpView ,P extends BasePresenter<V>> extends BaseActivity<V,P> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        startInject();
        super.onCreate(savedInstanceState);
    }


    protected ActivityComponent getActivityComponent(){

        return DaggerActivityComponent.builder().appComponent(getAppComponent()).activityModule(getActivityModule()).build();
    }


    protected ActivityModule getActivityModule(){

        return new ActivityModule(this);
    }

    protected AppComponent getAppComponent(){
        return DaggerAppComponent.builder().appModule(new AppModule((DemoApplication) getApplicationContext())).build();
    }

    protected abstract  void startInject();
}
