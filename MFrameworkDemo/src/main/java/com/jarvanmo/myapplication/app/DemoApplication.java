package com.jarvanmo.myapplication.app;

import com.jarvanmo.mframework.app.BaseApplication;
import com.jarvanmo.myapplication.app.component.AppComponent;
import com.jarvanmo.myapplication.app.component.DaggerAppComponent;
import com.jarvanmo.myapplication.app.module.AppModule;
import com.jarvanmo.myapplication.domain.api.ApiServiceModule;

/**
 * Created by mo on 16-4-27.
 *
 * @author mo
 */
public class DemoApplication extends BaseApplication {

    private static DemoApplication mDemoApplication;
    private AppComponent mAppComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        mDemoApplication = (DemoApplication) getApplicationContext();
        mAppComponent = DaggerAppComponent.builder()//
                .appModule(new AppModule(this))//
                .apiServiceModule(new ApiServiceModule())
                .build();
    }

    public static DemoApplication getInstance() {
        return mDemoApplication;
    }


    public AppComponent getAppComponent(){
        return mAppComponent;
    }
}
