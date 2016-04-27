package com.jarvanmo.myapplication.domain.api;

import com.jarvanmo.myapplication.domain.model.User;

import java.util.List;

import retrofit2.Callback;
import retrofit2.http.GET;

/**
 * Created by mo on 16-4-27.
 *
 */
public interface ApiService {

    @GET("/users")
    void getUser(Callback<List<User>> callBack);
}
