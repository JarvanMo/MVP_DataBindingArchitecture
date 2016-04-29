package com.jarvanmo.myapplication.ui.presenter;

import com.jarvanmo.mframework.ui.presenter.BasePresenter;
import com.jarvanmo.myapplication.domain.biz.getimage.GetImageBizIml;
import com.jarvanmo.myapplication.domain.biz.getimage.OnGetImageListener;
import com.jarvanmo.myapplication.ui.view.testadapter.ITestAdapterView;
import com.jarvanmo.myapplication.ui.viewmodel.AdapterViewModel;

import java.util.ArrayList;

import javax.inject.Inject;

/**
 * Created by mo on 16-4-29.
 *
 * @author mo
 */
public class TestAdapterPresenter implements BasePresenter<ITestAdapterView> {

    private GetImageBizIml mGetImage;
    private ITestAdapterView mView;

    @Inject
    public TestAdapterPresenter(GetImageBizIml getImageBizIml) {

        mGetImage = getImageBizIml;

    }

    public void loadData() {

        mGetImage.getImage("zxy", new OnGetImageListener() {
            @Override
            public void onLoadStart() {
                mView.startLoadData();
            }

            @Override
            public void onLoadComplete(ArrayList<AdapterViewModel> imageList) {

                mView.onLoadComplete(imageList);
            }
        });
    }


    public void loadMore() {

        mGetImage.getImage("zxy", new OnGetImageListener() {
            @Override
            public void onLoadStart() {
                mView.startLoadData();
            }

            @Override
            public void onLoadComplete(ArrayList<AdapterViewModel> imageList) {

                mView.onLoadComplete(imageList);
            }
        });

    }


    @Override
    public void attachView(ITestAdapterView view) {

        mView = view;
    }

    @Override
    public void detachView(boolean retainInstance) {

    }
}
