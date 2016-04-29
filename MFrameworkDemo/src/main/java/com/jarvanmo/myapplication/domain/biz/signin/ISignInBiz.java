package com.jarvanmo.myapplication.domain.biz.signin;

import com.jarvanmo.myapplication.domain.model.User;

/**
 * Created by mo on 16-4-26.
 *
 */
public interface ISignInBiz {
    boolean signIn(User user, OnSignInListener onSignInListener);
}
