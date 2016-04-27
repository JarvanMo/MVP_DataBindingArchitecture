package com.jarvanmo.myapplication.app.component;

import android.app.Activity;

import com.jarvanmo.myapplication.app.DemoBaseActivity;
import com.jarvanmo.myapplication.app.module.ActivityModule;
import com.jarvanmo.myapplication.app.scope.ActivityScope;
import com.jarvanmo.myapplication.ui.activity.MainActivity;

import dagger.Component;

/**
 * Created by mo on 16-4-26.
 *
 */

@ActivityScope
@Component(dependencies =  AppComponent.class, modules = {ActivityModule.class})
public interface ActivityComponent {

    DemoBaseActivity activity();

    void inject(MainActivity activity);
}
