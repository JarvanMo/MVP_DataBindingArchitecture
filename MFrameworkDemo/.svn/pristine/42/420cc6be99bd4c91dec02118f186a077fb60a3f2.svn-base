package com.jarvanmo.myapplication.app.module;

import android.app.ProgressDialog;
import android.content.Context;

import com.jarvanmo.myapplication.app.ActivityContext;
import com.jarvanmo.myapplication.domain.biz.getimage.GetImageBizIml;
import com.jarvanmo.myapplication.ui.activity.TestAdapterActivity;
import com.jarvanmo.myapplication.ui.presenter.TestAdapterPresenter;

import dagger.Module;
import dagger.Provides;

/**
 * Created by mo on 16-4-29.
 *
 * @author mo
 */
@Module
public class TestAdapterActivityModule {

    TestAdapterActivity mActivity;


    public TestAdapterActivityModule(TestAdapterActivity testAdapterActivity) {
        mActivity = testAdapterActivity;
    }

    @Provides
    public TestAdapterPresenter provideTestAdapterPresenter(GetImageBizIml getImageBizIml) {

        return new TestAdapterPresenter(getImageBizIml);
    }


    @ActivityContext
    @Provides
    Context provideContext() {
        return mActivity;
    }

    @Provides
    ProgressDialog provideProgressDialog(@ActivityContext Context context) {

        return new ProgressDialog(context);
    }
}
