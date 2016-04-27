package com.jarvanmo.myapplication.app.module;

import android.databinding.DataBindingUtil;

import com.jarvanmo.myapplication.R;
import com.jarvanmo.myapplication.databinding.ActivityMainBinding;
import com.jarvanmo.myapplication.ui.activity.MainActivity;
import com.jarvanmo.myapplication.ui.presenter.MainPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mo on 16-4-27.
 *
 */
@Module
public class MainActivityModule {

    MainActivity mMainActivity;


    public MainActivityModule(MainActivity mainActivity){
        this.mMainActivity = mainActivity;
    }

    MainActivity activity(){
        return mMainActivity;
    }

    @Provides
    MainPresenter providePresenter() {

        return new MainPresenter();
    }

    @Provides
    ActivityMainBinding provideActivityMainBinding() {
        return DataBindingUtil.setContentView(mMainActivity, R.layout.activity_main);
    }
}
