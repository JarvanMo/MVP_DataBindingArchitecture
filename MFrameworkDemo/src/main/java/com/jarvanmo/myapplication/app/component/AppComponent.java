package com.jarvanmo.myapplication.app.component;

import android.content.Context;

import com.jarvanmo.myapplication.app.AppContext;
import com.jarvanmo.myapplication.app.module.AppModule;
import com.jarvanmo.myapplication.domain.api.ApiService;
import com.jarvanmo.myapplication.domain.api.ApiServiceModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;

/**
 * Created by mo on 16-4-27.
 *
 */
@Singleton
@Component(modules = {AppModule.class, ApiServiceModule.class})
public interface AppComponent {

    @AppContext
    @Singleton
    Context context();

    ApiService getApiService();


}
