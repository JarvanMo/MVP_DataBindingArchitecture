package com.jarvanmo.myapplication.domain.api;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by mo on 16-4-27.
 *
 * @author mo
 */
@Module
public class ApiServiceModule {

    private static final String BASE_URL = "http://listen.api.tton.co/";

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient() {

        return new OkHttpClient.Builder()//
                .connectTimeout(10 * 1000, TimeUnit.MILLISECONDS)//
                .readTimeout(10 * 1000, TimeUnit.MILLISECONDS)//
                .build();
    }

    @Provides
    @Singleton
    ApiService provideApiService(OkHttpClient okHttpClient) {

        Retrofit retrofit = new Retrofit.Builder().client(okHttpClient).addConverterFactory(GsonConverterFactory.create()).baseUrl(BASE_URL).build();

        return retrofit.create(ApiService.class);
    }

}
