package com.jarvanmo.myapplication.app.module;

import android.databinding.DataBindingUtil;

import com.jarvanmo.myapplication.R;
import com.jarvanmo.myapplication.app.DemoBaseActivity;
import com.jarvanmo.myapplication.app.scope.ActivityScope;
import com.jarvanmo.myapplication.databinding.ActivityMainBinding;
import com.jarvanmo.myapplication.ui.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mo on 16-4-26.
 *
 * @author mo
 */
@Module
public class ActivityModule {

    private final DemoBaseActivity activity;

    public ActivityModule(DemoBaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    @ActivityScope
    DemoBaseActivity activity() {
        return activity;
    }


    @Provides
    MainPresenter providePresenter() {

        return new MainPresenter();
    }

    @Provides
    ActivityMainBinding provideActivityMainBinding() {
        return DataBindingUtil.setContentView(activity, R.layout.activity_main);
    }

}
