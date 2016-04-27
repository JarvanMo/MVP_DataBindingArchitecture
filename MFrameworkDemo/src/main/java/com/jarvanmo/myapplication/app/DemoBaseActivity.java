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
 * a demo
 */
public abstract class DemoBaseActivity extends BaseActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setupActivityComponent(DemoApplication.getInstance().getAppComponent());
    }


    protected abstract void setupActivityComponent(AppComponent appComponent);
}
