package com.jarvanmo.myapplication.app.component;

import com.jarvanmo.myapplication.app.module.TestAdapterActivityModule;
import com.jarvanmo.myapplication.app.scope.ActivityScope;
import com.jarvanmo.myapplication.ui.activity.TestAdapterActivity;

import dagger.Component;

/**
 * Created by mo on 16-4-29.
 *
 * @author mo
 */

@ActivityScope
@Component(dependencies = AppComponent.class, modules = {TestAdapterActivityModule.class})
public interface TestAdapterComponent {
    void inject(TestAdapterActivity activity);
}
